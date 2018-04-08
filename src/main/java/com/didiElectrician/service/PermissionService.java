package com.didiElectrician.service;

import com.didiElectrician.domain.Permission;
import com.didiElectrician.service.base.BaseService;

import java.util.List;

public interface PermissionService extends BaseService<Permission>{
    List<Permission> getPermissionByModuleId(String moduleId);
}
