package com.sdl.seatms.project.system.mtagendatitle.controller;

import java.util.List;

import com.sdl.seatms.project.system.mtmeetinfo.domain.MtMeetInfo;
import com.sdl.seatms.project.system.mtmeetinfo.service.IMtMeetInfoService;
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
import com.sdl.seatms.project.system.mtagendatitle.domain.MtAgendaTitle;
import com.sdl.seatms.project.system.mtagendatitle.service.IMtAgendaTitleService;
import com.sdl.seatms.framework.web.controller.BaseController;
import com.sdl.seatms.framework.web.page.TableDataInfo;
import com.sdl.seatms.framework.web.domain.AjaxResult;
import com.sdl.seatms.common.utils.poi.ExcelUtil;

/**
 * 会议日程主
信息操作处理
 * 
 * @author sdl
 * @date 2019-07-24
 */
@Controller
@RequestMapping("/meeting/mtAgendaTitle")
public class MtAgendaTitleController extends BaseController
{
    private String prefix = "meeting/mtAgendaTitle";
	
	@Autowired
	private IMtAgendaTitleService mtAgendaTitleService;

	@Autowired
	private IMtMeetInfoService mtMeetInfoService;
	
	@RequiresPermissions("meeting:mtAgendaTitle:view")
	@GetMapping()
	public String mtAgendaTitle()
	{
	    return prefix + "/mtAgendaTitle";
	}

	@GetMapping("/listForMeet/{meetId}")
	public String mtAgendaTitleForMeet(@PathVariable("meetId") String meetId, ModelMap mmap)
	{
		mmap.put("meetId",meetId);
		MtAgendaTitle query = new MtAgendaTitle();
		query.setMeetId(meetId);
		List<MtAgendaTitle> list = mtAgendaTitleService.selectMtAgendaTitleList(query);
		mmap.put("agendaList", list);
		mmap.put("meetId", meetId);
		return prefix + "/mtAgendaTitleForMeet";
	}

	/**
	 * 查询会议日程主列表
	 */
	@RequiresPermissions("meeting:mtAgendaTitle:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MtAgendaTitle mtAgendaTitle)
	{
		startPage();
        List<MtAgendaTitle> list = mtAgendaTitleService.selectMtAgendaTitleList(mtAgendaTitle);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出会议日程主列表
	 */
	@RequiresPermissions("meeting:mtAgendaTitle:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MtAgendaTitle mtAgendaTitle)
    {
    	List<MtAgendaTitle> list = mtAgendaTitleService.selectMtAgendaTitleList(mtAgendaTitle);
        ExcelUtil<MtAgendaTitle> util = new ExcelUtil<MtAgendaTitle>(MtAgendaTitle.class);
        return util.exportExcel(list, "mtAgendaTitle");
    }
	
	/**
	 * 新增会议日程主
	 */
	@GetMapping("/add/{meetId}")
	public String add(@PathVariable("meetId") String meetId, ModelMap mmap)
	{
		MtMeetInfo mtMeetInfo = mtMeetInfoService.selectMtMeetInfoById(meetId);
	    mmap.put("mtMeetInfo", mtMeetInfo);
	    mmap.put("meetId", meetId);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存会议日程主
	 */
	@RequiresPermissions("meeting:mtAgendaTitle:add")
	@Log(title = "会议日程主", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MtAgendaTitle mtAgendaTitle)
	{		
		return toAjax(mtAgendaTitleService.insertMtAgendaTitle(mtAgendaTitle));
	}

	/**
	 * 修改会议日程主
	 */
	@GetMapping("/edit/{agendaId}")
	public String edit(@PathVariable("agendaId") String agendaId, ModelMap mmap)
	{
		MtAgendaTitle mtAgendaTitle = mtAgendaTitleService.selectMtAgendaTitleById(agendaId);
		mmap.put("mtAgendaTitle", mtAgendaTitle);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会议日程主

	 */
	@RequiresPermissions("meeting:mtAgendaTitle:edit")
	@Log(title = "会议日程主", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MtAgendaTitle mtAgendaTitle)
	{		
		return toAjax(mtAgendaTitleService.updateMtAgendaTitle(mtAgendaTitle));
	}
	
	/**
	 * 删除会议日程主

	 */
	@RequiresPermissions("meeting:mtAgendaTitle:remove")
	@Log(title = "会议日程主", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(mtAgendaTitleService.deleteMtAgendaTitleByIds(ids));
	}
	
}
