package org.armishra.customer.service;

import lombok.AllArgsConstructor;
import org.armishra.amqp.producer.RabbitMQMessageProducer;
import org.armishra.clients.dto.fraud.FraudCheckResponse;
import org.armishra.clients.dto.notification.NotificationRequest;
import org.armishra.clients.fraud.FraudClient;
import org.armishra.clients.dto.customer.CustomerRegistrationRequest;
import org.armishra.customer.entity.Customer;
import org.springframework.stereotype.Service;
import org.armishra.customer.repo.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final FraudClient fraudClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: if email is valid
        //todo: if email is not taken

        repository.saveAndFlush(customer);
        //todo: if fraudster
        FraudCheckResponse fraudster = fraudClient.isFraudster(customer.getId());
        if(Boolean.TRUE.equals(fraudster.isFraudster())){
            throw new IllegalStateException("Fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to my home",
                        customer.getFirstName()
                )
        );

        rabbitMQMessageProducer.publish(
               "internal.exchange",
               "internal-notification.key",
               notificationRequest
        );
    }
}
