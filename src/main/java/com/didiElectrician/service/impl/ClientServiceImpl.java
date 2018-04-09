package com.didiElectrician.service.impl;

import com.didiElectrician.dao.ClientMapper;
import com.didiElectrician.domain.Client;
import com.didiElectrician.service.ClientService;
import com.didiElectrician.service.base.impl.BaseServiceImpl;
import com.didiElectrician.util.MyBatisMapUtil;
import com.didiElectrician.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client> implements ClientService{

    private static final Logger logger = Logger.getLogger(ClientServiceImpl.class.toString());

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

    @Override
    public boolean validateClient(Client client) {

        //检查手机号码是否存在
        Client c = clientMapper.selectByPrimaryKey(client.getMobile());
        if(c != null) {
            logger.info("======" + client.getMobile() + "   " + "此手机号码已经存在" + "======");
            return false;
        }

        //检查个人信息是否正确
        List<String> list = ValidationUtil.validateClient(client);
        if(list.size() != 0) {
            logger.info("======" + list.toString() + "======");
            return false;
        }

        return true;
    }
}
