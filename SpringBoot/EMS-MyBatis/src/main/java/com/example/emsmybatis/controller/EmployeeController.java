package com.example.emsmybatis.controller;

import com.example.emsmybatis.entity.Employee;
import com.example.emsmybatis.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    @GetMapping("/updatePage/{id}")
    public String updatePage(@PathVariable Integer id, Model model){
        Employee emp = employeeService.findById(id);
        model.addAttribute("emp", emp);
        return "update"; // 跳转到修改页面
    }

    // ==================== 修改提交 ====================
    @PostMapping("/update")
    public String update(Employee employee){
        employeeService.update(employee);
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
    // 动态查询
    @GetMapping("/search")
    public String search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            Model model
    ) {
        model.addAttribute("emps", employeeService.search(name, age));
        return "list";
    }

    // 动态更新年龄
    @GetMapping("/dynamicUpdate/{id}")
    public String dynamicUpdate(@PathVariable Integer id, Integer age) {
        employeeService.updateAgeOnly(id, age);
        return "redirect:/employee/list";
    }

    // 批量新增
    @GetMapping("/batchAdd")
    public String batchAdd() {
        employeeService.addBatchTestData();
        return "redirect:/employee/list";
    }

    // 批量删除
    @GetMapping("/deleteBatch")
    public String deleteBatch() {
        employeeService.deleteBatch(Arrays.asList(1,2,3));
        return "redirect:/employee/list";
    }

    @GetMapping("/choose")
    public String choose(String name, Integer age, Model model) {
        Employee condition = new Employee();
        condition.setName(name);
        condition.setAge(age);
        List<Employee> list = employeeService.chooseQuery(condition);
        model.addAttribute("emps", list);
        return "list";
    }

    // 联表查询接口：根据 dept_id 查询部门下所有员工
    @GetMapping("/dept/{dept_id}")
    public String getEmployeesByDept(@PathVariable Integer dept_id, Model model) {
        List<Employee> emps = employeeService.getEmployeesByDeptId(dept_id);
        model.addAttribute("emps", emps);
        return "list"; // 复用 list.html 展示结果
    }


}
