package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Candidate;
import model.Vacancy;
import services.CandidateServices;
import services.VacancyService;

@Controller
@RequestMapping("/vacancy")
public class Vacancycontroller {

	List<Vacancy> al=new ArrayList<Vacancy>();
	
	                                                                                                   //create
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public String createVacancy(@RequestBody String vacancy)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");							
		VacancyService vService=context.getBean("vacancyservice",VacancyService.class);
		Gson g=new Gson();
		Vacancy vac=g.fromJson(vacancy,Vacancy.class);
		vService.createVacancy(vac);
		return "{'status':1,'message':'Added successfully'}";
		
	}
	                                                                                                 //update
	@RequestMapping(value="",method=RequestMethod.PUT)
	@ResponseBody
	public String updateVacancy(@RequestBody String vacancy)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		VacancyService vService=context.getBean("vacancyservice",VacancyService.class);
		Gson g=new Gson();
		Vacancy vac=g.fromJson(vacancy,Vacancy.class);
        vService.updateVacancy(vac);
        return "{'status':1,'message':'Updated successfully'}";
	}
	
	                                                                                          //Delete
	@RequestMapping(value="",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteVacancy(@RequestBody String vacancy)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		VacancyService vService=context.getBean("vacancyservice",VacancyService.class);
		Gson g=new Gson();
		Vacancy vac=g.fromJson(vacancy,Vacancy.class);
        vService.deleteVacancy(vac);
        return "{'status':1,'message':'DELETED SUCCESFULLY'}";
	}
	                                                                                           //View

	
	
	
}





