package com.hs.SpringMVCDemo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hs.SpringMVCDemo.DTO.EmployeeDTO;
import com.hs.SpringMVCDemo.DTO.EmployeeValidator;
import com.hs.SpringMVCDemo.Service.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	@Qualifier("employeeValidator")
	EmployeeValidator employeeValidator;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	} 
	
	@RequestMapping(method = RequestMethod.GET)
	public String addEmployeeViewPage(HttpServletResponse response,Model model) throws IOException{
		
		 EmployeeDTO employeeVO = new EmployeeDTO();
         model.addAttribute("employee", employeeVO);
		 return "addEmployee";
	}
	
	
	@RequestMapping("/addNewEmployee")
	public String addNewEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employeeDTO
			,BindingResult result,Model model,HttpServletRequest servletRequest) throws IOException{
		
		   
		 System.out.println(employeeDTO);
		 employeeValidator.validate(employeeDTO, result);
		 if (result.hasErrors()) {
	            return "addEmployee";
	     } 
		 
	    List<MultipartFile> files = employeeDTO.getImages();
        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0)
        {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
 
                File imageFile = new File(servletRequest.getRealPath("WEB-INF/image"), fileName);
                System.out.println("Iamge Path : "+imageFile);
                try
                {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        } 
         
		 boolean addFlag=employeeService.addNewEmployee(employeeDTO);
		 if(addFlag){
			 model.addAttribute("sucessMsg", "Employee Added successfully !....");
			 return "addEmployee";
		 }else
		 {
			 model.addAttribute("sucessMsg", "Employee Not Added !...");
			 return "addEmployee";
		 }
		 
	}
	
	@RequestMapping(value = "/getAllEmployees",method = RequestMethod.GET)
	public String viewAllEmployee(Model model) throws IOException{
		
		 List<EmployeeDTO> employeeList = employeeService.getAllEmployee();
         model.addAttribute("allEmployees", employeeList);
		 return "viewAllEmployees";
	}
	
	@ModelAttribute("allDepartments")
	public List<String> populateDepartments()
	{
	    ArrayList<String> departments = new ArrayList<String>();
	    departments.add("Select Department");
	    departments.add("Human Resource");
	    departments.add("Finance");
	    departments.add("Information Technology");
	    return departments;
	}
}
