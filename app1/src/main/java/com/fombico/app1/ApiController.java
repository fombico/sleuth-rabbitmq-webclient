package com.fombico.app1;

import brave.baggage.BaggageField;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@AllArgsConstructor
public class ApiController {

    private final BaggageField storeIdField;
    private final StreamBridge streamBridge;

    @GetMapping("/hello")
    public String getGreeting() {
        String response = "hello " + new Random().nextInt();
        log.info("GET Hello with response {}", response);
        return response;
    }

    @PostMapping("/hello")
    public void createGreeting() {
        storeIdField.updateValue("1000");

        log.info("POST Hello");
        streamBridge.send("messaging-out-0", MessageBuilder.withPayload("Hello, world").build());
    }
}
