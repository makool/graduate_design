package com.didiElectrician.service;

import com.didiElectrician.domain.Module;
import com.didiElectrician.service.base.BaseService;

import java.util.List;

public interface ModuleService extends BaseService<Module>{
    List<Module> getModuleByMobile(String mobile);
}
