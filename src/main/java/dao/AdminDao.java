package dao;

import java.util.List;

import model.Admin;

public interface AdminDao {
	
	public void createAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
	
	public List<Admin> readall();

}