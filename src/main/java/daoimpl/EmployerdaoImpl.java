package daoimpl;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.EmployerDao;
import model.Employer;
public class EmployerdaoImpl implements EmployerDao{

	HibernateTemplate hTemplate;
	
	public HibernateTemplate gethTemplate() {
		return hTemplate;
	}

	public void sethTemplate(HibernateTemplate hTemplate) {
		this.hTemplate = hTemplate;
	}

	public void addEmployer(Employer er) {
		
		this.hTemplate.save(er);
	}

	public void updateEmployer(Employer er) {
		
		this.hTemplate.update(er);
	}

	public void deleteEmployer(Employer er) {
		
		this.hTemplate.delete(er);
	}

	public List<Employer> readAllEmployer() {
		
		return this.hTemplate.find("from Employer");
	}

	public Employer getEmployerById(int EId) {
		
		return this.hTemplate.get(Employer.class,EId);
		
	}
	

}
