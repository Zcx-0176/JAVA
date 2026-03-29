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
}
