package io.human.networks.controller;

import io.human.networks.service.CompanyService;
import io.human.networks.service.vo.CompanyVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping
    public ResponseEntity getCompanyList(@RequestParam Map<String, String> paramQuery) {
        CompanyVo companyVo = companyService.getCompanyList(paramQuery);
        return new ResponseEntity(companyVo, HttpStatus.OK);
    }
}
