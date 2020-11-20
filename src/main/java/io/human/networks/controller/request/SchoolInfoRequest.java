package io.human.networks.controller.request;

import io.human.networks.vo.SchoolItem;
import lombok.Data;

@Data
public class SchoolInfoRequest extends SchoolItem {

    private String startDate;
    private String endDate;
}
