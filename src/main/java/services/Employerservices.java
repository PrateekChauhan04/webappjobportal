package services;

import java.util.List;

import daoimpl.EmployerdaoImpl;
import model.Employer;

public class Employerservices {

	EmployerdaoImpl employerdaoimpl;

	public EmployerdaoImpl getEmployerdaoimpl() {
		return employerdaoimpl;
	}

	public void setEmployerdaoimpl(EmployerdaoImpl employerdaoimpl) {
		this.employerdaoimpl = employerdaoimpl;
	}

	public void addEmployer(Employer er)
	{
		employerdaoimpl.addEmployer(er);
	}
	public void deleteEmployer(Employer er)
	{
		employerdaoimpl.deleteEmployer(er);
	}
	public void updateEmployer(Employer er)
	{
		employerdaoimpl.updateEmployer(er);
	}
	public List<Employer> readAllEmployer()
	{
		return employerdaoimpl.readAllEmployer();
	}
	public Employer getEmployerById(int EId)
	{
		return employerdaoimpl.getEmployerById(EId);
	}
}
