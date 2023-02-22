package com.Zoho_Crm_App.Services;

import java.util.List;

import com.Zoho_Crm_App.Entities.Contact;

public interface ContactService {

	public void saveOneContact(Contact contact);

	public List<Contact> listAllContact();

	public Contact findLeadById(long id);

	public Contact getContactById(long id);

}
