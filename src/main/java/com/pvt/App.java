package com.pvt;

import com.pvt.model.Department;
import com.pvt.services.DepartmentService;
import com.pvt.services.DepartmentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService depServ= (DepartmentServiceImpl) context.getBean("departmentService");
        
        Department dep=new Department();
        dep.setDepartmentName("IT");
        //метод вставляет запись в таблицу, потом выбрасывает исключение,
        //что приводит к откату транзакции, БД остается в исходном состоянии
        depServ.addDepartment(dep);
        
    }
}

