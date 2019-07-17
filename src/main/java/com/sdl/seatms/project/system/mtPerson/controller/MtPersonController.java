package com.sdl.seatms.project.system.mtPerson.controller;

import java.util.List;
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
import com.sdl.seatms.project.system.mtPerson.domain.MtPerson;
import com.sdl.seatms.project.system.mtPerson.service.IMtPersonService;
import com.sdl.seatms.framework.web.controller.BaseController;
import com.sdl.seatms.framework.web.page.TableDataInfo;
import com.sdl.seatms.framework.web.domain.AjaxResult;
import com.sdl.seatms.common.utils.poi.ExcelUtil;

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
	
	@RequiresPermissions("meeting:mtPerson:view")
	@GetMapping()
	public String mtPerson()
	{
	    return prefix + "/mtPerson";
	}
	
	/**
	 * 查询参会人员列表
	 */
	@RequiresPermissions("meeting:mtPerson:list")
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
	@RequiresPermissions("meeting:mtPerson:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MtPerson mtPerson)
    {
    	List<MtPerson> list = mtPersonService.selectMtPersonList(mtPerson);
        ExcelUtil<MtPerson> util = new ExcelUtil<MtPerson>(MtPerson.class);
        return util.exportExcel(list, "mtPerson");
    }
	
	/**
	 * 新增参会人员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存参会人员
	 */
	@RequiresPermissions("meeting:mtPerson:add")
	@Log(title = "参会人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MtPerson mtPerson)
	{		
		return toAjax(mtPersonService.insertMtPerson(mtPerson));
	}

	/**
	 * 修改参会人员
	 */
	@GetMapping("/edit/{personId}")
	public String edit(@PathVariable("personId") String personId, ModelMap mmap)
	{
		MtPerson mtPerson = mtPersonService.selectMtPersonById(personId);
		mmap.put("mtPerson", mtPerson);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存参会人员
	 */
	@RequiresPermissions("meeting:mtPerson:edit")
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
	@RequiresPermissions("meeting:mtPerson:remove")
	@Log(title = "参会人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(mtPersonService.deleteMtPersonByIds(ids));
	}
	
}
