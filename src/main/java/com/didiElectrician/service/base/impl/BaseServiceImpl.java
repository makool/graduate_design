package com.didiElectrician.service.base.impl;

import com.didiElectrician.dao.base.SinglePrimaryKeyBaseMapper;
import com.didiElectrician.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T> implements BaseService<T>{

    @Autowired
    private SinglePrimaryKeyBaseMapper<T> singlePrimaryKeyBaseMapper;

    @Override
    public boolean insert(T t) {
        try {
            singlePrimaryKeyBaseMapper.insert(t);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(T t) {
        try{
            singlePrimaryKeyBaseMapper.updateByPrimaryKeySelective(t);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String key) {
        try{
            singlePrimaryKeyBaseMapper.deleteByPrimaryKey(key);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public T selectByPrimaryKey(String key) {
        return (T)singlePrimaryKeyBaseMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<T> select(Map map) {
        return singlePrimaryKeyBaseMapper.selectByParameters(map);
    }
}
