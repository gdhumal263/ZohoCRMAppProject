package com.Zoho_Crm_App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Zoho_Crm_App.Entities.Contact;
import com.Zoho_Crm_App.Entities.Lead;
import com.Zoho_Crm_App.Services.ContactService;
import com.Zoho_Crm_App.Services.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

	@Autowired
	private ContactService contactService;

	@GetMapping("/viewCreateLeadPage")
	public String viewCreateOneLead() {
		return "create_New_Lead";
	}

	@PostMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead", lead);
		return "Lead_Detail";
	}

	@PostMapping("/ConvertLead")
	public String detailById(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.findLeadById(id);
		
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveOneContact(contact);
		leadService.deleteLeadById(id);
		List<Contact> listAllContact = contactService.listAllContact();
		model.addAttribute("allContact", listAllContact);
		return "List_Contacts";
	}

	@RequestMapping("/listAll")
	public String listAllLeads(ModelMap model) {
		List<Lead> listAllLeads = leadService.listAllLeads();
		model.addAttribute("allLeads", listAllLeads);
		return "List_Leads";
	}
	
	@RequestMapping("/leadDetail")
	public String leadDetail(@RequestParam("id") long id, ModelMap model) {
		Lead findLeadById = leadService.findLeadById(id);
		model.addAttribute("lead", findLeadById);
		return "Lead_Detail";
	}
	
}
