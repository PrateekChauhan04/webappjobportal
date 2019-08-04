package services;

import java.util.List;


import daoimpl.CandidateDaoImpl;

import model.Candidate;

public class CandidateService {
private CandidateDaoImpl candidatedaoimpl;
	
	public CandidateDaoImpl getCandidatedaoimpl() {
	return candidatedaoimpl;
}
public void setCandidatedaoimpl(CandidateDaoImpl candidatedaoimpl) {
	this.candidatedaoimpl = candidatedaoimpl;
}
	public void createCandidate(Candidate candidate)
	{
		this.candidatedaoimpl.createCandidate(candidate);
	}
	public void updateAdmin(Candidate candidate)
	{ 
		this.candidatedaoimpl.updateCandidate(candidate);
		
	}
	public void deleteCandidate(Candidate candidate)
	{
		this.candidatedaoimpl.updateCandidate(candidate);
		
	}
	public List<Candidate> candidates()
	{
		return this.candidatedaoimpl.getAllCandidate();
	}
}
