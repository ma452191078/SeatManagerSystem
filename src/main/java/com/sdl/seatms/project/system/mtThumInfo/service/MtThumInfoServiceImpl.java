package com.sdl.seatms.project.system.mtThumInfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdl.seatms.project.system.mtThumInfo.mapper.MtThumInfoMapper;
import com.sdl.seatms.project.system.mtThumInfo.domain.MtThumInfo;
import com.sdl.seatms.project.system.mtThumInfo.service.IMtThumInfoService;
import com.sdl.seatms.common.utils.text.Convert;

/**
 * 座次图 服务层实现
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Service
public class MtThumInfoServiceImpl implements IMtThumInfoService 
{
	@Autowired
	private MtThumInfoMapper mtThumInfoMapper;

	/**
     * 查询座次图信息
     * 
     * @param thumId 座次图ID
     * @return 座次图信息
     */
    @Override
	public MtThumInfo selectMtThumInfoById(String thumId)
	{
	    return mtThumInfoMapper.selectMtThumInfoById(thumId);
	}
	
	/**
     * 查询座次图列表
     * 
     * @param mtThumInfo 座次图信息
     * @return 座次图集合
     */
	@Override
	public List<MtThumInfo> selectMtThumInfoList(MtThumInfo mtThumInfo)
	{
	    return mtThumInfoMapper.selectMtThumInfoList(mtThumInfo);
	}
	
    /**
     * 新增座次图
     * 
     * @param mtThumInfo 座次图信息
     * @return 结果
     */
	@Override
	public int insertMtThumInfo(MtThumInfo mtThumInfo)
	{
	    return mtThumInfoMapper.insertMtThumInfo(mtThumInfo);
	}
	
	/**
     * 修改座次图
     * 
     * @param mtThumInfo 座次图信息
     * @return 结果
     */
	@Override
	public int updateMtThumInfo(MtThumInfo mtThumInfo)
	{
	    return mtThumInfoMapper.updateMtThumInfo(mtThumInfo);
	}

	/**
     * 删除座次图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMtThumInfoByIds(String ids)
	{
		return mtThumInfoMapper.deleteMtThumInfoByIds(Convert.toStrArray(ids));
	}
	
}
