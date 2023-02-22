package com.Zoho_Crm_App.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zoho_Crm_App.Entities.Contact;
import com.Zoho_Crm_App.Repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void saveOneContact(Contact contact) {
		contactRepo.save(contact);
	}

	@Override
	public List<Contact> listAllContact() {
		List<Contact> findAll = contactRepo.findAll();
		return findAll;
	}

	@Override
	public Contact findLeadById(long id) {
		Optional<Contact> findById = contactRepo.findById(id);
		Contact contact = findById.get();
		return contact;
	}

	@Override
	public Contact getContactById(long id) {
		Optional<Contact> findById = contactRepo.findById(id);
		Contact contact = findById.get();
		return contact;
	}
}
