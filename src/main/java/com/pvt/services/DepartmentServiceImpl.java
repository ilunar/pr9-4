package com.pvt.services;

import DAO.DepartmentDAO;
import com.pvt.model.Department;
import org.hibernate.HibernateException;
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

    public void addDepartment(final Department dep) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {			
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
		try{
                    departmentDAO.addDepartment(dep);
                }catch(HibernateException ex){
                    status.setRollbackOnly();
                    System.out.println("transaction rollback "+ex);
                }
            }
	});
    }
    
    
}
