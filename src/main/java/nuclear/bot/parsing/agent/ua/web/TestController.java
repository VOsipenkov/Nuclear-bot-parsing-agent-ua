package nuclear.bot.parsing.agent.ua.web;

import lombok.RequiredArgsConstructor;
import nuclear.bot.parsingprocessor.dto.AgentMessage;
import nuclear.bot.parsingprocessor.service.MessageRpcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final MessageRpcService messageRpcService;

    @GetMapping(value = "/send/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable(name = "message") String message) throws Throwable {
        var agentMessage = new AgentMessage();
        agentMessage.setMessage(message);
        agentMessage.setMessageDateTime(LocalDateTime.now().toString());
        agentMessage.setParsingAgentName("UA-agent");
        messageRpcService.sendMessage(agentMessage);
        return ResponseEntity.ok("ok");
    }
}
