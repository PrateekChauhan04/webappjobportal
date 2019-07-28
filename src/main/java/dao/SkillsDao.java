package dao;

import java.util.List;

import model.Skills;

public interface SkillsDao {
	
	public void addSkill(Skills s);
	
	public List<Skills> readAllSkills();
	
	public void updateSkill(Skills skill);
	
	public void deleteSkill(Skills skill);

}
