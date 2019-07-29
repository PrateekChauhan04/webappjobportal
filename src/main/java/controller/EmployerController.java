package controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.Employer;
import services.EmployerService;

@Controller
@RequestMapping("/employer")
public class EmployerController {
	
	List<Employer> al=new ArrayList<Employer>();
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public String addEmployer(@RequestBody String employer) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		EmployerService eservice=context.getBean("employerservice",EmployerService.class);
		Gson g=new Gson();	
		Employer emp=g.fromJson(employer,Employer.class);
		eservice.addEmployer(emp);
		return "{'status':1,'message':'Added successfully'}";
		

		
	}
	
	@RequestMapping(value="",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmployer(@RequestBody String employer) {
	    ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		EmployerService eservice=context.getBean("employerservice",EmployerService.class);
		Gson g=new Gson();
		Employer emp=g.fromJson(employer,Employer.class);
		eservice.deleteEmployer(emp);
		return "{'status':1,'message':'Deleted successfully'}";
		
	}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	@ResponseBody
	public String updateEmployer(@RequestBody String employer)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		EmployerService eservice=context.getBean("employerservice",EmployerService.class);
		Gson g=new Gson();
		Employer emp=g.fromJson(employer,Employer.class);
		eservice.updateEmployer(emp);
		return "{'status':1,'message':'Updated successfully'}";
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseBody
	public String readAllEmployer()
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		EmployerService eservice=context.getBean("employerservice",EmployerService.class);
		Gson g=new Gson();
	    al=eservice.readAllEmployer();
		String emp=g.toJson(al);
		return emp;
	}
	
	@RequestMapping(value="/{EId}",method=RequestMethod.GET)
	@ResponseBody
	public String getById(@PathVariable("EId") int employerid)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		EmployerService eservice=context.getBean("employerservice",EmployerService.class);
		Gson g=new Gson();
		Employer empbyid=eservice.getEmployerById(employerid);
		return g.toJson(empbyid,Employer.class);
		
	}

}
