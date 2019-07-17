package com.sdl.seatms.project.system.mtMeetInfo.domain;


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
	private Date meetStart;
	/** 结束时间 */
	private Date meetEnd;
	/** 会议logo */
	private String meetLogo;
	/** 会议主题 */
	private String meetTitle;

}
