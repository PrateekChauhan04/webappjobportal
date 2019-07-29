
package services;

import java.util.List;

import daoimpl.SkillsDaoImpl;
import model.Skills;

public class SkillsService {

	public SkillsDaoImpl skillsdaoimpl;

	public SkillsDaoImpl getSkillsdaoimpl() {
		return skillsdaoimpl;
	}

	public void setSkillsdaoimpl(SkillsDaoImpl skillsdaoimpl) {
		this.skillsdaoimpl = skillsdaoimpl;
	}
	
	public void addSkill(Skills skill) {
		this.skillsdaoimpl.addSkill(skill);
	}
	
	public void updateSkill(Skills skill) {
		this.skillsdaoimpl.updateSkill(skill);
	}

	public void deleteSkill(Skills skill) {
		this.skillsdaoimpl.deleteSkill(skill);
	}
	
	public List<Skills> readAllSkills() {
		return this.skillsdaoimpl.readAllSkills();
	}

	
	
}
