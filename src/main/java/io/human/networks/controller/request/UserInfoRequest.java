package io.human.networks.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoRequest {

    private String userId;
    private String passWord;
    private String userName;
    private String userEmail;
    private String userAddr;
    private String userBirth;

    private List<SchoolInfoRequest> elementarySchool;
    private List<SchoolInfoRequest> middleSchool;
    private List<SchoolInfoRequest> highSchool;
    private List<SchoolInfoRequest> universitySchool;

    private List<CompanyInfoRequest> companyInfo;
}
