package daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.AdminDao;
import model.Admin;

public class AdminDaoImpl implements AdminDao {
	
public HibernateTemplate hTemplate;
	
	public HibernateTemplate gethTemplate() {

		return hTemplate;
	}

	public void sethTemplate(HibernateTemplate hTemplate) {
		this.hTemplate = hTemplate;
	
	}


	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.hTemplate.save(admin);
	}

	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.hTemplate.update(admin);
}

	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.hTemplate.delete(admin);
	}

	public List<Admin> readall() {
		// TODO Auto-generated method stub
		return this.hTemplate.find("from Admin");
	}
	
	

}

