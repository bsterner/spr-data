package com.spr.service;

import com.spr.exception.EmployeeNotFound;
import com.spr.model.Employee;
import com.spr.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee create(Employee employee) {
        Employee createdEmployee = employee;
        return employeeRepository.save(createdEmployee);
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = EmployeeNotFound.class)
    public Employee delete(int id) throws EmployeeNotFound {
        Employee deletedEmployee = employeeRepository.findOne(id);

        if (deletedEmployee == null)
            throw new EmployeeNotFound();

        employeeRepository.delete(deletedEmployee);
        return deletedEmployee;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = EmployeeNotFound.class)
    public Employee update(Employee employee) throws EmployeeNotFound {
        Employee updatedEmployee = employeeRepository.findOne(employee.getId());

        if (updatedEmployee == null)
            throw new EmployeeNotFound();

        updatedEmployee.setName(employee.getName());
        updatedEmployee.setEmplNumber(employee.getEmplNumber());
        return updatedEmployee;
    }

}
