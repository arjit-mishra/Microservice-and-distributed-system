package org.armishra.notification.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.armishra.clients.dto.notification.NotificationRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.armishra.notification.service.NotificationService;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public String hello(){
        return "Hello from notification service";
    }

    @PostMapping("/")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("New notification....{}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
