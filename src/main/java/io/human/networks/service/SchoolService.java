package io.human.networks.service;

import io.human.networks.service.vo.SchoolVo;

import java.util.Map;

public interface SchoolService {

    public SchoolVo getSchool(Map<String, String> paramQuery);
}
