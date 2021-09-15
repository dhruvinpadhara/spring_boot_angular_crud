package com.db.conttroller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Employee;
import com.db.repo.EmployeeRepository;

@Controller
@RequestMapping("api/")
public class FileController {

	@RequestMapping("/")
	public String hello(){
		String fname="hello";
		System.out.println(fname);
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/bhai")
	public String hell(){
		return "hello bhai";
	}
	
//	@RequestMapping(method=RequestMethod.GET,value="/emp/{id}")
//	public String db(@PathVariable("id") int id){
//		return ""+id+"";
//	}
	
	@RequestMapping(method=RequestMethod.GET,value="employee")
	public String bdname(){
		Employee em=new Employee();
		em.setName("dhruvin");
		em.setEmail("db@1012.com");
		return ""+em.getEmail()+"";
	}
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping("/emp")
	@ResponseBody
	public List<Employee> emp(){
		System.out.println("read data");
		return emprepo.findAll();
	}
	
	
//	@PostMapping(value="/emp")
//	public Employee createEmployee(@RequestParam("id")int number,@RequestParam("name") String name,@RequestParam("email") String email) {
//		System.out.println("number:"+number+" name :"+name+" email:"+email);
//		Employee emp=new Employee(name,email);
//		return emprepo.save(emp);
//	}
	
	@PostMapping(value="/emp")
	@ResponseBody
	public Employee createEmployee(@RequestBody Employee emp) {
		System.out.println("name:"+emp.getName()+" email :"+emp.getEmail()+" id:"+emp.getId());
		System.out.println("id "+emp.getId()+"name:"+emp.getName()+" email"+emp.getEmail());
		//Employee emp=new Employee(name,email);
		return emprepo.save(emp);
	}

	@GetMapping("/emp/{id}")
	@ResponseBody
	public Optional<Employee> getemp(@PathVariable("id") int id){
		//System.out.println("get emp"+id);
		return emprepo.findById(id);
	}
	
	@GetMapping("/emp/name/{name}")
	public List<Employee> getempname(@PathVariable("name") String name){
		return emprepo.findByName(name);
	}
	
	@DeleteMapping("/emp/{id}")
	public String delemp(@PathVariable("id") int id){
		System.out.println("delete data"+id);
		Employee emp=new Employee(id);
		emprepo.delete(emp);
		return "success";
	}
		
}
