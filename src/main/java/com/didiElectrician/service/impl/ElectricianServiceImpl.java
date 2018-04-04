package com.didiElectrician.service.impl;

import com.didiElectrician.dao.ElectricianMapper;
import com.didiElectrician.domain.Electrician;
import com.didiElectrician.service.ElectricianService;
import com.didiElectrician.service.base.impl.BaseServiceImpl;
import com.didiElectrician.util.MyBatisMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ElectricianServiceImpl extends BaseServiceImpl<Electrician>  implements ElectricianService {

    @Autowired
    private ElectricianMapper electricianMapper;

    @Override
    public boolean login(Electrician electrician) {
        Map<String,Object> map = new HashMap<>();
        map.put("mobile",electrician.getMobile());
        map.put("password",electrician.getPassword());
        List<Electrician> list = electricianMapper.selectByParameters(MyBatisMapUtil.warp(map));
        if(list.size() != 0) {
            return true;
        }
        return false;
    }
}
