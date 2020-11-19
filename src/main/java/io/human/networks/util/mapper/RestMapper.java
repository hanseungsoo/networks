package io.human.networks.util.mapper;

import org.springframework.http.ResponseEntity;

public interface RestMapper {

    public <T> T mapper(ResponseEntity responseEntity);
}