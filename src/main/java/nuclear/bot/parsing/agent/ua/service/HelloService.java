package nuclear.bot.parsing.agent.ua.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloService {

    private final RestTemplate restTemplate;

    @Scheduled(fixedRateString = "10000")
    public void doCall() {
        log.info("Hello service invoke core..");
        var response = restTemplate.getForEntity("http://10.99.217.94/health", String.class);
        log.info("Rs status {}, body {}", response.getStatusCode(), response.getBody());
    }
}
