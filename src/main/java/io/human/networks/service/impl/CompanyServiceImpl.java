package io.human.networks.service.impl;

import io.human.networks.service.CompanyService;
import io.human.networks.vo.CompanyVo;
import io.human.networks.util.RestUtils;
import io.human.networks.util.mapper.RestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Value("${api.company.url}")
    private String companyApiUrl;

    @Value("${api.company.key}")
    private String companyApiKey;

    private RestUtils restUtils;

    public CompanyServiceImpl(RestUtils restUtils) {
        this.restUtils = restUtils;
    }

    @Override
    public CompanyVo getCompanyList(Map<String, String> paramQuery) {
        paramQuery.put("ServiceKey", companyApiKey);

        CompanyVo companyVo = restUtils.get(companyApiUrl, paramQuery, new RestMapper() {
            @Override
            public <T> T mapper(ResponseEntity responseEntity) {
                return (T) new CompanyVo().toCompanyVo((String)responseEntity.getBody());
            }
        });

        return companyVo;
    }
}
