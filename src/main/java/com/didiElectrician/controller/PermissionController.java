package com.didiElectrician.controller;

import com.didiElectrician.domain.Permission;
import com.didiElectrician.service.PermissionService;
import com.didiElectrician.util.JsonUtil;
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
@RequestMapping("/permission")
public class PermissionController {

    private static final Logger logger = Logger.getLogger(PermissionController.class.toString());

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/getPermissionByModuleId",method = RequestMethod.POST)
    @ResponseBody
    public String getPermissionByModuleId(String module_id) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        if(module_id == null || "".equals(module_id)) {
            logger.info("ModuleController.getPermissionByModuleId的传参module_id为空");
            return JsonUtil.toObject(map).toString();
        }
        List<Permission> list = permissionService.getPermissionByModuleId(module_id);
        return JsonUtil.toArray(list).toString();
    }

    @RequestMapping(value = "/updatePermission" ,method = RequestMethod.POST)
    @ResponseBody
    public String updatePermission(Permission permission) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        logger.info("======" + "update permission 开始" + "======");
        map.put("success", permissionService.updateByPrimaryKeySelective(permission));
        logger.info("======" + "update permission 结束" + "======");
        return JsonUtil.toObject(map).toString();
    }





}
