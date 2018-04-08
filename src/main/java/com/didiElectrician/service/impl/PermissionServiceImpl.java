package com.didiElectrician.service.impl;

import com.didiElectrician.dao.PermissionMapper;
import com.didiElectrician.domain.Permission;
import com.didiElectrician.service.PermissionService;
import com.didiElectrician.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    private static final Logger logger = Logger.getLogger(PermissionServiceImpl.class.toString());

    @Override
    public List<Permission> getPermissionByModuleId(String moduleId) {
        logger.info("=============" + "通过moduleId获取permission开始" +  "=============");
        List<Permission> list = permissionMapper.getPermissionByModuleId(moduleId);
        logger.info("=============" + "通过moduleId获取permission结束" +  "=============");
        return list;
    }
}
