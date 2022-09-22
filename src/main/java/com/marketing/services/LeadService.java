package com.marketing.services;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {

	public void saveLead(Lead lead);
	// this method helps to return list of lead Object
    //  if there is one record it will return one object and if they 2 it will return Two
	public List<Lead> listLeads();
	public void deleteOneLeadById(long id);
	public Lead getOneLead(long id);


	
	


}
