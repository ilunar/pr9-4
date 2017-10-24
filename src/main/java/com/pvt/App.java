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
        
        //запись добавится в таблицу
        Department dep=new Department();
        dep.setDepartmentName("IT");
        depServ.addDepartment(dep);
        
        /*в таблице ограничение-> не более 5 символов для departmentName
        запись добавится
        затем BatchUpdateException: Data truncation: Data too long for column 'departmentName'
        затем откат транзакции: transaction rollback org.hibernate.exception.DataException:
        Could not execute JDBC batch update
        */
        Department dep2=new Department();
        dep2.setDepartmentName("notITnotIT");
        depServ.addDepartment(dep2);
    }
}

