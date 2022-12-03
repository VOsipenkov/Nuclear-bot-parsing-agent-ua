package nuclear.bot.parsing.agent.ua.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SaveEcoBotDto {
    @JsonProperty(value = "devices")
    private List<Device> devices;
}
