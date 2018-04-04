package com.didiElectrician.dao.impl;

import com.didiElectrician.dao.ElectricianMapper;
import com.didiElectrician.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.didiElectrician.domain.Electrician;
import org.springframework.stereotype.Repository;

@Repository
public class ElectricianMapperImpl extends SinglePrimaryKeyBaseDAOImpl<Electrician> implements ElectricianMapper {
}
