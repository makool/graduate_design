package com.didiElectrician.service.impl;

import com.didiElectrician.dao.RoleMapper;
import com.didiElectrician.dao.UserRoleMapper;
import com.didiElectrician.domain.Role;
import com.didiElectrician.domain.UserRole;
import com.didiElectrician.service.RoleService;
import com.didiElectrician.service.base.impl.BaseServiceImpl;
import com.didiElectrician.util.MyBatisMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

    private static final Logger logger = Logger.getLogger(RoleServiceImpl.class.toString());

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Role getRoleByMobile(String mobile) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id",mobile);

        return null;
    }

    @Override
    public List<Role> getRoleListByMobile(String mobile) {
        return null;
    }
}
