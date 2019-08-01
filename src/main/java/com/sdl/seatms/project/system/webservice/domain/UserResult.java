package com.sdl.seatms.project.system.webservice.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author majingyuan
 * @Date Create in 2019/7/30 17:03
 */
@Data
public class UserResult {

    private int timestamp;
    private String responseStatus;
    private String errorMsg;
    private List<WebServicePerson> data;
}
