package nuclear.bot.parsing.agent.ua.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class HealthCheckService {

    private final RestTemplate restTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${core.service.name}")
    private String coreServiceName;
    @Value(value = "${core.service.path}")
    private String coreServicePath;

//    @Scheduled(fixedRateString = "10000")
    public void doCall() {
        log.info("Parsing-agent-ua invoke core health check service..");
        var response = restTemplate.getForEntity(coreServiceName + coreServicePath, String.class);
        log.info("Rs status {}, body {}", response.getStatusCode(), response.getBody());

        log.info("Try to send in kafka");
        kafkaTemplate.send("PARSER.EVENT", "123", "hello my test message");
    }
}
