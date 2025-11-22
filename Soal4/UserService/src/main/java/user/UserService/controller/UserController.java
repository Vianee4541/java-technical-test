package user.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user.UserService.model.User;

import java.util.UUID;

@RestController
public class UserController {
    @Autowired
        private KafkaTemplate<String, User> kafkaTemplate;

        private static final String userEventTopic = "user-events";

        @PostMapping("/users")
        public ResponseEntity<String> createUser(@RequestBody User user) {
            User newUser = new User(user.getName(), user.getEmail());
            kafkaTemplate.send(userEventTopic, newUser);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("User created successfully");
        }


}
