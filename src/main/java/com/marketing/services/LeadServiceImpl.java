package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repository.LeadRepository;
@Service //After writing this annotation only its becomes spring class//orelse normal class
public class LeadServiceImpl implements LeadService {

	
	@Autowired
	private LeadRepository leadRepo;
	
	
	
	@Override//when put this annotation this class becomes Spring class
//	when i call this method suppled lead object to it
	
	public void saveLead(Lead lead) {
		
              leadRepo.save(lead);
		
	}



	@Override
	public List<Lead> listLeads() {
               //ctrl+1 AtoL and findall method will helps us to read the data 
             List<Lead> leads = leadRepo.findAll();
		
		return leads;
	}



	@Override
	public void deleteOneLeadById(long id) {
  
		
		leadRepo.deleteById(id);
		
	}



	@Override
	public Lead getOneLead(long id) {
		
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		
		return lead;
	}



     

}
