package nuclear.bot.parsing.agent.ua.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuclear.bot.parsingprocessor.dto.AgentMessage;
import nuclear.bot.parsingprocessor.service.MessageRpcService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SiteParserService {
    private final MessageRpcService messageRpcService;

    public void parseSite() {
        messageRpcService.sendMessage(new AgentMessage());
    }
}
