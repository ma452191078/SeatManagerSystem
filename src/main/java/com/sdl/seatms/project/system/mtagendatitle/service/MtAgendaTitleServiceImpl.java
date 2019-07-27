package com.sdl.seatms.project.system.mtagendatitle.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdl.seatms.project.system.mtagendatitle.mapper.MtAgendaTitleMapper;
import com.sdl.seatms.project.system.mtagendatitle.domain.MtAgendaTitle;
import com.sdl.seatms.common.utils.text.Convert;

/**
 * 会议日程主
 服务层实现
 * 
 * @author sdl
 * @date 2019-07-24
 */
@Service
public class MtAgendaTitleServiceImpl implements IMtAgendaTitleService 
{
	@Autowired
	private MtAgendaTitleMapper mtAgendaTitleMapper;

	/**
     * 查询会议日程主
信息
     * 
     * @param agendaId 会议日程主
ID
     * @return 会议日程主
信息
     */
    @Override
	public MtAgendaTitle selectMtAgendaTitleById(String agendaId)
	{
	    return mtAgendaTitleMapper.selectMtAgendaTitleById(agendaId);
	}
	
	/**
     * 查询会议日程主
列表
     * 
     * @param mtAgendaTitle 会议日程主
信息
     * @return 会议日程主
集合
     */
	@Override
	public List<MtAgendaTitle> selectMtAgendaTitleList(MtAgendaTitle mtAgendaTitle)
	{
	    return mtAgendaTitleMapper.selectMtAgendaTitleList(mtAgendaTitle);
	}
	
    /**
     * 新增会议日程主

     * 
     * @param mtAgendaTitle 会议日程主
信息
     * @return 结果
     */
	@Override
	public int insertMtAgendaTitle(MtAgendaTitle mtAgendaTitle)
	{
	    return mtAgendaTitleMapper.insertMtAgendaTitle(mtAgendaTitle);
	}
	
	/**
     * 修改会议日程主

     * 
     * @param mtAgendaTitle 会议日程主
信息
     * @return 结果
     */
	@Override
	public int updateMtAgendaTitle(MtAgendaTitle mtAgendaTitle)
	{
	    return mtAgendaTitleMapper.updateMtAgendaTitle(mtAgendaTitle);
	}

	/**
     * 删除会议日程主
对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMtAgendaTitleByIds(String ids)
	{
		return mtAgendaTitleMapper.deleteMtAgendaTitleByIds(Convert.toStrArray(ids));
	}
	
}
