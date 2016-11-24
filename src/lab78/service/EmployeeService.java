package lab78.service;
import lab78.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee emp);
    public void updateEmployee(Employee emp);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(int id);
    public void removeEmployee(int id);

}