package com.didiElectrician.service.impl;

import com.didiElectrician.dao.ModuleMapper;
import com.didiElectrician.domain.Module;
import com.didiElectrician.service.ModuleService;
import com.didiElectrician.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl extends BaseServiceImpl<Module> implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public List<Module> getModuleByMobile(String mobile) {
        return moduleMapper.getModuleByMobile(mobile);
    }
}
