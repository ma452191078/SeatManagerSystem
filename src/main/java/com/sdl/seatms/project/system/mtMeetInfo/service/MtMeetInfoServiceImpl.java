package com.sdl.seatms.project.system.mtMeetInfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdl.seatms.project.system.mtMeetInfo.mapper.MtMeetInfoMapper;
import com.sdl.seatms.project.system.mtMeetInfo.domain.MtMeetInfo;
import com.sdl.seatms.project.system.mtMeetInfo.service.IMtMeetInfoService;
import com.sdl.seatms.common.utils.text.Convert;

/**
 * 会议 服务层实现
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Service
public class MtMeetInfoServiceImpl implements IMtMeetInfoService 
{
	@Autowired
	private MtMeetInfoMapper mtMeetInfoMapper;

	/**
     * 查询会议信息
     * 
     * @param meetId 会议ID
     * @return 会议信息
     */
    @Override
	public MtMeetInfo selectMtMeetInfoById(String meetId)
	{
	    return mtMeetInfoMapper.selectMtMeetInfoById(meetId);
	}
	
	/**
     * 查询会议列表
     * 
     * @param mtMeetInfo 会议信息
     * @return 会议集合
     */
	@Override
	public List<MtMeetInfo> selectMtMeetInfoList(MtMeetInfo mtMeetInfo)
	{
	    return mtMeetInfoMapper.selectMtMeetInfoList(mtMeetInfo);
	}
	
    /**
     * 新增会议
     * 
     * @param mtMeetInfo 会议信息
     * @return 结果
     */
	@Override
	public int insertMtMeetInfo(MtMeetInfo mtMeetInfo)
	{
	    return mtMeetInfoMapper.insertMtMeetInfo(mtMeetInfo);
	}
	
	/**
     * 修改会议
     * 
     * @param mtMeetInfo 会议信息
     * @return 结果
     */
	@Override
	public int updateMtMeetInfo(MtMeetInfo mtMeetInfo)
	{
	    return mtMeetInfoMapper.updateMtMeetInfo(mtMeetInfo);
	}

	/**
     * 删除会议对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMtMeetInfoByIds(String ids)
	{
		return mtMeetInfoMapper.deleteMtMeetInfoByIds(Convert.toStrArray(ids));
	}
	
}
