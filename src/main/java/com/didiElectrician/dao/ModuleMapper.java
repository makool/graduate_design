package com.didiElectrician.dao;

import com.didiElectrician.dao.base.SinglePrimaryKeyBaseMapper;
import com.didiElectrician.domain.Module;

import java.util.List;

public interface ModuleMapper extends SinglePrimaryKeyBaseMapper<Module> {
    List<Module> getModuleByMobile(String mobile);
}