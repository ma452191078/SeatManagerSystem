package com.sdl.seatms.project.mobile;

import com.sdl.seatms.common.utils.StringUtils;
import com.sdl.seatms.framework.aspectj.lang.annotation.Log;
import com.sdl.seatms.framework.aspectj.lang.enums.BusinessType;
import com.sdl.seatms.framework.web.controller.BaseController;
import com.sdl.seatms.framework.web.domain.AjaxResult;
import com.sdl.seatms.framework.web.domain.Ztree;
import com.sdl.seatms.project.system.dept.domain.Dept;
import com.sdl.seatms.project.system.dept.service.IDeptService;
import com.sdl.seatms.project.system.mtagendaitem.service.IMtAgendaItemService;
import com.sdl.seatms.project.system.mtagendatitle.domain.MtAgendaTitle;
import com.sdl.seatms.project.system.mtagendatitle.service.IMtAgendaTitleService;
import com.sdl.seatms.project.system.mtmeetinfo.domain.MtMeetInfo;
import com.sdl.seatms.project.system.mtmeetinfo.service.IMtMeetInfoService;
import com.sdl.seatms.project.system.mtperson.domain.MtPerson;
import com.sdl.seatms.project.system.mtperson.service.IMtPersonService;
import com.sdl.seatms.project.system.mtthuminfo.domain.MtThumInfo;
import com.sdl.seatms.project.system.mtthuminfo.service.IMtThumInfoService;
import com.sdl.seatms.project.system.role.domain.Role;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpOAuth2Service;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 部门信息
 * 
 * @author sdl
 */
@Controller
@RequestMapping("/mobile")
public class MobileController extends BaseController
{
    private String prefix = "mobile";

    @Autowired
    private IDeptService deptService;

    @Autowired
    private IMtMeetInfoService mtMeetInfoService;

    @Autowired
    private IMtPersonService mtPersonService;

    @Autowired
    private IMtThumInfoService mtThumInfoService;

    @Autowired
    private IMtAgendaTitleService mtAgendaTitleService;

    @Autowired
    private IMtAgendaItemService mtAgendaItemService;

    @Autowired
    WxCpService wxCpService;

    @GetMapping("/index/{meetId}")
    public String mobile(@PathVariable("meetId") String meetId, @RequestParam(value="code",required = false) String code, ModelMap mmap)
    {
        WxCpUser wxCpUser = null;
        if (StringUtils.isNotEmpty(code)){
            WxCpOAuth2Service wxCpOAuth2Service = wxCpService.getOauth2Service();

            String[] res = new String[0];
            try {
                res = wxCpOAuth2Service.getUserInfo(code);
                wxCpUser = wxCpService.getUserService().getById(res[0]);
            } catch (WxErrorException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotEmpty(meetId)){
            MtMeetInfo mtMeetInfo = mtMeetInfoService.selectMtMeetInfoById(meetId);
            HashMap<Integer, List<MtThumInfo>> thumList = new HashMap<Integer, List<MtThumInfo>>();
            MtThumInfo query = new MtThumInfo();
            query.setMeetId(meetId);
            for (int i=1; i<=mtMeetInfo.getMeetRow(); i++){
                query.setThumRow(i);
                thumList.put(i,mtThumInfoService.selectMtThumInfoList(query));
            }
            mmap.addAttribute("mtMeetInfo", mtMeetInfo);
            mmap.addAttribute("thumList", thumList);
            mmap.addAttribute("wxCpUser", wxCpUser);
        }

        return prefix + "/index";
    }


    @PostMapping("/getPersonInfo")
    @ResponseBody
    public HashMap<String, Object> getPersonInfo(MtPerson person)
    {
        HashMap<String, Object> result = new HashMap<>();
        int code = 1;
        String msg = "";
        if (StringUtils.isNotEmpty(person.getPersonCode())){
            MtPerson mtPerson = mtPersonService.selectMtPersonByCode(person.getPersonCode());
            if (mtPerson != null ){
                MtThumInfo mtThumInfo = mtThumInfoService.selectMtThumInfoByAreaId(mtPerson.getMeetId(),mtPerson.getPersonArea());
                mtPerson.setMtThumInfo(mtThumInfo);
                result.put("mtPerson", mtPerson);
                code = 0;
                msg = "成功";
            }
        } else {
            msg = "请输入姓名";
        }
        result.put("code",code);
        result.put("msg",msg);
        return result;
    }

    @GetMapping("/getScheduleInfo/{meetId}")
    public String getAgendaInfo(@PathVariable("meetId") String meetId, ModelMap mmap)
    {
        if (StringUtils.isNotEmpty(meetId)){

            List<MtAgendaTitle> mtAgendaTitleList = mtAgendaTitleService.selectMtAgendaTitleListByMeetId(meetId);

            mmap.addAttribute("agendaList", mtAgendaTitleList);
            mmap.addAttribute("meetId", meetId);
        }

        return prefix + "/agenda";
    }

}
