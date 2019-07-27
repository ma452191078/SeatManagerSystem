package com.sdl.seatms.project.system.mtthuminfo.domain;


import com.sdl.seatms.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * 座次图表 mt_thum_info
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Data
public class MtThumInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 缩略图id */
	private String thumId;
	/** 会议ID */
	private String meetId;
	/** 区域 */
	private String areaId;
	/** 行坐标 */
	private Integer thumRow;
	/** 列坐标 */
	private Integer thumCol;

	/** 行数 */
	private Integer rowNum;
	/** 列数 */
	private Integer colNum;

	/** 背景色 */
	private String thumColor;




}
