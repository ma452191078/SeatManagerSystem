package com.sdl.seatms.project.system.mtmeetinfo.service;

import com.sdl.seatms.project.system.mtmeetinfo.domain.MtMeetInfo;
import java.util.List;

/**
 * 会议 服务层
 * 
 * @author sdl
 * @date 2019-07-17
 */
public interface IMtMeetInfoService 
{
	/**
     * 查询会议信息
     * 
     * @param meetId 会议ID
     * @return 会议信息
     */
	public MtMeetInfo selectMtMeetInfoById(String meetId);
	
	/**
     * 查询会议列表
     * 
     * @param mtMeetInfo 会议信息
     * @return 会议集合
     */
	public List<MtMeetInfo> selectMtMeetInfoList(MtMeetInfo mtMeetInfo);
	
	/**
     * 新增会议
     * 
     * @param mtMeetInfo 会议信息
     * @return 结果
     */
	public int insertMtMeetInfo(MtMeetInfo mtMeetInfo);
	
	/**
     * 修改会议
     * 
     * @param mtMeetInfo 会议信息
     * @return 结果
     */
	public int updateMtMeetInfo(MtMeetInfo mtMeetInfo);
		
	/**
     * 删除会议信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMtMeetInfoByIds(String ids);
	
}
