package nuclear.bot.parsing.agent.ua.web;

import lombok.RequiredArgsConstructor;
import nuclear.bot.core.dto.AgentMessage;
import nuclear.bot.core.service.MessageRpcService;
import nuclear.bot.parsing.agent.ua.service.SiteParserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final MessageRpcService messageRpcService;
    private final SiteParserService siteParserService;

    @GetMapping(value = "/send/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable(name = "message") String message) throws Throwable {
        var agentMessage = new AgentMessage();
        agentMessage.setMessage(message);
        agentMessage.setMessageDateTime(LocalDateTime.now().toString());
        agentMessage.setParserAgentName("UA-agent");
        messageRpcService.sendMessage(agentMessage);
        return ResponseEntity.ok("ok");
    }

    @GetMapping(value = "/parse-site")
    public ResponseEntity<String> parseSite() {
        siteParserService.parseSite();
        return ResponseEntity.ok("ok");
    }
}
