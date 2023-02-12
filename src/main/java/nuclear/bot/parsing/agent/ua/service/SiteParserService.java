package nuclear.bot.parsing.agent.ua.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuclear.bot.core.dto.AgentMessage;
import nuclear.bot.parsing.agent.ua.service.dto.SaveEcoBotDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class SiteParserService {

    private final RestTemplate restTemplate;
    private final DeviceAgentMessageMapper mapper;
    private final ObjectMapper objectMapper;
    @Value("${siteconnection.url}")
    private String siteUrl;

    @Value("${max.radiation.rate}")
    private int MAX_RATE;//максимальное допустимое значение радицации

    // Исключаем зараженные точки на карте
    private List<Integer> excludeRadarList = List.of(3725, 3729, 3731, 3732, 3733, 3734, 3756,
            3765, 3770, 3771, 3774,
            3775, 3777, 3778);

    public List<AgentMessage> parseSite() {
        try {
            var data = restTemplate.getForObject(siteUrl, String.class);
            var saveEcoBotDto = objectMapper.readValue(data, SaveEcoBotDto.class);
            return toAgentMessage(saveEcoBotDto);
        } catch (Exception e) {
            log.error("Ошибка при попытке получить ответ от сайта {}", siteUrl);
        }
        return null;
    }

    private List<AgentMessage> toAgentMessage(SaveEcoBotDto saveEcoBotDto) {
        if (isNull(saveEcoBotDto) || isEmpty(saveEcoBotDto.getDevices())) {
            return Collections.emptyList();
        }
        return saveEcoBotDto.getDevices().stream()
                .filter(d -> nonNull(d.getGamma()))
                .filter(d -> !excludeRadarList.contains(d.getI()))
                .map(mapper::toAgentMessage)
                .collect(Collectors.toList());
    }
}
