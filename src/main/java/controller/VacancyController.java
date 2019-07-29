package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Vacancy;
import services.VacancyService;

@Controller
@RequestMapping("/vacancy")
public class VacancyController {

	List<Vacancy> al=new ArrayList<Vacancy>();
	
	                                                                                                   //create
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public String createVacancy(@RequestBody String vacancy)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		Vacancyservices vservice=context.getBean("vacancyservice",Vacancyservices.class);
		Gson g=new Gson();
		Vacancy vac=g.fromJson(vacancy,Vacancy.class);
		vservice.createVacancy(vacancy);
		return "{'status':1,'message':'Added successfully'}";
		
	}
	                                                                                                 //update
	@RequestMapping(value="",method=RequestMethod.PUT)
	@ResponseBody
	public String updateVacancy(@RequestBody String vacancy)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		Vacancyservices vservice=context.getBean("vacancyservice",Vacancyservices.class);
		Gson g=new Gson();
		Vacancy vac=g.fromJson(vacancy,Vacancy.class);
        vservice.updateVacancy(vacancy);
        return "{'status':1,'message':'Updated successfully'}";
	}
	
	                                                                                          //Delete
	@RequestMapping(value="",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteVacancy(@RequestBody String vacancy)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		Vacancyservices vservice=context.getBean("vacancyservice",Vacancyservices.class);
		Gson g=new Gson();
		Vacancy vac=g.fromJson(vacancy,Vacancy.class);
        vservice.deleteVacancy(vacancy);
        return "{'status':1,'message':'DELETED SUCCESFULLY'}";
	}
	
	
	//View is unavailable & read all is also unavaialble
	
	                                                                         
	
	
}





