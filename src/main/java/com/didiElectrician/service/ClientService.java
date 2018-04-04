package com.didiElectrician.service;

import com.didiElectrician.domain.Client;
import com.didiElectrician.service.base.BaseService;

public interface ClientService extends BaseService<Client>{
    boolean login(Client client);
}
