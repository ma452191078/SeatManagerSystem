package com.sdl.seatms.project.system.mtperson.domain;


import com.sdl.seatms.framework.aspectj.lang.annotation.Excel;
import com.sdl.seatms.framework.web.domain.BaseEntity;
import com.sdl.seatms.project.system.mtmeetinfo.domain.MtMeetInfo;
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
	@Excel(name = "员工编号")
	private String personCode;
	/** 姓名 */
	@Excel(name = "姓名")
	private String personName;
	/** 部门 */
	@Excel(name = "部门")
	private String personDept;
	/** 区域 */
	@Excel(name = "区域")
	private String personArea;
	/** 行 */
	@Excel(name = "行")
	private Integer personRow;
	/** 列 */
	@Excel(name = "列")
	private Integer personCol;

	private String meetId;

	private MtMeetInfo mtMeetInfo;

}
