package io.human.networks.service;

import io.human.networks.vo.CompanyVo;

import java.util.Map;

public interface CompanyService {

    public CompanyVo getCompanyList(Map<String, String> paramQuery);
}
