package com.pvt.model;

public class Department implements java.io.Serializable {
    private Integer departmentId;
    private String departmentName;
    
    public Integer getDepartmentId() {return departmentId;}
    public void setDepartmentId(Integer departmentId) {this.departmentId = departmentId;}
    public String getDepartmentName() {return departmentName;}
    public void setDepartmentName(String departmentName) {this.departmentName = departmentName;}
    
}
