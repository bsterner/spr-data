package com.spr.repository;

import com.spr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);

    @Query("SELECT nickname FROM Employee where employees_number = :empNum")
    String findByEmployeeNumber(@Param("empNum") Long empNum);

}
