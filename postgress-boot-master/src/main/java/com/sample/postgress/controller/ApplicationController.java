package com.sample.postgress.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sample.postgress.entity.Agreement_Detail;
import com.sample.postgress.entity.Employee;
import com.sample.postgress.entity.Message;
import com.sample.postgress.entity.Product;
import com.sample.postgress.service.EmployeeService;
import com.sample.postgress.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/postgressApp")
public class ApplicationController {
           
	@Resource 
	EmployeeService employeeService;
	@Resource
	ProductService productService;
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value = "/productList")
	public List<Product> findAll() {
		return productService.findAll();
	}
	@GetMapping (value="/productList/{id}")
	public Product getProduct(@PathVariable(name="id") int name)
	{
		return productService.getProduct(name);
	}
	@GetMapping(value="/productList/initiate")
	public List<Message> initiateAgreement(@RequestParam("id") int id,@RequestParam("email") String  email,
			@RequestParam("price")int price,@RequestParam("password")String password,HttpServletResponse response)
	{
		return productService.initiateAgreement(id,email,price,password);
	}
	@GetMapping(value="/productList/{id}/getAll")
	public List<Agreement_Detail> getAll(@PathVariable(name="id") int name )
	{
		return productService.getAll(name);
	}
	@GetMapping(value="/productList/{id}/accept")
	public Message accept(@PathVariable(name="id") int name ,@RequestParam("agreement") int agreement ,@RequestParam("email") String email,@RequestParam("password") String password)
	{
		return productService.accept(name,agreement,email,password);
	}
	@GetMapping(value="/productList/{id}/reject")
	public Message reject(@PathVariable(name="id") int name ,@RequestParam("agreement") int agreement ,@RequestParam("email") String email,@RequestParam("password") String password)
	{
		return productService.reject(name,agreement,email,password);
	}
	//@GetMapping(value = "/employeeList")
	//public List<Employee> getEmployees() {
		//return employeeService.findAll();
	//}
	/*@GetMapping (value = "/{idx}")
	public Employee getemployee( @PathVariable(name="idx") String name)
	{  
		return employeeService.getemployee(name);
	}
	@PostMapping(value = "/createEmp")
	public void createEmployee(@RequestBody Employee emp) {
		 employeeService.insertEmployee(emp);
	
	}
	@PutMapping(value = "/updateEmp")
	public void updateEmployee(@RequestBody Employee emp) {
		 employeeService.updateEmployee(emp);
	
	}
	@PutMapping(value = "/executeUpdateEmp")
	public void executeUpdateEmployee(@RequestBody Employee emp) {
		 employeeService.executeUpdateEmployee(emp);
	
	}
	
	@DeleteMapping(value = "/deleteEmpById")
	public void deleteEmployee(@RequestBody Employee emp) {
		 employeeService.deleteEmployee(emp);
	
	}*/
	
	
}
