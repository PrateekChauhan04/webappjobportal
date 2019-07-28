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

import model.Admin;
import services.Adminservices;


@Controller
@RequestMapping("/admin")
public class Admincontroller {
	
	ArrayList<Admin> al=new ArrayList<Admin>();
	ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
	Adminservices admins=null;
	Admin adm=null;
	@RequestMapping(value = "",method = RequestMethod.POST)
	@ResponseBody
	public String createAdmin(@RequestBody String admin) {
		
		admins=context.getBean("adminservice", Adminservices.class);
		adm=context.getBean("admin",Admin.class);
		Gson g=new Gson();
		Admin a=g.fromJson(admin, Admin.class);
		admins.createAdmin(a);
		return "{'status':1,'message':'Added successfully'}";
	}
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	@ResponseBody
	public String viewAdmin()
	{
		admins=context.getBean("adminservice", Adminservices.class);
		adm=context.getBean("admin",Admin.class);
		Gson g=new Gson();
		String resp=g.toJson(admins.viewAdmin());
		System.out.println("rsp"+ resp);
		return resp;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteById(@PathVariable("id") int adminId)
	{
		
		admins=context.getBean("adminservice", Adminservices.class);
		adm=context.getBean("admin",Admin.class);
		adm.setAdminId(adminId);
		admins.deleteAdmin(adm);
		return "{'status':2,'message ':'deleted succesfully'}";
		
	}
	
	@RequestMapping(value = "",method = RequestMethod.PUT)
	@ResponseBody
	public String updateAdmin(@RequestBody String admin) {
		
		admins=context.getBean("adminservice", Adminservices.class);
		adm=context.getBean("admin",Admin.class);
		Gson g=new Gson();
		Admin a=g.fromJson(admin, Admin.class);
		admins.updateAdmin(a);
		return "{'status':3,'message':'update successfully'}";
	}

}
