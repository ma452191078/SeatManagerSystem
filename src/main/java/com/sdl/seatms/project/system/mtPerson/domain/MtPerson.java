package com.sdl.seatms.project.system.mtPerson.domain;


import com.sdl.seatms.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * 参会人员表 mt_person
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Data
public class MtPerson extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 参会人员id */
	private String personId;
	/** 员工编号 */
	private String personCode;
	/** 姓名 */
	private String personName;
	/** 部门 */
	private String personDept;
	/** 行 */
	private Integer personRow;
	/** 列 */
	private Integer personCol;

}
