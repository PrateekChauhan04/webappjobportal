package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.FetchType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Candidate;
import model.Education;
import model.Experience;
import services.CandidateServices;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

	
	@RequestMapping(value = "/{value}",method = RequestMethod.GET)
	@ResponseBody
	String getCandidateById(@PathVariable String value,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("String : "+value);

		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");		
			CandidateServices s=context.getBean("candidateservice",CandidateServices.class);
			Candidate candidate=s.getCandidate(value);
			System.out.println(candidate.getMobileNumber()+candidate.getAge());

			Gson g= new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
				
			String sil=g.toJson(candidate);

		return sil;
	
	}	
	Candidate candidate;
	
	@RequestMapping( value = "",method = RequestMethod.POST)
	@ResponseBody
	public String addCandidate(@RequestBody String value,HttpServletRequest request,HttpServletResponse response)
	{
		Candidate candidate;
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		Gson g=new Gson();
		candidate =g.fromJson(value, Candidate.class);
		System.out.println(candidate.getMobileNumber());
	CandidateServices s=context.getBean("candidateservice",CandidateServices.class);
		

		s.addNewCandidate(candidate);

		 return "'success':'true'";
	}
	

	
	@RequestMapping(value = "",method = RequestMethod.PUT)
	@ResponseBody
	String updateCandidate(@RequestBody String value,HttpServletRequest request,HttpServletResponse response)
	{
		Gson  g=new Gson();
		Candidate candidate=g.fromJson(value, Candidate.class);
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		CandidateServices s=context.getBean("candidateservice",CandidateServices.class);
		s.updateCandidate(candidate);
		return "'success':'true'";
	}
	
	@RequestMapping(value = "/{value}",method = RequestMethod.DELETE)
	@ResponseBody
	String deleteCandidate(@PathVariable String value,HttpServletRequest request,HttpServletResponse response)
	{
		Candidate candidate;
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		CandidateServices s=context.getBean("candidateservice",CandidateServices.class);
		candidate=s.getCandidate(value);
	
		s.deleteCandidate(candidate);
		return "'success':'true'";
	}
	@RequestMapping(value = "/all",method = RequestMethod.POST)
	@ResponseBody
	String getAllCandidate(HttpServletRequest request,HttpServletResponse response)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		CandidateServices s=context.getBean("candidateservice",CandidateServices.class);
		Gson g=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	
		return g.toJson(s.getAllCandidate());
	}
	

	
}
//void createCandidate(HttpServletRequest request,HttpServletResponse response)
//{
//	ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
//	candidate=new Candidate();
//	candidate.setName(request.getParameter("username"));
//	candidate.setAge(Integer.parseInt(request.getParameter("age"))); 
//	candidate.setCountry(request.getParameter("country"));
//	candidate.setEmail(request.getParameter("email"));
//	candidate.setPinCode(Integer.parseInt(request.getParameter("pincode"))); 
//	candidate.setGender(request.getParameter("gender"));
//	candidate.setState((request.getParameter("state")));
//	candidate.setPassword(request.getParameter("password"));
//	candidate.setMobileNumber(request.getParameter("mob"));
//	s=context.getBean("candidateservice",CandidateServices.class);
//	System.out.println(s.getCandidate("9").getMobileNumber());
//	s.addNewCandidate(candidate);
//}

//@RequestMapping(value = "/Education",method = RequestMethod.GET)
//@ResponseBody
//public void addEducation(@PathVariable String val,HttpServletRequest request,HttpServletResponse response)
//{
//	Candidate candidate;
//	List Exp;
//Gson g=new Gson();
//
//Exp=g.fromJson(val, List.class);
//
//	
//	ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
//	
//	
//	CandidateServices candidateservices=context.getBean("candidateservice",CandidateServices.class);
//	
//	candidateservices.addMultipleEducation(candidate, Exp);
//	
//	
//}