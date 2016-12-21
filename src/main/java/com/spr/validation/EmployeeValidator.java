package com.spr.validation;

import com.spr.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    private final static String EMPLOYEES_NUMBER = "emplNumber";

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

        Integer emplNumber = employee.getEmplNumber();

        ValidationUtils.rejectIfEmpty(errors, "name", "shop.name.empty");
        ValidationUtils.rejectIfEmpty(errors, EMPLOYEES_NUMBER, "shop.emplNumber.empty");

        if (emplNumber != null && emplNumber < 1)
            errors.rejectValue(EMPLOYEES_NUMBER, "shop.emplNumber.lessThenOne");

    }

}
