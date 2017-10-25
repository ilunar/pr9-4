package com.pvt.services;

import DAO.DepartmentDAO;
import com.pvt.model.Department;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class DepartmentServiceImpl implements DepartmentService{
    private TransactionTemplate transactionTemplate;
    private DepartmentDAO departmentDAO;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }
    //метод вставляет запись в таблицу, потом выбрасывает исключение,
    //что приводит к откату транзакции
    public void addDepartment(final Department dep) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {			
            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {
		try{
                    departmentDAO.addDepartment(dep);
                    throw new RuntimeException("Exception throwed!");
                }catch(Exception ex){
                    status.setRollbackOnly();
                    System.out.println(ex);
                }
            }
	});
    }
    
    
}
