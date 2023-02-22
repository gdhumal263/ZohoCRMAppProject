package com.Zoho_Crm_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Zoho_Crm_App.Entities.Billing;
import com.Zoho_Crm_App.Entities.Contact;
import com.Zoho_Crm_App.Services.BillingService;
import com.Zoho_Crm_App.Services.ContactService;

@Controller
public class BillingController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private BillingService billingService;

	@RequestMapping("/generateBill")
	public String detailById(@RequestParam("id") long id, ModelMap model) {
		Contact findLeadById = contactService.getContactById(id);
		model.addAttribute("contact", findLeadById);
		return "generate_Bill";

	}

	@PostMapping("/saveBill")
	public String generateBill(Billing billing, ModelMap model) {
		billingService.saveBillDetail(billing);
		model.addAttribute("Msg", "bill Generted!!!");
		return "generate_Bill";
	}

}
