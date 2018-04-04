package com.didiElectrician.dao.impl;

import com.didiElectrician.dao.PermissionMapper;
import com.didiElectrician.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.didiElectrician.domain.Permission;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionMapperImpl extends SinglePrimaryKeyBaseDAOImpl<Permission> implements PermissionMapper {
}
