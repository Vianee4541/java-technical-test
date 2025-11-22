package audit.AuditService.controller;

import audit.AuditService.model.User;
import audit.AuditService.model.UserEntity;
import audit.AuditService.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;


@Component
public class AuditConsumer {
    @Autowired
    private AuditService auditService;

    @KafkaListener(
            topics = "user-events",
            groupId = "group_id"
    )
    @RetryableTopic(
            attempts = "3",
            autoCreateTopics = "true",
            backOff = @BackOff(delay = 1000, multiplier = 2.0),
            dltTopicSuffix = "-dlt"
    )

    public void ConsumeUserCreate(String message)  {
        try {
            if (message.contains("error")){
                throw new RuntimeException("Error message: " + message);
            }
            User user = new ObjectMapper().readValue(message, User.class);

            UserEntity userEntity = new UserEntity();
            userEntity.setName(user.getName());
            userEntity.setEmail(user.getEmail());
            auditService.saveUser(userEntity);

            System.out.println("User created successfully");
        } catch (Exception e) {
            throw new RuntimeException("Failed to process message: " + message, e);
        }

    }

    @KafkaListener(topics = "user-events-dlt", groupId = "dead-letter-group-id")
    public void DeadLetterConsumer(String message) {
        System.out.println("Dead-letter message: " + message);
    }
}
