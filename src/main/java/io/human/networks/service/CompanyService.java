package io.human.networks.service;

import io.human.networks.service.vo.CompanyVo;

import java.util.Map;

public interface CompanyService {

    public CompanyVo getCompanyList(Map<String, String> paramQuery);
}
