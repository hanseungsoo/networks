package io.human.networks.service;

import io.human.networks.vo.SchoolVo;

import java.util.Map;

public interface SchoolService {

    public SchoolVo getSchoolList(Map<String, String> paramQuery);
}
