package io.human.networks.service;

import org.springframework.http.ResponseEntity;

public interface MockRestUtils {
    ResponseEntity getSchool(String name, String pIndex, String pSize);
}
