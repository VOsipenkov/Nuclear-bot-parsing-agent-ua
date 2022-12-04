package nuclear.bot.parsing.agent.ua.service;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuclear.bot.parsingprocessor.dto.AgentMessage;
import nuclear.bot.parsingprocessor.service.AlertLevel;
import nuclear.bot.parsingprocessor.service.MessageRpcService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageRpcServiceClientImpl implements MessageRpcService {

    private final JsonRpcHttpClient jsonRpcHttpClient;

    @Override
    public AgentMessage sendMessage(AgentMessage agentMessage) throws Throwable {
        log.info("[AGENT][UA] Send message {}", agentMessage);
        jsonRpcHttpClient.invoke("sendMessage", new Object[]{agentMessage});
        return agentMessage;
    }

    @Override
    public AlertLevel notificationLevel() {
        String result = null;
        try {
            result = jsonRpcHttpClient.invoke("notificationLevel", new Object[]{}, String.class);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return AlertLevel.valueOf(result);
    }
}
