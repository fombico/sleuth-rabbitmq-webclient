# Sleuth RabbitMQ WebClient

A sample Spring project using
- Spring Cloud Sleuth 3.x
- Spring Cloud Stream 3.x with RabbitMQ
- `WebClient` from Spring WebFlux.

## Learnings
- When publishing a message using the `StreamBridge`, use the `MessageBuilder.withPayload`
- When receiving a message, use `Consumer<Message<ObjectType>>`
- When making an API call, inject the default `webClientBuilder` to construct the web client

Take a look at PR template.