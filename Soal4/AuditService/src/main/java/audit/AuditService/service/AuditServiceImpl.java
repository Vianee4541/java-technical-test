package audit.AuditService.service;

import audit.AuditService.model.UserEntity;
import audit.AuditService.repository.AuditRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {
    @Autowired
    private AuditRepository auditRepository;

    @Override
    public UserEntity saveUser(UserEntity user) {
        return auditRepository.save(user);
    }

}
