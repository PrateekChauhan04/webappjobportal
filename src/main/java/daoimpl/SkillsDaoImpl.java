package daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.SkillsDao;
import model.Skills;

public class SkillsDaoImpl implements SkillsDao {
	
	private HibernateTemplate hTemplate;
	public HibernateTemplate gethTemplate() {
		return hTemplate;
	}

	public void sethTemplate(HibernateTemplate hTemplate) {
		this.hTemplate = hTemplate;
	}

	public void addSkill(Skills skill) {
		this.hTemplate.save(skill);
	}

	public List<Skills> readAllSkills() {
		return this.hTemplate.find("from Skills");
	}

	public void updateSkill(Skills skill) {
		this.hTemplate.update(skill);
	}

	public void deleteSkill(Skills skill) {
		this.hTemplate.delete(skill);
	}

}
