
package DAO;

import com.pvt.model.Department;
import org.hibernate.*;

public class DepartmentDAOHibernate implements DepartmentDAO {

    private final SessionFactory sessionFactory;
    private final Session session;

    public DepartmentDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session=sessionFactory.openSession();
    }
    
    public void addDepartment(Department dep) {
        session.save(dep);
        session.flush();
    }

}
