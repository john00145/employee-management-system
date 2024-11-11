package com.ph.employee_management_system.Employee.Controller;

import com.ph.employee_management_system.Employee.Model.Employee;
import com.ph.employee_management_system.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String employee(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "views/list-employee";
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model) {
        model.addAttribute("employees", new Employee());
        return "views/new-employee";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id).orElse(null);
        model.addAttribute("employee", employee);
        return "views/edit-employee";
    }

    @PostMapping("/update-employee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
