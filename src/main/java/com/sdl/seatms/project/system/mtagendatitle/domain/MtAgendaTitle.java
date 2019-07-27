package com.sdl.seatms.project.system.mtagendatitle.domain;


import com.sdl.seatms.framework.web.domain.BaseEntity;
import com.sdl.seatms.project.system.mtagendaitem.domain.MtAgendaItem;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 会议日程主
表 mt_agenda_title
 * 
 * @author sdl
 * @date 2019-07-24
 */
@Data
public class MtAgendaTitle extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private String agendaId;
	/** 日期 */
	private Date agendaDate;

	private String meetId;
	/** 明细 */
	private List<MtAgendaItem> itemList;
}
