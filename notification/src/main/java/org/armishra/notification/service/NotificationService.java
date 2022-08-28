package org.armishra.notification.service;

import org.armishra.notification.entity.Notification;
import lombok.AllArgsConstructor;
import org.armishra.clients.dto.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.armishra.notification.repository.NotificationRepository;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("Arjit Mishra")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}
