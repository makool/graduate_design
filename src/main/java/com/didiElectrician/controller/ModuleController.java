package com.didiElectrician.controller;

import com.didiElectrician.domain.Module;
import com.didiElectrician.service.ModuleService;
import com.didiElectrician.util.JsonUtil;
import com.didiElectrician.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/module")
public class ModuleController {

    public static final Logger logger = Logger.getLogger(ModuleController.class.toString());

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/getModuleByMobile", method = RequestMethod.POST)
    @ResponseBody
    public String getModuleByMobile(String mobile) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        if(ValidationUtil.validateMobile(mobile)) {
            logger.info("手机号码错误");
            return JsonUtil.toObject(map).toString();
        }
        List<Module> list = moduleService.getModuleByMobile(mobile);
        return JsonUtil.toArray(list).toString();
    }


    @RequestMapping(value = "/updateModule", method = RequestMethod.POST)
    @ResponseBody
    public String updateModule(Module module) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        logger.info("======" + "开始更新菜单" + "======");
        map.put("success", moduleService.updateByPrimaryKeySelective(module));
        logger.info("======" + "结束更新菜单" + "======");
        return JsonUtil.toObject(map).toString();
    }

}
