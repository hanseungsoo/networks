package io.human.networks.service;

import io.human.networks.service.vo.SchoolVo;
import org.springframework.http.ResponseEntity;

public interface SchoolService {

    public ResponseEntity getSchool(String name, String pIndex, String pSize);
}
