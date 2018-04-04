package com.didiElectrician.dao.impl;

import com.didiElectrician.dao.ModuleMapper;
import com.didiElectrician.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.didiElectrician.domain.Module;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class ModuleMapperImpl extends SinglePrimaryKeyBaseDAOImpl<Module> implements ModuleMapper {

    private static final Logger logger = Logger.getLogger(ModuleMapperImpl.class.toString());

    @Override
    public List<Module> getModuleByMobile(String mobile) {
        return template.selectList(getNamespace("getModuleByMobile"), mobile);
    }
}
