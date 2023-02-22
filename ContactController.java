package com.Zoho_Crm_App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Zoho_Crm_App.Entities.Contact;
import com.Zoho_Crm_App.Services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/AllContact")
	public String listAllContact(ModelMap model) {
		List<Contact> listAllContact = contactService.listAllContact();
		model.addAttribute("allContact", listAllContact);
		return "List_Contacts";

	}

	@RequestMapping("/contactDetail")
	public String detailById(@RequestParam("id") long id, ModelMap model) {
		Contact findLeadById = contactService.findLeadById(id);
		model.addAttribute("lead", findLeadById);
		return "Lead_Detail";
	}


}
