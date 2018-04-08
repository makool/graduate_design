package com.didiElectrician.service.base;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    boolean insert(T t);
    boolean updateByPrimaryKeySelective(T t);
    boolean deleteByPrimaryKey(String key);
    T selectByPrimaryKey(String key);
    List<T> select(Map map);
}
