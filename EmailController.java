package com.Zoho_Crm_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Zoho_Crm_App.dto.Email;
import com.Zoho_Crm_App.util.EmailService;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendMail")
	public String getEmailId(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("email", email);
		return "Compose_Email";
	}

	@PostMapping("/TriggerMail")
	public String triggerMail(Email email, ModelMap model) {
		emailService.sendSimpleMail(email.getEmail(), email.getSubject(), email.getContent());
		model.addAttribute("Msg", "Email Send Successfully!!!");
		return "Compose_Email";

	}

}
