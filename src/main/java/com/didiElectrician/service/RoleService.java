package com.didiElectrician.service;

import com.didiElectrician.domain.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByMobile(String mobile);
    List<Role> getRoleListByMobile(String mobile);
}
