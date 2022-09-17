package org.armishra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {
                "org.armishra.notification",
                "org.armishra.amqp"
        }
)
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
//    NotificationConfig notificationConfig) {
//
//        return args -> {
//            producer.publish( notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKeys(), new Person("Arjit", 28));
//        };
//    }
//
//    record Person(String name, int age){}

}
