package com.didiElectrician.service;

import com.didiElectrician.domain.Module;

import java.util.List;

public interface ModuleService {
    List<Module> getModuleByMobile(String mobile);
}
