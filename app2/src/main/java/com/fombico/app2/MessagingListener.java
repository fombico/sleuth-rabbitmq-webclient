package com.fombico.app2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

@Slf4j
@Service("messaging")
@AllArgsConstructor
class MessagingListener implements Consumer<Message<String>> {

    WebClient.Builder webClientBuilder;

    @Override
    public void accept(Message<String> message) {
        log.info("Received message: {}", message.getPayload());
        var webClient = webClientBuilder.baseUrl("http://localhost:8085").build();
        String response = webClient.method(HttpMethod.GET).uri("/hello").retrieve().bodyToMono(String.class).block();
        log.info("Made api call and received {}", response);
    }
}

