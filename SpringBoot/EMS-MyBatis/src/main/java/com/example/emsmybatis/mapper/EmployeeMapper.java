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

    //动态条件查询
    List<Employee> findByCondition(Employee employee);
    //动态更新
    int updateDynamic(Employee employee);
    //批量删除
    int deleteBatch(List<Integer> ids);
    //批量插入
    int insertBatch(List<Employee> employees);
    //choose查询
    List<Employee> findByChoose(Employee employee);
    //多表查询
    List<Employee> findEmployeeWithDept(Integer dept_id);
}
