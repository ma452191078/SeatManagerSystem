package com.sdl.seatms.project.system.mtthuminfo.mapper;

import com.sdl.seatms.project.system.mtmeetinfo.domain.MtMeetInfo;
import com.sdl.seatms.project.system.mtthuminfo.domain.MtThumInfo;
import java.util.List;	

/**
 * 座次图 数据层
 * 
 * @author sdl
 * @date 2019-07-17
 */
public interface MtThumInfoMapper 
{
	/**
     * 查询座次图信息
     * 
     * @param thumId 座次图ID
     * @return 座次图信息
     */
	public MtThumInfo selectMtThumInfoById(String thumId);
	
	/**
     * 查询座次图列表
     * 
     * @param mtThumInfo 座次图信息
     * @return 座次图集合
     */
	public List<MtThumInfo> selectMtThumInfoList(MtThumInfo mtThumInfo);

	public List<MtThumInfo> selectMtThumInfoListByMeetId(String meetId);
	
	/**
     * 新增座次图
     * 
     * @param mtThumInfo 座次图信息
     * @return 结果
     */
	public int insertMtThumInfo(MtThumInfo mtThumInfo);
	
	/**
     * 修改座次图
     * 
     * @param mtThumInfo 座次图信息
     * @return 结果
     */
	public int updateMtThumInfo(MtThumInfo mtThumInfo);
	
	/**
     * 删除座次图
     * 
     * @param thumId 座次图ID
     * @return 结果
     */
	public int deleteMtThumInfoById(String thumId);
	
	/**
     * 批量删除座次图
     * 
     * @param thumIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMtThumInfoByIds(String[] thumIds);

	int deleteMtThumInfoByInfo(MtThumInfo mtThumInfo);
	
}