package com.didiElectrician.dao;

import com.didiElectrician.dao.base.SinglePrimaryKeyBaseMapper;
import com.didiElectrician.domain.Permission;

import java.util.List;

public interface PermissionMapper extends SinglePrimaryKeyBaseMapper<Permission> {
    List<Permission> getPermissionByModuleId(String module_id);

}