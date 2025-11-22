package audit.AuditService.repository;

import audit.AuditService.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<UserEntity, Integer> {}

