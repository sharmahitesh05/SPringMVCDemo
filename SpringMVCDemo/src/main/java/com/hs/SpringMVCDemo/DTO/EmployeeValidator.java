package com.hs.SpringMVCDemo.DTO;

 
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator; 

@Component("employeeValidator")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First Name can not be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last Name can not be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "error.emailAddress", "Email Id can not be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "department", "error.department", "Department can not be blank");
	}

}
