package com.example.emsmybatis.service;

import com.example.emsmybatis.entity.Employee;
import com.example.emsmybatis.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    //注入Mapper
    public EmployeeService(EmployeeMapper employeeMapper){
        this.employeeMapper = employeeMapper;
    }
    public List<Employee> findAll(){
        return employeeMapper.findAll();
    }
    public Employee findById(Integer id){
        return employeeMapper.findById(id);
    }
    public void add(Employee employee){
        employeeMapper.insert(employee);
    }
    public void update(Employee employee){
        employeeMapper.update(employee);
    }
    public void delete(Integer id){
        employeeMapper.delete(id);
    }
    /**
     * 动态条件查询
     */
    public List<Employee> search(String name, Integer age) {
        Employee condition = new Employee();
        condition.setName(name);
        condition.setAge(age);
        return employeeMapper.findByCondition(condition);
    }

    /**
     * 动态更新：只更新年龄
     */
    public void updateAgeOnly(Integer id, Integer age) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setAge(age);
        employeeMapper.updateDynamic(employee);
    }

    /**
     * 批量新增：自动构造3条测试数据
     */
    public void addBatchTestData() {
        Employee e1 = new Employee(null, "批量一号", "piliang1@test.com", 20, 1, null);
        Employee e2 = new Employee(null, "批量二号", "piliang2@test.com", 21, 2, null);
        Employee e3 = new Employee(null, "批量三号", "piliang3@test.com",22, 3, null);
        employeeMapper.insertBatch(List.of(e1, e2, e3));
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        employeeMapper.deleteBatch(ids);
    }

    // 联表查询：根据 dept_id 查询该部门下所有员工 + 部门信息
    public List<Employee> getEmployeesByDeptId(Integer dept_id) {
        return employeeMapper.findEmployeeWithDept(dept_id);
    }

    // CHOOSE 查询
    public List<Employee> chooseQuery(Employee condition) {
        return employeeMapper.findByChoose(condition);
    }


}
