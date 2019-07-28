package services;

import java.util.List;

import daoimpl.*;
import model.*;

public class Companyservices {
	
	private CompanyDaoImpl companydaoimpl;

	public CompanyDaoImpl getcomimpl() {
		return companydaoimpl;
	}

	public void setcdimpl(CompanyDaoImpl companydaoimpl) {
		this.companydaoimpl = companydaoimpl;
	}

	public    void createCompany(Company company) {
		
      this.companydaoimpl.createCompany(company);
		
	}
	
	public void updateCompany(Company company) {
		
		   this.companydaoimpl.updateCompany(company);
			
		}
		
	public void deleteCompany(Company company) {
		
		   this.companydaoimpl.deleteCompany(company);
			
		}
		
	public List<Company> viewCompany(){
		
		
		return this.companydaoimpl.readAll();
		   
			
		}
		
	
     }