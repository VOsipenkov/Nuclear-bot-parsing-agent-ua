package nuclear.bot.parsing.agent.ua.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuclear.bot.core.dto.AgentMessage;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AgentProcessingService {

    private final SiteParserService siteParserService;
    private final KafkaTemplate<String, AgentMessage> kafkaTemplate;

//    @Scheduled(fixedRateString = "${refresh.time}")
    public void executeJob() {
        var parsedMessages = siteParserService.parseSite();
        sendMessages(parsedMessages);
    }

    public void sendMessages(List<AgentMessage> agentMessages) {
        if (CollectionUtils.isEmpty(agentMessages)) return;
        log.info("[AGENT][UA] Send messages size {}", agentMessages.size());
        agentMessages.forEach(agentMessage ->
                kafkaTemplate.send(new ProducerRecord<>(kafkaTemplate.getDefaultTopic(), agentMessage)));
    }
}
