package org.armishra.notification.messageConsumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.armishra.clients.dto.notification.NotificationRequest;
import org.armishra.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQNotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(NotificationRequest notificationRequest){
        log.info("Consumed from {} queue", notificationRequest);
        notificationService.send(notificationRequest);
    }


}
