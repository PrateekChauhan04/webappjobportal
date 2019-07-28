package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import model.Skills;
import services.SkillsServices;


@Controller
@RequestMapping(value="/skills")

public class Skillscontroller {
	List<Skills> skl = new ArrayList<Skills>(); 
	
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
	SkillsServices skillservice=(SkillsServices)context.getBean("skillsService");
	Skills skill=(Skills)context.getBean("skills");
	
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public String addSkill(@RequestBody String skill)
	{
		Gson g=new Gson();	
		Skills s=g.fromJson(skill, Skills.class);
		skillservice.addSkill(s);
		return "{'status':1,'message':'Added successfully'}";
		
	}
	
	
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	@ResponseBody
	public String updateSkill(@RequestBody String skill){
		Gson g=new Gson();	
		Skills s=g.fromJson(skill, Skills.class);
		skillservice.updateSkill(s);
		return "{'status':1,'message':'updated successfully'}";

	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteSkill(@PathVariable("id") int sid){
	
		skill.setSkillId(sid);
		skillservice.deleteSkill(skill);
		Gson g=new Gson();

		return "{'status':1,'message':'deleted successfully'}";
		
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseBody
	public String readAllSkills(){
		
		Gson g=new Gson();		
		skl	=skillservice.readAllSkills();
	
		String resp=g.toJson(skl);
		System.out.println(resp);
		return resp;
		
	}
	
	
	
	
}
