package io.human.networks.service.impl;

import io.human.networks.service.SchoolService;
import io.human.networks.service.vo.SchoolVo;
import io.human.networks.util.RestUtils;
import io.human.networks.util.mapper.RestMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${api.school.url}")
    private String schoolApiUrl;

    @Value("${api.school.key}")
    private String schoolApiKey;

    private RestUtils restUtils;

    public SchoolServiceImpl(RestUtils restUtils) {
        this.restUtils = restUtils;
    }

    @Override
    public SchoolVo getSchool(Map<String, String> paramQuery) {
        paramQuery.put("key", schoolApiKey);

        SchoolVo schoolVo = restUtils.get(schoolApiUrl, paramQuery, new RestMapper() {
            @Override
            public <T> T mapper(ResponseEntity responseEntity) {
                return (T) new SchoolVo().toSchoolVo((String)responseEntity.getBody());
            }
        });

        return schoolVo;
    }
}
