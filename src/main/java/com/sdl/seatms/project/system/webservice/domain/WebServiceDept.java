package com.sdl.seatms.project.system.webservice.domain;

import lombok.Data;

/**
 * @Author majingyuan
 * @Date Create in 2019/7/30 17:08
 */
@Data
public class WebServiceDept {
    /** 部门编码 */
    private Long dept_code;
    /** 部门名称 */
    private String dept_name;
    /** 是否可用，1-可用，0-不可用 */
    private String active_flag;
    /** 父部门编码 */
    private Long parent_code;
    /** 是否为叶子部门，0-非，1-是 */
    private String leaf;
    /** 部门层级 */
    private String dept_level;
    /** 部门类型，1-销售系统，2-生产系统，3-业务系统 */
    private String dept_type;
}
