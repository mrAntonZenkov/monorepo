package com.example.notificationservice;

import com.example.notificationservice.dto.EmailRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@DirtiesContext
public class NotificationIntegrationTest {

    private static final DockerImageName KAFKA_IMAGE = DockerImageName
            .parse("confluentinc/cp-kafka:latest")
            .asCompatibleSubstituteFor("apache/kafka");

    @Container
    @ServiceConnection
    static KafkaContainer kafka = new KafkaContainer(KAFKA_IMAGE);

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldSendEmailViaRestApi() {
        EmailRequestDTO request = new EmailRequestDTO();
        request.setEmail("test@example.com");
        request.setOperation("create");

        ResponseEntity<Void> response = restTemplate.postForEntity("/api/notifications/send", request, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
    }
}