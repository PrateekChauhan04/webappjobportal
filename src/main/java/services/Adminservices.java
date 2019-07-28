package services;

import java.util.List;

import daoimpl.AdminDaoImpl;
import model.Admin;

public class Adminservices {
	
	private AdminDaoImpl admindaoimpl;
	
	
	public AdminDaoImpl getAdmindaoimpl() {
		return admindaoimpl;
	}
	public void setAdmindaoimpl(AdminDaoImpl admindaoimpl) {
		this.admindaoimpl = admindaoimpl;
	}
	public void createAdmin(Admin admin)
	{
		this.admindaoimpl.createAdmin(admin);
	}
	public void updateAdmin(Admin admin)
	{
		this.admindaoimpl.updateAdmin(admin);
	}
	public void deleteAdmin(Admin admin)
	{
		this.admindaoimpl.deleteAdmin(admin);
	}
	public List<Admin> viewAdmin()
	{
		return this.admindaoimpl.readall();
	}
}
