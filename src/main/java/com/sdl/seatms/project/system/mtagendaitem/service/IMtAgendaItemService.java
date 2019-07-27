package com.sdl.seatms.project.system.mtagendaitem.service;

import com.sdl.seatms.project.system.mtagendaitem.domain.MtAgendaItem;
import java.util.List;

/**
 * 会议日程明细 服务层
 * 
 * @author sdl
 * @date 2019-07-24
 */
public interface IMtAgendaItemService 
{
	/**
     * 查询会议日程明细信息
     * 
     * @param itemId 会议日程明细ID
     * @return 会议日程明细信息
     */
	public MtAgendaItem selectMtAgendaItemById(String itemId);
	
	/**
     * 查询会议日程明细列表
     * 
     * @param mtAgendaItem 会议日程明细信息
     * @return 会议日程明细集合
     */
	public List<MtAgendaItem> selectMtAgendaItemList(MtAgendaItem mtAgendaItem);
	
	/**
     * 新增会议日程明细
     * 
     * @param mtAgendaItem 会议日程明细信息
     * @return 结果
     */
	public int insertMtAgendaItem(MtAgendaItem mtAgendaItem);
	
	/**
     * 修改会议日程明细
     * 
     * @param mtAgendaItem 会议日程明细信息
     * @return 结果
     */
	public int updateMtAgendaItem(MtAgendaItem mtAgendaItem);
		
	/**
     * 删除会议日程明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMtAgendaItemByIds(String ids);
	
}
