package io.human.networks.service.impl;

import io.human.networks.service.SchoolService;
import io.human.networks.vo.SchoolVo;
import io.human.networks.util.RestUtils;
import io.human.networks.util.mapper.RestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {

    @Value("${api.school.url}")
    private String schoolApiUrl;

    @Value("${api.school.key}")
    private String schoolApiKey;

    private RestUtils restUtils;

    public SchoolServiceImpl(RestUtils restUtils) {
        this.restUtils = restUtils;
    }

    @Override
    public SchoolVo getSchoolList(Map<String, String> paramQuery) {
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
