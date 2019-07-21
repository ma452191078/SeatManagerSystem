package com.sdl.seatms.project.system.mtperson.service;

import java.util.List;
import java.util.UUID;

import com.sdl.seatms.common.exception.BusinessException;
import com.sdl.seatms.common.utils.StringUtils;
import com.sdl.seatms.common.utils.security.ShiroUtils;
import com.sdl.seatms.project.system.user.domain.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdl.seatms.project.system.mtperson.mapper.MtPersonMapper;
import com.sdl.seatms.project.system.mtperson.domain.MtPerson;
import com.sdl.seatms.common.utils.text.Convert;

/**
 * 参会人员 服务层实现
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Log4j2
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

	/**
	 * 导入参会人员数据
	 *
	 * @param personList 参会人员数据列表
	 * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
	 * @param meetId 会议id
	 * @return 结果
	 */
	@Override
	public String importPerson(List<MtPerson> personList, Boolean isUpdateSupport, String meetId)
	{
		if (StringUtils.isNull(personList) || personList.size() == 0)
		{
			throw new BusinessException("参会人员数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		String operName = ShiroUtils.getLoginName();
		for (MtPerson person : personList)
		{
			try
			{
				// 验证是否存在这个用户
				MtPerson query = new MtPerson();
				query.setMeetId(meetId);
				query.setPersonCode(person.getPersonCode());
				MtPerson p = mtPersonMapper.selectMtPersonByObject(query);
				if (StringUtils.isNull(p))
				{
					person.setPersonId(UUID.randomUUID().toString());
					person.setCreateBy(operName);
					person.setMeetId(meetId);
					this.insertMtPerson(person);
					successNum++;
					successMsg.append("<br/>" + successNum + "、员工 " + person.getPersonCode() + person.getPersonName() + " 导入成功");
				}
				else if (isUpdateSupport)
				{
					person.setPersonId(p.getPersonId());
					person.setUpdateBy(operName);
					this.updateMtPerson(person);
					successNum++;
					successMsg.append("<br/>" + successNum + "、员工 " + person.getPersonCode() + person.getPersonName() + " 更新成功");
				}
				else
				{
					failureNum++;
					failureMsg.append("<br/>" + failureNum + "、员工 " + person.getPersonCode() + person.getPersonName() + " 已存在");
				}
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、员工 " + person.getPersonCode() + person.getPersonName() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

	/**
	 * 查询参会人数
	 * @param meetId
	 * @return
	 */
	@Override
	public Integer selectPersonCount(String meetId) {
		return mtPersonMapper.selectPersonCount(meetId);
	}

}
