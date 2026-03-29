package com.example.emsmybatis.controller;

import com.example.emsmybatis.entity.Employee;
import com.example.emsmybatis.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Employee> emps = employeeService.findAll();
        model.addAttribute("emps", emps);
        return "list";
    }

    @GetMapping("/addPage")
    public String addPage(){
        return "add";
    }

    @PostMapping("/add")
    public String add(Employee employee){
        employeeService.add(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        Employee emp = employeeService.findById(id);
        model.addAttribute("emp", emp);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        employeeService.delete(id);
        return "redirect:/employee/list";
    }
}
