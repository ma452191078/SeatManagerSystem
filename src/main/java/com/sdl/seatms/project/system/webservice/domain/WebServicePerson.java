package com.sdl.seatms.project.system.webservice.domain;

import lombok.Data;

/**
 * @Author majingyuan
 * @Date Create in 2019/7/30 17:10
 */
@Data
public class WebServicePerson {
    /** 人员状态，1-实习人员，2-试用员工，3-在职员工，4-考察期员工，5-离职，6-退休，7-工伤 */
    private String p_status;
    /** 姓名 */
    private String p_name;
    /** 部门 */
    private Long p_dept;
    /** 性别，0-女，1-男 */
    private String p_gender;
    /** 岗位 */
    private String p_pos;
    /** 工号 */
    private Long p_code;
    /** 职务 */
    private String p_admjob;
}
