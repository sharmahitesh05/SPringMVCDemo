package com.hs.SpringMVCDemo.Service;

import java.util.List;

import com.hs.SpringMVCDemo.DTO.EmployeeDTO;

public interface EmployeeService {

	boolean addNewEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO getEmployee(int id);
	List<EmployeeDTO> getAllEmployee();
}
