package com.sdl.seatms.project.system.mtagendaitem.controller;

import java.util.List;
import java.util.UUID;

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
import com.sdl.seatms.project.system.mtagendaitem.domain.MtAgendaItem;
import com.sdl.seatms.project.system.mtagendaitem.service.IMtAgendaItemService;
import com.sdl.seatms.framework.web.controller.BaseController;
import com.sdl.seatms.framework.web.page.TableDataInfo;
import com.sdl.seatms.framework.web.domain.AjaxResult;
import com.sdl.seatms.common.utils.poi.ExcelUtil;

/**
 * 会议日程明细信息操作处理
 * 
 * @author sdl
 * @date 2019-07-24
 */
@Controller
@RequestMapping("/meeting/mtAgendaItem")
public class MtAgendaItemController extends BaseController
{
    private String prefix = "meeting/mtAgendaItem";
	
	@Autowired
	private IMtAgendaItemService mtAgendaItemService;
	
	@RequiresPermissions("meeting:mtAgendaItem:view")
	@GetMapping()
	public String mtAgendaItem()
	{
	    return prefix + "/mtAgendaItem";
	}
	
	/**
	 * 查询会议日程明细列表
	 */
	@RequiresPermissions("meeting:mtAgendaItem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MtAgendaItem mtAgendaItem)
	{
		startPage();
        List<MtAgendaItem> list = mtAgendaItemService.selectMtAgendaItemList(mtAgendaItem);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出会议日程明细列表
	 */
	@RequiresPermissions("meeting:mtAgendaItem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MtAgendaItem mtAgendaItem)
    {
    	List<MtAgendaItem> list = mtAgendaItemService.selectMtAgendaItemList(mtAgendaItem);
        ExcelUtil<MtAgendaItem> util = new ExcelUtil<MtAgendaItem>(MtAgendaItem.class);
        return util.exportExcel(list, "mtAgendaItem");
    }
	
	/**
	 * 新增会议日程明细
	 */
	@GetMapping("/add/{agendId}")
	public String add(@PathVariable("agendId") String agendId, ModelMap mmap)
	{
	    mmap.put("agendId", agendId);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存会议日程明细
	 */
	@RequiresPermissions("meeting:mtAgendaItem:add")
	@Log(title = "会议日程明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MtAgendaItem mtAgendaItem)
	{
		mtAgendaItem.setItemId(UUID.randomUUID().toString());
		return toAjax(mtAgendaItemService.insertMtAgendaItem(mtAgendaItem));
	}

	/**
	 * 修改会议日程明细
	 */
	@GetMapping("/edit/{itemId}")
	public String edit(@PathVariable("itemId") String itemId, ModelMap mmap)
	{
		MtAgendaItem mtAgendaItem = mtAgendaItemService.selectMtAgendaItemById(itemId);
		mmap.put("mtAgendaItem", mtAgendaItem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会议日程明细
	 */
	@RequiresPermissions("meeting:mtAgendaItem:edit")
	@Log(title = "会议日程明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MtAgendaItem mtAgendaItem)
	{		
		return toAjax(mtAgendaItemService.updateMtAgendaItem(mtAgendaItem));
	}
	
	/**
	 * 删除会议日程明细
	 */
	@RequiresPermissions("meeting:mtAgendaItem:remove")
	@Log(title = "会议日程明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(mtAgendaItemService.deleteMtAgendaItemByIds(ids));
	}
	
}
