package audit.AuditService.service;

import audit.AuditService.model.UserEntity;

import java.util.List;

public interface AuditService {
    UserEntity saveUser(UserEntity user);

}
