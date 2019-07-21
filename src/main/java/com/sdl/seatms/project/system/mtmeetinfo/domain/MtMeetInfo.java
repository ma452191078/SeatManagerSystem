package com.sdl.seatms.project.system.mtmeetinfo.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sdl.seatms.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 会议表 mt_meet_info
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Data
public class MtMeetInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String meetId;
	/** 会议名称 */
	private String meetName;
	/** 开始时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date meetStart;
	/** 结束时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date meetEnd;
	/** 会议logo */
	private String meetLogo;
	/** 会议主题 */
	private String meetTitle;
	/** 会场行数 */
	private int meetRow;
	/** 会场列数 */
	private int meetCol;
	/** 参会人数 */
	private Integer meetPersonNum;

}
