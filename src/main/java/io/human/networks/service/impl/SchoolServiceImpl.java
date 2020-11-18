package io.human.networks.service.impl;

import io.human.networks.service.SchoolService;
import io.human.networks.service.vo.SchoolVo;
import io.human.networks.util.RestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
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
    public ResponseEntity getSchool(String name, String pIndex, String pSize) {
        Map<String, String> paramQuery = new HashMap<>();
        paramQuery.put("name", name);
        paramQuery.put("pIndex", pIndex);
        paramQuery.put("pSize", pSize);
        paramQuery.put("key", schoolApiKey);

        logger.info(paramQuery.toString());
        ResponseEntity responseEntity = restUtils.get(schoolApiUrl, paramQuery);
        logger.info(responseEntity.toString());

        return responseEntity;
    }
}
