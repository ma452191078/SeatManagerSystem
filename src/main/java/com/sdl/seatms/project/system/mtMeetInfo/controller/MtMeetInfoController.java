package com.sdl.seatms.project.system.mtMeetInfo.controller;

import java.util.List;
import java.util.UUID;

import com.sdl.seatms.common.utils.security.ShiroUtils;
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
import com.sdl.seatms.project.system.mtMeetInfo.domain.MtMeetInfo;
import com.sdl.seatms.project.system.mtMeetInfo.service.IMtMeetInfoService;
import com.sdl.seatms.framework.web.controller.BaseController;
import com.sdl.seatms.framework.web.page.TableDataInfo;
import com.sdl.seatms.framework.web.domain.AjaxResult;
import com.sdl.seatms.common.utils.poi.ExcelUtil;

/**
 * 会议信息操作处理
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Controller
@RequestMapping("/meeting/mtMeetInfo")
public class MtMeetInfoController extends BaseController
{
    private String prefix = "meeting/mtMeetInfo";
	
	@Autowired
	private IMtMeetInfoService mtMeetInfoService;
	
	@RequiresPermissions("meeting:mtMeetInfo:view")
	@GetMapping()
	public String mtMeetInfo()
	{
	    return prefix + "/mtMeetInfo";
	}
	
	/**
	 * 查询会议列表
	 */
	@RequiresPermissions("meeting:mtMeetInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MtMeetInfo mtMeetInfo)
	{
		startPage();
        List<MtMeetInfo> list = mtMeetInfoService.selectMtMeetInfoList(mtMeetInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出会议列表
	 */
	@RequiresPermissions("meeting:mtMeetInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MtMeetInfo mtMeetInfo)
    {
    	List<MtMeetInfo> list = mtMeetInfoService.selectMtMeetInfoList(mtMeetInfo);
        ExcelUtil<MtMeetInfo> util = new ExcelUtil<MtMeetInfo>(MtMeetInfo.class);
        return util.exportExcel(list, "mtMeetInfo");
    }
	
	/**
	 * 新增会议
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存会议
	 */
	@RequiresPermissions("meeting:mtMeetInfo:add")
	@Log(title = "会议", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MtMeetInfo mtMeetInfo)
	{		
		mtMeetInfo.setMeetId(UUID.randomUUID().toString());
		mtMeetInfo.setCreateBy(ShiroUtils.getSysUser().getUserName());
		return toAjax(mtMeetInfoService.insertMtMeetInfo(mtMeetInfo));
	}

	/**
	 * 修改会议
	 */
	@GetMapping("/edit/{meetId}")
	public String edit(@PathVariable("meetId") String meetId, ModelMap mmap)
	{
		MtMeetInfo mtMeetInfo = mtMeetInfoService.selectMtMeetInfoById(meetId);
		mmap.put("mtMeetInfo", mtMeetInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会议
	 */
	@RequiresPermissions("meeting:mtMeetInfo:edit")
	@Log(title = "会议", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MtMeetInfo mtMeetInfo)
	{		
		return toAjax(mtMeetInfoService.updateMtMeetInfo(mtMeetInfo));
	}
	
	/**
	 * 删除会议
	 */
	@RequiresPermissions("meeting:mtMeetInfo:remove")
	@Log(title = "会议", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(mtMeetInfoService.deleteMtMeetInfoByIds(ids));
	}
	
}
