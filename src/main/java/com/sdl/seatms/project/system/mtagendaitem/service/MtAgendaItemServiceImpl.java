package com.sdl.seatms.project.system.mtagendaitem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdl.seatms.project.system.mtagendaitem.mapper.MtAgendaItemMapper;
import com.sdl.seatms.project.system.mtagendaitem.domain.MtAgendaItem;
import com.sdl.seatms.common.utils.text.Convert;

/**
 * 会议日程明细 服务层实现
 * 
 * @author sdl
 * @date 2019-07-24
 */
@Service
public class MtAgendaItemServiceImpl implements IMtAgendaItemService 
{
	@Autowired
	private MtAgendaItemMapper mtAgendaItemMapper;

	/**
     * 查询会议日程明细信息
     * 
     * @param itemId 会议日程明细ID
     * @return 会议日程明细信息
     */
    @Override
	public MtAgendaItem selectMtAgendaItemById(String itemId)
	{
	    return mtAgendaItemMapper.selectMtAgendaItemById(itemId);
	}
	
	/**
     * 查询会议日程明细列表
     * 
     * @param mtAgendaItem 会议日程明细信息
     * @return 会议日程明细集合
     */
	@Override
	public List<MtAgendaItem> selectMtAgendaItemList(MtAgendaItem mtAgendaItem)
	{
	    return mtAgendaItemMapper.selectMtAgendaItemList(mtAgendaItem);
	}
	
    /**
     * 新增会议日程明细
     * 
     * @param mtAgendaItem 会议日程明细信息
     * @return 结果
     */
	@Override
	public int insertMtAgendaItem(MtAgendaItem mtAgendaItem)
	{
	    return mtAgendaItemMapper.insertMtAgendaItem(mtAgendaItem);
	}
	
	/**
     * 修改会议日程明细
     * 
     * @param mtAgendaItem 会议日程明细信息
     * @return 结果
     */
	@Override
	public int updateMtAgendaItem(MtAgendaItem mtAgendaItem)
	{
	    return mtAgendaItemMapper.updateMtAgendaItem(mtAgendaItem);
	}

	/**
     * 删除会议日程明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMtAgendaItemByIds(String ids)
	{
		return mtAgendaItemMapper.deleteMtAgendaItemByIds(Convert.toStrArray(ids));
	}
	
}
