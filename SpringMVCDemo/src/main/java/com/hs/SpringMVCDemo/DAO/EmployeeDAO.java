package com.hs.SpringMVCDemo.DAO;

import java.util.List;

import com.hs.SpringMVCDemo.DTO.EmployeeDTO;

public interface EmployeeDAO {

	boolean addNewEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO getEmployee(int id);
	List<EmployeeDTO> getAllEmployee();
}
