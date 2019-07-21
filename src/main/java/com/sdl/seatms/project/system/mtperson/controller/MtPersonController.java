package com.sdl.seatms.project.system.mtperson.controller;

import java.util.List;
import java.util.UUID;

import com.sdl.seatms.common.utils.security.ShiroUtils;
import com.sdl.seatms.project.system.mtmeetinfo.service.IMtMeetInfoService;
import com.sdl.seatms.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sdl.seatms.framework.aspectj.lang.annotation.Log;
import com.sdl.seatms.framework.aspectj.lang.enums.BusinessType;
import com.sdl.seatms.project.system.mtperson.domain.MtPerson;
import com.sdl.seatms.project.system.mtperson.service.IMtPersonService;
import com.sdl.seatms.framework.web.controller.BaseController;
import com.sdl.seatms.framework.web.page.TableDataInfo;
import com.sdl.seatms.framework.web.domain.AjaxResult;
import com.sdl.seatms.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 参会人员信息操作处理
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Controller
@RequestMapping("/meeting/mtPerson")
public class MtPersonController extends BaseController
{
    private String prefix = "meeting/mtPerson";
	
	@Autowired
	private IMtPersonService mtPersonService;

	@Autowired
	private IMtMeetInfoService mtMeetInfoService;
	
	@RequiresPermissions("meeting:mtperson:view")
	@GetMapping()
	public String mtPerson()
	{
	    return prefix + "/mtPerson";
	}

	@RequiresPermissions("meeting:mtperson:view")
	@GetMapping("/listForMeet/{meetId}")
	public String mtPersonForMeet(@PathVariable("meetId") String meetId, ModelMap mmap)
	{
		mmap.put("meetId",meetId);
		System.out.println(meetId);
		return prefix + "/mtPersonForMeet";
	}

	/**
	 * 查询参会人员列表
	 */
	@RequiresPermissions("meeting:mtperson:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MtPerson mtPerson)
	{
		startPage();
        List<MtPerson> list = mtPersonService.selectMtPersonList(mtPerson);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出参会人员列表
	 */
	@RequiresPermissions("meeting:mtperson:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MtPerson mtPerson)
    {
    	List<MtPerson> list = mtPersonService.selectMtPersonList(mtPerson);
        ExcelUtil<MtPerson> util = new ExcelUtil<MtPerson>(MtPerson.class);
        return util.exportExcel(list, "mtperson");
    }

	@Log(title = "会议管理", businessType = BusinessType.IMPORT)
	@RequiresPermissions("meeting:mtperson:import")
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport, String meetId) throws Exception
	{
		ExcelUtil<MtPerson> util = new ExcelUtil<MtPerson>(MtPerson.class);
		List<MtPerson> personList = util.importExcel(file.getInputStream());
		String message = mtPersonService.importPerson(personList, updateSupport, meetId);
		return AjaxResult.success(message);
	}

	@RequiresPermissions("meeting:mtperson:view")
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate()
	{
		ExcelUtil<MtPerson> util = new ExcelUtil<MtPerson>(MtPerson.class);
		return util.importTemplateExcel("用户数据");
	}

	/**
	 * 新增参会人员
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String id, ModelMap mmap)
	{
		mmap.put("meetInfo", mtMeetInfoService.selectMtMeetInfoById(id));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存参会人员
	 */
	@RequiresPermissions("meeting:mtperson:add")
	@Log(title = "参会人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MtPerson mtPerson)
	{		
		mtPerson.setPersonId(UUID.randomUUID().toString());
		mtPerson.setCreateBy(ShiroUtils.getSysUser().getUserName());
		return toAjax(mtPersonService.insertMtPerson(mtPerson));
	}

	/**
	 * 修改参会人员
	 */
	@GetMapping("/edit/{personId}")
	public String edit(@PathVariable("personId") String personId, ModelMap mmap)
	{
		MtPerson mtPerson = mtPersonService.selectMtPersonById(personId);
		mmap.put("mtperson", mtPerson);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存参会人员
	 */
	@RequiresPermissions("meeting:mtperson:edit")
	@Log(title = "参会人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MtPerson mtPerson)
	{		
		return toAjax(mtPersonService.updateMtPerson(mtPerson));
	}
	
	/**
	 * 删除参会人员
	 */
	@RequiresPermissions("meeting:mtperson:remove")
	@Log(title = "参会人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(mtPersonService.deleteMtPersonByIds(ids));
	}
	
}
