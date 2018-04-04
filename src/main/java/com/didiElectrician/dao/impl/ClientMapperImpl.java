package com.didiElectrician.dao.impl;

import com.didiElectrician.dao.ClientMapper;
import com.didiElectrician.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.didiElectrician.domain.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientMapperImpl extends SinglePrimaryKeyBaseDAOImpl<Client> implements ClientMapper{

}
