package com.didiElectrician.dao;

import com.didiElectrician.domain.RoleModule;

public interface RoleModuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_module
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int deleteByPrimaryKey(String roleModuleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_module
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int insert(RoleModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_module
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int insertSelective(RoleModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_module
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    RoleModule selectByPrimaryKey(String roleModuleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_module
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int updateByPrimaryKeySelective(RoleModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_module
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int updateByPrimaryKey(RoleModule record);
}