package com.example.emsmybatis.mapper;

import com.example.emsmybatis.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    //查询全部
    List<Employee> findAll();
    //根据id查询
    Employee findById(Integer id);
    //添加
    int insert(Employee employee);
    //修改
    int update(Employee employee);
    //删除
    int delete(Integer id);
}
