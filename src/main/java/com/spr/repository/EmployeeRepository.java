package com.spr.repository;

import com.spr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

    @Query("SELECT e FROM Employee e where e.emplNumber = :empNum")
    Employee findByEmployeeNumber(@Param("empNum") Integer empNum);

}
