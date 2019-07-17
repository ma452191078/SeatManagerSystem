package com.sdl.seatms.project.system.mtPerson.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdl.seatms.project.system.mtPerson.mapper.MtPersonMapper;
import com.sdl.seatms.project.system.mtPerson.domain.MtPerson;
import com.sdl.seatms.project.system.mtPerson.service.IMtPersonService;
import com.sdl.seatms.common.utils.text.Convert;

/**
 * 参会人员 服务层实现
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Service
public class MtPersonServiceImpl implements IMtPersonService 
{
	@Autowired
	private MtPersonMapper mtPersonMapper;

	/**
     * 查询参会人员信息
     * 
     * @param personId 参会人员ID
     * @return 参会人员信息
     */
    @Override
	public MtPerson selectMtPersonById(String personId)
	{
	    return mtPersonMapper.selectMtPersonById(personId);
	}
	
	/**
     * 查询参会人员列表
     * 
     * @param mtPerson 参会人员信息
     * @return 参会人员集合
     */
	@Override
	public List<MtPerson> selectMtPersonList(MtPerson mtPerson)
	{
	    return mtPersonMapper.selectMtPersonList(mtPerson);
	}
	
    /**
     * 新增参会人员
     * 
     * @param mtPerson 参会人员信息
     * @return 结果
     */
	@Override
	public int insertMtPerson(MtPerson mtPerson)
	{
	    return mtPersonMapper.insertMtPerson(mtPerson);
	}
	
	/**
     * 修改参会人员
     * 
     * @param mtPerson 参会人员信息
     * @return 结果
     */
	@Override
	public int updateMtPerson(MtPerson mtPerson)
	{
	    return mtPersonMapper.updateMtPerson(mtPerson);
	}

	/**
     * 删除参会人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMtPersonByIds(String ids)
	{
		return mtPersonMapper.deleteMtPersonByIds(Convert.toStrArray(ids));
	}
	
}
