package com.didiElectrician.dao.impl;

import com.didiElectrician.dao.RoleMapper;
import com.didiElectrician.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.didiElectrician.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleMapperImpl extends SinglePrimaryKeyBaseDAOImpl<Role> implements RoleMapper {
}
