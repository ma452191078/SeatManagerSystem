package com.sdl.seatms.project.system.mtagendaitem.domain;


import com.alibaba.fastjson.annotation.JSONField;
import com.sdl.seatms.framework.web.domain.BaseEntity;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * 会议日程明细表 mt_agenda_item
 * 
 * @author sdl
 * @date 2019-07-24
 */
@Data
public class MtAgendaItem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private String itemId;
	/** 日程id */
	private String agendaId;
	/** 开始时间 */
	private String itemStart;
	/** 结束时间 */
	private String itemEnd;
	/** 主持人 */
	private String itemCompere;
	/** 内容 */
	private String itemContent;

}
