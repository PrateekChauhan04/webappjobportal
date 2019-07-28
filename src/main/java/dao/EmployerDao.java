package dao;

import java.util.List;
import model.Employer;
public interface EmployerDao {

  public void addEmployer(Employer er);
  public void updateEmployer(Employer er);
  public void deleteEmployer(Employer er);
  public Employer getEmployerById(int EId);
  public List<Employer> readAllEmployer();
}
