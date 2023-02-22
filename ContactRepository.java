package com.Zoho_Crm_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho_Crm_App.Entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
