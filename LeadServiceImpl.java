package com.Zoho_Crm_App.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zoho_Crm_App.Entities.Lead;
import com.Zoho_Crm_App.Repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public List<Lead> listAllLeads() {
		List<Lead> findAll = leadRepo.findAll();
		return findAll;
	}


}
