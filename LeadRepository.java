package com.Zoho_Crm_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho_Crm_App.Entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
