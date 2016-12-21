/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spring.test;

import com.spr.init.AppConfig;
import com.spr.model.Employee;
import com.spr.repository.EmployeeRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
@ContextConfiguration(classes = AppConfig.class)
@Rollback
@Log
public class EmployeeServiceTest {

    @Autowired
    private EntityManager entityManager;

    // ==========================================================================
    // =========================== ENTITY MANAGER ===============================
    // ==========================================================================

    @Test
    public void entityManagerTestSave() {
        Employee employee = createEmployee();
        entityManager.persist(employee);
    }

    @Test
    public void entityManagerTestFind() {
        Employee employee = entityManager.find(Employee.class, 10);
        System.out.println(employee);
    }


    // =============================================================================
    // ============================= REPOSITORY ==================================
    // =============================================================================

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void repositoryTestSave() {
        Employee employee = createEmployee();
        employeeRepository.save(employee);
    }

    @Test
    public void repositoryTestFind() {
        String employeeName = "Sterner";
        Employee employee = employeeRepository.findByName(employeeName);
        System.out.println(employee);
    }

    @Test
    public void repositoryTestFindByEmployeeNumber() {
        Long empNum = 1238898709L;
        String employee = employeeRepository.findByEmployeeNumber(empNum);
        System.out.println(employee);
    }

    @Test
    public void update() {

//        Employee foundEmployee = emploees.get(0);
//        foundEmployee.setName("Joe Schmoe");
//        employeeRepository.save(foundEmployee);


        //assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
    }

    private Employee createEmployee() {
        String name = "Brian Sterner";
        Integer emplNumber = 1238898709;
        Employee employee = new Employee(name, emplNumber);
        return employee;
    }

}