package com.didiElectrician.domain;

public class RolePermission {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.role_permission_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    private String rolePermissionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.role_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.permission_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    private String permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.role_permission_id
     *
     * @return the value of role_permission.role_permission_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public String getRolePermissionId() {
        return rolePermissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.role_permission_id
     *
     * @param rolePermissionId the value for role_permission.role_permission_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public void setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.role_id
     *
     * @return the value of role_permission.role_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.role_id
     *
     * @param roleId the value for role_permission.role_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.permission_id
     *
     * @return the value of role_permission.permission_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.permission_id
     *
     * @param permissionId the value for role_permission.permission_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}