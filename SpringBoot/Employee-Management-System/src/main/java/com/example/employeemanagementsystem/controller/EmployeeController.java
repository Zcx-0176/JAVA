package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String list(Model model){
        List<Employee> list = employeeRepository.findAll();
        model.addAttribute("employees",list);
        return "employee/list";
    }
    @GetMapping("/employees/add")
    public String add(Model model){
        model.addAttribute("employee",new Employee());
        return "employee/add";
    }
    @PostMapping("/employees")
    public String save(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee",employee);
        return "employee/edit";
    }
    @PostMapping("/employees/edit/{id}")
    public String update(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }
}
