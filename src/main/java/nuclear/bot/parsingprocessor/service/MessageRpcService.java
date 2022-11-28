package nuclear.bot.parsingprocessor.service;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import nuclear.bot.parsingprocessor.dto.AgentMessage;

@JsonRpcService("/jsonrpc")
public interface MessageRpcService {
    AgentMessage sendMessage(@JsonRpcParam(value = "agentMessage") AgentMessage agentMessage) throws Throwable;
}
