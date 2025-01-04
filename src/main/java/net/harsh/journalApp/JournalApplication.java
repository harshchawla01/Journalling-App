package net.harsh.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Ek spring boot project me ek hi SpringBootApplication hogi aur vo hum Main class par lagate hain jisme main method hota h
//@EnableTransactionManagement
public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
    }

//    @Bean
//    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory) {
//        return new MongoTransactionManager(dbFactory);
//    }
}

// PlatformTransactionManager manage karega ki agr ho to saare steps ho nahi to rollback kr do
// MongoTransactionManager implements PlatformTransactionManager
// MongoDatabaseFactory helps to set connection to database by creating session
// MongoDatabaseFactory ka implementation is SimpleMongoClientDatabaseFactory jiska object aega iske andr