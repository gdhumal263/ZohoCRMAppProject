package com.Zoho_Crm_App.Services;

import java.util.List;

import com.Zoho_Crm_App.Entities.Lead;

public interface LeadService {

	public void saveOneLead(Lead lead);

	public Lead findLeadById(long id);

	public void deleteLeadById(long id);

	public List<Lead> listAllLeads();

}
