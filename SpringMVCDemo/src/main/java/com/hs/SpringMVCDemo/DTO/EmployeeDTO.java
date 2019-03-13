package com.hs.SpringMVCDemo.DTO;

import java.io.Serializable; 
import java.util.List;

import javax.validation.constraints.NotNull; 

import org.springframework.web.multipart.MultipartFile;
 
public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6163123298784490896L;
	
	 
	private String employeeId;
	
	 
	private String firstName;
	
	 
	private String lastName;
	
	 
	private String emailAddress;
	
	 
	private String department;
	
	private List<MultipartFile> images;
	 
	 
	public List<MultipartFile> getImages() {
		return images;
	}
	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + "]";
	}  
	
}
