package com.sdl.seatms.project.system.mtmeetinfo.service;

import java.util.List;
import java.util.UUID;

import com.sdl.seatms.project.system.mtthuminfo.domain.MtThumInfo;
import com.sdl.seatms.project.system.mtthuminfo.mapper.MtThumInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdl.seatms.project.system.mtmeetinfo.mapper.MtMeetInfoMapper;
import com.sdl.seatms.project.system.mtmeetinfo.domain.MtMeetInfo;
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

	@Autowired
	private MtThumInfoMapper mtThumInfoMapper;

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
	    int result = mtMeetInfoMapper.insertMtMeetInfo(mtMeetInfo);
	    // 初始化会场座次图
	    if (result > 0) {
			MtThumInfo thumInfo;
	    	for (int i=1; i <= mtMeetInfo.getMeetRow(); i++){
	    		for (int j=1; j <= mtMeetInfo.getMeetCol(); j++){
					thumInfo = new MtThumInfo();
					thumInfo.setThumId(UUID.randomUUID().toString());
					thumInfo.setMeetId(mtMeetInfo.getMeetId());
					thumInfo.setThumRow(i);
					thumInfo.setThumCol(j);
					thumInfo.setAreaId(i + "-" + j);
					thumInfo.setCreateBy(mtMeetInfo.getCreateBy());
					mtThumInfoMapper.insertMtThumInfo(thumInfo);
				}
			}
		}
		return result;
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
	    MtMeetInfo old = mtMeetInfoMapper.selectMtMeetInfoById(mtMeetInfo.getMeetId());
	    List<MtThumInfo> mtThumInfoList = mtThumInfoMapper.selectMtThumInfoListByMeetId(mtMeetInfo.getMeetId());
	    if (mtThumInfoList != null && mtThumInfoList.size() != 0) {
			if (mtMeetInfo.getMeetRow() > old.getMeetRow()){
				// 大于原行数
				MtThumInfo thumInfo;
				for (int i= 1; i <= mtMeetInfo.getMeetRow(); i++) {
					if (mtMeetInfo.getMeetCol() > old.getMeetCol()) {
						// 比原来的列多,遍历每一行并增加列，在新行增加所有列
						for (int j=1; j<=mtMeetInfo.getMeetCol(); j++) {
							if (i <= old.getMeetRow() && j <= old.getMeetCol()){
								continue;
							}
							thumInfo = new MtThumInfo();
							thumInfo.setThumId(UUID.randomUUID().toString());
							thumInfo.setMeetId(mtMeetInfo.getMeetId());
							thumInfo.setThumRow(i);
							thumInfo.setThumCol(j);
							thumInfo.setAreaId(i + "-" + j);
							thumInfo.setCreateBy(mtMeetInfo.getUpdateBy());
							mtThumInfoMapper.insertMtThumInfo(thumInfo);
						}
					} else if (mtMeetInfo.getMeetCol() <= old.getMeetCol()){
						// 比原来的列数少，遍历每一行，删除多余的列，在新行中增加所有列
						for (int j=1; j <= old.getMeetCol(); j++) {
							if (i <= old.getMeetRow()){
								// 已存在行，多余列删除
								if (j <= mtMeetInfo.getMeetCol()){
									continue;
								} else {
									MtThumInfo query = new MtThumInfo();
									query.setMeetId(mtMeetInfo.getMeetId());
									query.setThumRow(i);
									query.setThumCol(j);
									mtThumInfoMapper.deleteMtThumInfoByInfo(query);
								}
							} else {
								// 新行
								thumInfo = new MtThumInfo();
								thumInfo.setThumId(UUID.randomUUID().toString());
								thumInfo.setMeetId(mtMeetInfo.getMeetId());
								thumInfo.setThumRow(i);
								thumInfo.setThumCol(j);
								thumInfo.setAreaId(i + "-" + j);
								thumInfo.setCreateBy(mtMeetInfo.getUpdateBy());
								mtThumInfoMapper.insertMtThumInfo(thumInfo);
							}
						}
					}
				}
			} else {
				// 行数小于原行数 mtMeetInfo.getMeetRow() <= old.getMeetRow()
				for (int i=1; i<=old.getMeetRow(); i++){
					if (i > mtMeetInfo.getMeetRow()){
						MtThumInfo query = new MtThumInfo();
						query.setMeetId(mtMeetInfo.getMeetId());
						query.setThumRow(i);
						mtThumInfoMapper.deleteMtThumInfoByInfo(query);
					} else if (i <= mtMeetInfo.getMeetRow()){
						MtThumInfo thumInfo;
						if (mtMeetInfo.getMeetCol() > old.getMeetCol()) {
							// 比原来的列多,遍历每一行并增加列，在新行增加所有列
							for (int j=1; j<=mtMeetInfo.getMeetCol(); j++) {
								if (i <= old.getMeetRow() && j <= old.getMeetCol()){
									continue;
								}
								thumInfo = new MtThumInfo();
								thumInfo.setThumId(UUID.randomUUID().toString());
								thumInfo.setMeetId(mtMeetInfo.getMeetId());
								thumInfo.setThumRow(i);
								thumInfo.setThumCol(j);
								thumInfo.setAreaId(i + "-" + j);
								mtThumInfoMapper.insertMtThumInfo(thumInfo);
							}
						} else if (mtMeetInfo.getMeetCol() <= old.getMeetCol()){
							// 比原来的列数少，遍历每一行，删除多余的列，在新行中增加所有列
							for (int j=1; j <= old.getMeetCol(); j++) {
								if (i <= old.getMeetRow()){
									// 已存在行，多余列删除
									if (j <= mtMeetInfo.getMeetCol()){
										continue;
									} else {
										MtThumInfo query = new MtThumInfo();
										query.setMeetId(mtMeetInfo.getMeetId());
										query.setThumRow(i);
										query.setThumCol(j);
										mtThumInfoMapper.deleteMtThumInfoByInfo(query);
									}
								} else {
									// 新行
									thumInfo = new MtThumInfo();
									thumInfo.setThumId(UUID.randomUUID().toString());
									thumInfo.setMeetId(mtMeetInfo.getMeetId());
									thumInfo.setThumRow(i);
									thumInfo.setThumCol(j);
									thumInfo.setAreaId(i + "-" + j);
									mtThumInfoMapper.insertMtThumInfo(thumInfo);
								}
							}
						}
					}
				}
			}
		}

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
