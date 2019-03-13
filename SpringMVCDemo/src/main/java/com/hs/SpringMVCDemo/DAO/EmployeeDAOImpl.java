package com.hs.SpringMVCDemo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hs.SpringMVCDemo.DTO.EmployeeDTO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static List<EmployeeDTO> employeeList=new ArrayList<EmployeeDTO>();
	
	@Override
	public boolean addNewEmployee(EmployeeDTO employeeDTO) {

        boolean flag=employeeList.add(employeeDTO);
        if(flag){
        	return true;
        }
		return false;
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeList;
	}

}
