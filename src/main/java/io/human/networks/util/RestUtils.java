package io.human.networks.util;

import io.human.networks.util.mapper.RestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RestUtils {

    private RestTemplate restTemplate;

    public RestUtils() {
        this.restTemplate = new RestTemplate();
    }

    public <T> T get(String url, Map<String, String> paramQuery, RestMapper restMapper) {
        return restMapper.mapper(this.restTemplate.getForEntity(url, String.class, paramQuery));
    }
}