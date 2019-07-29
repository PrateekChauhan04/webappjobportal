package services;

import java.util.List;

import daoimpl.VacancyDaoImpl;
import model.Vacancy;

public class VacancyService{

	VacancyDaoImpl vacancydaoimpl;

	public VacancyDaoImpl getVacancydaoimpl() {
		return vacancydaoimpl;
	}

	public void setVacancydaoimpl(VacancyDaoImpl vacancydaoimpl) {
		this.vacancydaoimpl = vacancydaoimpl;
	}
	//DATA
	public void createVacancy(Vacancy vacancy) {
		vacancydaoimpl.createVacancy(vacancy);
	}

	public void updateVacancy(Vacancy vacancy) {
	vacancydaoimpl.updateVacancy(vacancy);
	}

	public void viewVacancy(Vacancy vacancy) {
		vacancydaoimpl.viewVacancy(vacancy);
		
	}

	public void deleteVacancy(Vacancy vacancy) {
	vacancydaoimpl.deleteVacancy(vacancy);
	}

	public List<Vacancy> readAll() {
              return vacancydaoimpl.readAll();
	}
	
	
	
	

	
}
