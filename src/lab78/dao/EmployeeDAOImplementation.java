package lab78.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import lab78.model.Employee;
import java.util.*;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

	//private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImplementation.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	//@Override
	public void addEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(emp);
		//logger.info("Employee saved successfully, Employee Details="+emp);
	}

	//@Override
	public void updateEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(emp);
		//logger.info("Employee updated successfully, Employee Details="+emp);
	}

	@SuppressWarnings("unchecked")
	//@Override
	public List<Employee> listEmployee() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		//for(Employee emp : employeeList){
		//	logger.info("Employee List::"+emp);
		//}
		return employeeList;
	}

	//@Override
	public Employee getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		//logger.info("Employee loaded successfully, Employee details="+emp);
		return emp;
	}

	//@Override
	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		if(null != emp){
			session.delete(emp);
		}
		//logger.info("Employee deleted successfully, Employee details="+emp);
	}

}