package com.sdl.seatms.project.system.mtperson.service;

import com.sdl.seatms.project.system.mtperson.domain.MtPerson;
import java.util.List;

/**
 * 参会人员 服务层
 * 
 * @author sdl
 * @date 2019-07-17
 */
public interface IMtPersonService 
{
	/**
     * 查询参会人员信息
     * 
     * @param personId 参会人员ID
     * @return 参会人员信息
     */
	public MtPerson selectMtPersonById(String personId);
	public MtPerson selectMtPersonByCode(String personCode);

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
     * 删除参会人员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMtPersonByIds(String ids);

	/**
	 * 导入参会人员数据
	 *
	 * @param personList 人员列表
	 * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
	 * @param meetId 会议id
	 * @return 结果
	 */
	public String importPerson(List<MtPerson> personList, Boolean isUpdateSupport, String meetId);

	/**
	 * 查询参会人数
	 * @param meetId
	 * @return
	 */
	public Integer selectPersonCount(String meetId);

    /**
     * 计算所在区域内的位置
     * @param mtPerson
     * @return
     */
    public MtPerson getPersonThumNum(MtPerson mtPerson);


}
