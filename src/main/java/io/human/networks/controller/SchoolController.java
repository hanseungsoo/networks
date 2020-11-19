package io.human.networks.controller;

import io.human.networks.service.SchoolService;
import io.human.networks.service.vo.SchoolVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity getSchoolList(@RequestParam Map<String, String> paramQuery) {
        SchoolVo schoolVo = schoolService.getSchoolList(paramQuery);
        return new ResponseEntity(schoolVo, HttpStatus.OK);
    }
}
