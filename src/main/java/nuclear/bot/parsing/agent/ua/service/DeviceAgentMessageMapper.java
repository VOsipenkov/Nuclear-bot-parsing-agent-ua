package nuclear.bot.parsing.agent.ua.service;

import nuclear.bot.core.dto.AgentMessage;
import nuclear.bot.parsing.agent.ua.service.dto.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.HashMap;

@Mapper(imports = {HashMap.class, LocalDateTime.class})
public interface DeviceAgentMessageMapper {
    @Mapping(source = "gamma", target = "message")
    @Mapping(target = "parsingAgentName", constant = "SaveEcoBot")
    @Mapping(target = "messageDateTime", expression = "java(LocalDateTime.now().toString())")
    @Mapping(target = "additionalProperties", expression = "java(new HashMap<String, Object>())")
    AgentMessage toAgentMessage(Device device);
}
