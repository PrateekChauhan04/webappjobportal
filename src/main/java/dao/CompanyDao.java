package dao;

import java.util.List;

import model.Company;


public interface CompanyDao {

public void createCompany(Company c);
public void  updateCompany(Company c );
public void deleteCompany(Company c);
public void  getCompanybyId(Company c);
public void  viewCompany(Company c);
	
public List<Company> readAll();

}