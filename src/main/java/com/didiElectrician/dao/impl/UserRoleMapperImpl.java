package com.didiElectrician.dao.impl;

import com.didiElectrician.dao.UserRoleMapper;
import com.didiElectrician.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.didiElectrician.domain.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleMapperImpl extends SinglePrimaryKeyBaseDAOImpl<UserRole> implements UserRoleMapper {
}
