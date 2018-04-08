package com.didiElectrician.service;

import com.didiElectrician.domain.Role;
import com.didiElectrician.service.base.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role>{
    Role getRoleByMobile(String mobile);
    List<Role> getRoleListByMobile(String mobile);
    boolean assignRoles(String mobile, Role role);
}
