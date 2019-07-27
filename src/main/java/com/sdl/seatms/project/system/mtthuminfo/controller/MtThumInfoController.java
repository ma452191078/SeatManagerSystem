package com.sdl.seatms.project.system.mtthuminfo.controller;

import java.util.HashMap;
import java.util.List;

import com.sdl.seatms.project.system.mtmeetinfo.domain.MtMeetInfo;
import com.sdl.seatms.project.system.mtmeetinfo.service.IMtMeetInfoService;
import com.sdl.seatms.project.system.mtperson.service.IMtPersonService;
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
import com.sdl.seatms.project.system.mtthuminfo.domain.MtThumInfo;
import com.sdl.seatms.project.system.mtthuminfo.service.IMtThumInfoService;
import com.sdl.seatms.framework.web.controller.BaseController;
import com.sdl.seatms.framework.web.page.TableDataInfo;
import com.sdl.seatms.framework.web.domain.AjaxResult;
import com.sdl.seatms.common.utils.poi.ExcelUtil;

/**
 * 座次图信息操作处理
 * 
 * @author sdl
 * @date 2019-07-17
 */
@Controller
@RequestMapping("/meeting/mtThumInfo")
public class MtThumInfoController extends BaseController
{
    private String prefix = "meeting/mtThumInfo";
	
	@Autowired
	private IMtThumInfoService mtThumInfoService;

	@Autowired
	private IMtMeetInfoService mtMeetInfoService;
	
	// @RequiresPermissions("meeting:mtthuminfo:view")
	@GetMapping()
	public String mtThumInfo()
	{
	    return prefix + "/mtThumInfo";
	}

	// @RequiresPermissions("meeting:mtthuminfo:view")
	@GetMapping("/listForMeet/{meetId}")
	public String mtThumInfo(@PathVariable("meetId") String meetId, ModelMap mmap)
	{
		MtMeetInfo meetInfo = mtMeetInfoService.selectMtMeetInfoById(meetId);
		HashMap<Integer, List<MtThumInfo>> thumList = new HashMap<Integer, List<MtThumInfo>>();
		MtThumInfo query = new MtThumInfo();
		query.setMeetId(meetId);
		for (int i=1; i<=meetInfo.getMeetRow(); i++){
			query.setThumRow(i);
			thumList.put(i,mtThumInfoService.selectMtThumInfoList(query));
		}
		mmap.put("meetId", meetId);
		mmap.put("meetInfo", meetInfo);
		mmap.put("thumList", thumList);
		return prefix + "/mtThumInfoForMeet";
	}

	/**
	 * 查询座次图列表
	 */
	// @RequiresPermissions("meeting:mtthuminfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MtThumInfo mtThumInfo)
	{
		startPage();
        List<MtThumInfo> list = mtThumInfoService.selectMtThumInfoList(mtThumInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出座次图列表
	 */
	// @RequiresPermissions("meeting:mtthuminfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MtThumInfo mtThumInfo)
    {
    	List<MtThumInfo> list = mtThumInfoService.selectMtThumInfoList(mtThumInfo);
        ExcelUtil<MtThumInfo> util = new ExcelUtil<MtThumInfo>(MtThumInfo.class);
        return util.exportExcel(list, "mtThumInfo");
    }
	
	/**
	 * 新增座次图
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存座次图
	 */
	// @RequiresPermissions("meeting:mtthuminfo:add")
	@Log(title = "座次图", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MtThumInfo mtThumInfo)
	{		
		return toAjax(mtThumInfoService.insertMtThumInfo(mtThumInfo));
	}

	/**
	 * 修改座次图
	 */
	@GetMapping("/edit/{thumId}")
	public String edit(@PathVariable("thumId") String thumId, ModelMap mmap)
	{
		MtThumInfo mtThumInfo = mtThumInfoService.selectMtThumInfoById(thumId);
		MtMeetInfo mtMeetInfo = mtMeetInfoService.selectMtMeetInfoById(mtThumInfo.getMeetId());
		mmap.put("mtThumInfo", mtThumInfo);
		mmap.put("mtMeetInfo", mtMeetInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存座次图
	 */
	// @RequiresPermissions("meeting:mtthuminfo:edit")
	@Log(title = "座次图", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MtThumInfo mtThumInfo)
	{		
		return toAjax(mtThumInfoService.updateMtThumInfo(mtThumInfo));
	}
	
	/**
	 * 删除座次图
	 */
	// @RequiresPermissions("meeting:mtthuminfo:remove")
	@Log(title = "座次图", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(mtThumInfoService.deleteMtThumInfoByIds(ids));
	}
	
}
