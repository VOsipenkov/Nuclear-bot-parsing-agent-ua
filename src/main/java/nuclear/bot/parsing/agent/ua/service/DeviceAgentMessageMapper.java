package nuclear.bot.parsing.agent.ua.service;

import nuclear.bot.parsing.agent.ua.service.dto.Device;
import nuclear.bot.parsingprocessor.dto.AgentMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DeviceAgentMessageMapper {
    @Mapping(source = "gamma", target = "message")
    AgentMessage toAgentMessage(Device device);
}
