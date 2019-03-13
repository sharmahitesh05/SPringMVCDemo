package com.hs.SpringMVCDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.SpringMVCDemo.DAO.EmployeeDAO;
import com.hs.SpringMVCDemo.DTO.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public boolean addNewEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		return employeeDAO.addNewEmployee(employeeDTO);
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(id);
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployee();
	}

}
