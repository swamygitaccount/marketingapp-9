package com.marketing.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@RestController
@RequestMapping("/api/leads")
public class RestLeadController {
	
	@Autowired
	private LeadService leadservice;
	
	@GetMapping
	public List <Lead> getALlLeads(){
		
		List<Lead> leads = leadservice.listLeads();
		
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
	
		leadservice.saveLead(lead);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteOneLead(@PathVariable ("id") long id) {
		
		leadservice.deleteOneLeadById(id);
	}
	
	@PutMapping// it is for updating the record.
	public void updateOneLead(@RequestBody Lead lead) {
	
		leadservice.saveLead(lead);
	}	

	@GetMapping("/leadinfo/{id}")// when we want get exactly one details based on the id
	public Lead getOneLead(@PathVariable("id") long id) {
		Lead lead = leadservice.getOneLead(id);
		return lead;  
	}// once we enter this ulr http://localhost:8080/api/leads/leadinfo/6 get exacly one json object and that
}// http://localhost:8080/api/leads/leadinfo/6 this is url, the team will give you, web serverce url or APi or 
// web services end point, once they give you this url we have to take the data from the url, put it in the application.
//firstly analyse the data and based on that create one java class.
// here in the json object whatever data is there , have to copy that data to java object 
//{"id":6,"firstName":"lion1","lastName":"ln","email":"lion.king1@gmail.com","mobile":7259585327}this json object
//to copy the data from json object, it is possible only when the java object has exactly same variable as that of json
//object. which means json object and java object variable should match. 
