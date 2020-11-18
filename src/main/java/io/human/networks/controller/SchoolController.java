package io.human.networks.controller;

import io.human.networks.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity getSchool(@RequestParam String name, @RequestParam String pIndex,
                                    @RequestParam String pSize) {
        return schoolService.getSchool(name, pIndex, pSize);
    }
}
