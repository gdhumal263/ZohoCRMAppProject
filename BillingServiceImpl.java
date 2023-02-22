package com.Zoho_Crm_App.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zoho_Crm_App.Entities.Billing;
import com.Zoho_Crm_App.Repository.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepository billingRepo;

	@Override
	public void saveBillDetail(Billing billing) {
		billingRepo.save(billing);
	}

}
