package com.didiElectrician.dao.impl;

import com.didiElectrician.dao.PermissionMapper;
import com.didiElectrician.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.didiElectrician.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionMapperImpl extends SinglePrimaryKeyBaseDAOImpl<Permission> implements PermissionMapper {

    @Override
    public List<Permission> getPermissionByModuleId(String module_id) {
        return template.selectList(getNamespace("getPermissionByModuleId"),module_id);
    }
}
