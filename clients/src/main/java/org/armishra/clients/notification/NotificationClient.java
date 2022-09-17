package org.armishra.clients.notification;

import org.armishra.clients.dto.notification.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        name = "notification",
        url = "${clients.notification.url}"
)
@RequestMapping("/api/v1/notification")
public interface NotificationClient {

    @PostMapping("/")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
