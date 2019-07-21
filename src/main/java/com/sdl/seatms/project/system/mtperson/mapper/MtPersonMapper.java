package com.sdl.seatms.project.system.mtperson.mapper;

import com.sdl.seatms.project.system.mtperson.domain.MtPerson;
import java.util.List;	

/**
 * 参会人员 数据层
 * 
 * @author sdl
 * @date 2019-07-17
 */
public interface MtPersonMapper 
{
	/**
     * 查询参会人员信息
     * 
     * @param personId 参会人员ID
     * @return 参会人员信息
     */
	public MtPerson selectMtPersonById(String personId);
	public MtPerson selectMtPersonByCode(String personCode);
	public MtPerson selectMtPersonByObject(MtPerson person);

	/**
     * 查询参会人员列表
     * 
     * @param mtPerson 参会人员信息
     * @return 参会人员集合
     */
	public List<MtPerson> selectMtPersonList(MtPerson mtPerson);
	
	/**
     * 新增参会人员
     * 
     * @param mtPerson 参会人员信息
     * @return 结果
     */
	public int insertMtPerson(MtPerson mtPerson);
	
	/**
     * 修改参会人员
     * 
     * @param mtPerson 参会人员信息
     * @return 结果
     */
	public int updateMtPerson(MtPerson mtPerson);
	
	/**
     * 删除参会人员
     * 
     * @param personId 参会人员ID
     * @return 结果
     */
	public int deleteMtPersonById(String personId);
	
	/**
     * 批量删除参会人员
     * 
     * @param personIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMtPersonByIds(String[] personIds);

	/**
	 * 查询会议人数
	 * @param meetId
	 * @return
	 */
	Integer selectPersonCount(String meetId);
	
}