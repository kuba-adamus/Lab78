package lab78.dao;



//import com.lab78.model.Employee;

import lab78.model.Employee;
import java.util.*;

public interface EmployeeDAO {

    public void addEmployee(Employee emp);
    public void updateEmployee(Employee emp);
    public List<Employee> listEmployee();
    public Employee getEmployeeById(int id);
    public void removeEmployee(int id);
}