package services;

import java.util.Iterator;
import java.util.List;

import daoimpl.CandidateDaoImpl;
import model.Candidate;
import model.Education;
import model.Experience;
import model.Skills;

public class CandidateServices {

	CandidateDaoImpl candidatedaoimpl;

	public CandidateDaoImpl getCandidatedaoimpl() {
		return candidatedaoimpl;
	}

	public void setCandidatedaoimpl(CandidateDaoImpl candidatedaoimpl) {
		this.candidatedaoimpl = candidatedaoimpl;
	}
	
	public void addNewCandidate(Candidate candidate)
	{
		this.candidatedaoimpl.createCandidate(candidate);
		
	}

//	public void addMultipleEducation(Candidate candidate,List<Education>education)
//	{
//
//	candidate.setEdu(education);
//		candidatedaoimpl.updateCandidate(candidate);
//	}
	
	public void updateCandidate(Candidate candidate) {
		candidatedaoimpl.updateCandidate(candidate);
	}
	public void deleteCandidate(Candidate candidate) {
		candidatedaoimpl.deleteCandidate(candidate);
	}
	public Candidate getCandidate(String mobileNo) {
		return candidatedaoimpl.getCandidateById(mobileNo);
	}
	public List<Candidate> getAllCandidate() {
		return candidatedaoimpl.getAllCandidate();
	}
}
