package com.didiElectrician.service.impl;

import com.didiElectrician.dao.ClientMapper;
import com.didiElectrician.domain.Client;
import com.didiElectrician.service.ClientService;
import com.didiElectrician.service.base.impl.BaseServiceImpl;
import com.didiElectrician.util.MyBatisMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client> implements ClientService{

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public boolean login(Client client) {
        //判断手机号码格式是否正确

        //判断密码格式是否正确

        Map<String,Object> map = new HashMap<>();
        map.put("mobile",client.getMobile());
        map.put("password",client.getPassword());
        List<Client> list = clientMapper.selectByParameters(MyBatisMapUtil.warp(map));

        if (list.size() == 0) {
            return false;
        }

        return true;
    }
}
