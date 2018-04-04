package com.didiElectrician.service;

import com.didiElectrician.domain.Electrician;
import com.didiElectrician.service.base.BaseService;

public interface ElectricianService extends BaseService<Electrician> {
    boolean login(Electrician electrician);
}
