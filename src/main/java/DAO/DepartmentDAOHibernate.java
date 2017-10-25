
package DAO;

import com.pvt.model.Department;
import org.hibernate.*;

public class DepartmentDAOHibernate implements DepartmentDAO {

    private  SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void addDepartment(Department dep) {
        Session session = sessionFactory.getCurrentSession();
        session.save(dep);
        session.flush();
    }

}
