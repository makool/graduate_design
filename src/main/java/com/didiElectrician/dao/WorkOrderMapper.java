package com.didiElectrician.dao;

import com.didiElectrician.domain.WorkOrder;

public interface WorkOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_order
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int deleteByPrimaryKey(String workOrderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_order
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int insert(WorkOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_order
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int insertSelective(WorkOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_order
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    WorkOrder selectByPrimaryKey(String workOrderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_order
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int updateByPrimaryKeySelective(WorkOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_order
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    int updateByPrimaryKey(WorkOrder record);
}