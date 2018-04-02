package com.didiElectrician.domain;

public class Module {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.module_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    private String moduleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.module_description
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    private String moduleDescription;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.parent_module_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    private String parentModuleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.module_text
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    private String moduleText;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.module_id
     *
     * @return the value of module.module_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.module_id
     *
     * @param moduleId the value for module.module_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.module_description
     *
     * @return the value of module.module_description
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public String getModuleDescription() {
        return moduleDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.module_description
     *
     * @param moduleDescription the value for module.module_description
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.parent_module_id
     *
     * @return the value of module.parent_module_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public String getParentModuleId() {
        return parentModuleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.parent_module_id
     *
     * @param parentModuleId the value for module.parent_module_id
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public void setParentModuleId(String parentModuleId) {
        this.parentModuleId = parentModuleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.module_text
     *
     * @return the value of module.module_text
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public String getModuleText() {
        return moduleText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.module_text
     *
     * @param moduleText the value for module.module_text
     *
     * @mbggenerated Mon Apr 02 19:50:50 CST 2018
     */
    public void setModuleText(String moduleText) {
        this.moduleText = moduleText;
    }
}