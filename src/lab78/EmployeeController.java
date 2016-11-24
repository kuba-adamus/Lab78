package lab78;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.beans.annotation;

import lab78.service.EmployeeService;
import lab78.model.Employee;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired(required=true)
    @Qualifier(value="employeeService")
    public void setEmployeeService(EmployeeService es){
        this.employeeService = es;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employee";
    }

    @RequestMapping(value= "/employee/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee emp){

        if(emp.getId() == 0){

            this.employeeService.addEmployee(emp);
        }
        else{

            this.employeeService.updateEmployee(emp);
        }

        return "redirect:/employees";

    }

    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){

        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employee";
    }

}