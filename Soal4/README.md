# User & Audit Service

User & Audit Service is a project built to meet the challenge of the IT Digital Service - BCA Digital. 
The repository implements backend using Java, Spring Boot and H2 Database.

## Key Features
1. User Service: Have API to creates user and publishes a Kafka Event.
2. Audit Service: Consume events from user-events and store the user data into database.


## Running the Service
1. Run User Service
   ```bash
    cd UserService 
    mvn spring-boot:run
   ```
2. Run Audit Service
   ```bash
    cd AuditService 
    mvn spring-boot:run
   ```

