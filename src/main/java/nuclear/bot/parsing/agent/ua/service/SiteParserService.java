package nuclear.bot.parsing.agent.ua.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuclear.bot.parsingprocessor.dto.AgentMessage;
import nuclear.bot.parsingprocessor.service.MessageRpcService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class SiteParserService {
    private final MessageRpcService messageRpcService;

    @Scheduled(fixedRate = 1000)
    public void executeJob() throws Throwable {
        messageRpcService.sendMessage(parseSite());
    }

    public AgentMessage parseSite() {
        var agentMessage = new AgentMessage();
        agentMessage.setMessage("test-message");
        agentMessage.setMessageDateTime(LocalDateTime.now().toString());
        agentMessage.setParsingAgentName("UA-agent");
        return agentMessage;
    }
}
