package controller;

public class Companycontroller {
	package controller;
	import java.util.*;

	import org.springframework.context.support.ClassPathXmlApplicationContext;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;

	import model.Company;

	import services.Companyservices;

	import com.google.gson.Gson;

	@Controller
	@RequestMapping("/company")
	public class Companycontroller {
		
		ArrayList<Company> al=new ArrayList<Company>();

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		Companyservices companyservice=(Companyservices)context.getBean("companyService");
		Company company=(Company)context.getBean("company");
		

		@RequestMapping(value="",method=RequestMethod.POST)
		@ResponseBody
		public String createCompany(@RequestBody String company)
		{

			Gson g=new Gson();	
			Company c=g.fromJson(company, Company.class);
			companyservice.createCompany(c);
			return "Company added ";
			
			
		}

		
		
		@RequestMapping(value="/",method=RequestMethod.POST)
		@ResponseBody
		public String updateCompany(@RequestBody String company)
		{
			Gson g=new Gson();	
			Company c=g.fromJson(company, Company.class);
		    companyservice.updateCompany(c);
			return "company updated";

		}

		


		
		
		@RequestMapping(value="/",method=RequestMethod.GET)
		@ResponseBody
		    public  String  viewCompany()
		    {
		
			
			Gson g=new Gson();		
			List<Company> c=companyservice.viewCompany();
		
			String response=g.toJson(c);
			System.out.println(response);
			return response;
			
		}

		
		
		@RequestMapping(value="/",method=RequestMethod.DELETE)
		@ResponseBody
		public String deleteCompany(@PathVariable("id") int cid ,@RequestBody String  company  )
		{   
			Gson g=new Gson();
			this.company.setregistrationNo(cid);
			Company c=g.fromJson(company, Company.class);
		    companyservice.deleteCompany(c);
			return "company deleted";
			
			
			
		}
		

	}
}
