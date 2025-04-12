package nuclear.bot.parsing.agent.ua.service;

import nuclear.bot.core.dto.AgentMessage;
import nuclear.bot.parsing.agent.ua.service.dto.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.OffsetDateTime;
import java.util.HashMap;

@Mapper(imports = {HashMap.class, OffsetDateTime.class})
public interface DeviceAgentMessageMapper {
    @Mapping(target = "message", expression = "java(String.valueOf(device.getGamma()/10f ))") /* convert nanozivert to microrentgen */
    @Mapping(target = "parserAgentName", constant = "www.saveecobot.com")
    @Mapping(target = "messageDateTime", expression = "java(OffsetDateTime.now().toString())")
    @Mapping(target = "additionalProperties", expression = "java(new HashMap<String, Object>())")
    AgentMessage toAgentMessage(Device device);
}
