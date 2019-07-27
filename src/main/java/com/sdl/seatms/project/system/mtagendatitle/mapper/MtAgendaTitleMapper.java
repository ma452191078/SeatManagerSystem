package com.sdl.seatms.project.system.mtagendatitle.mapper;

import com.sdl.seatms.project.system.mtagendatitle.domain.MtAgendaTitle;
import java.util.List;	

/**
 * 会议日程主
 数据层
 * 
 * @author sdl
 * @date 2019-07-24
 */
public interface MtAgendaTitleMapper 
{
	/**
     * 查询会议日程主
信息
     * 
     * @param agendaId 会议日程主
ID
     * @return 会议日程主
信息
     */
	public MtAgendaTitle selectMtAgendaTitleById(String agendaId);
	
	/**
     * 查询会议日程主
列表
     * 
     * @param mtAgendaTitle 会议日程主
信息
     * @return 会议日程主
集合
     */
	public List<MtAgendaTitle> selectMtAgendaTitleList(MtAgendaTitle mtAgendaTitle);
	
	/**
     * 新增会议日程主

     * 
     * @param mtAgendaTitle 会议日程主
信息
     * @return 结果
     */
	public int insertMtAgendaTitle(MtAgendaTitle mtAgendaTitle);
	
	/**
     * 修改会议日程主

     * 
     * @param mtAgendaTitle 会议日程主
信息
     * @return 结果
     */
	public int updateMtAgendaTitle(MtAgendaTitle mtAgendaTitle);
	
	/**
     * 删除会议日程主

     * 
     * @param agendaId 会议日程主
ID
     * @return 结果
     */
	public int deleteMtAgendaTitleById(String agendaId);
	
	/**
     * 批量删除会议日程主

     * 
     * @param agendaIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMtAgendaTitleByIds(String[] agendaIds);
	
}