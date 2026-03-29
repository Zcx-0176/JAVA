package com.example.emsmybatis.repository;
import com.example.emsmybatis.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 操作员工表
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
