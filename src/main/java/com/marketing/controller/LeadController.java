package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@Controller
public class LeadController {
	
	//to call service layer create ref variable interface
	@Autowired
	private LeadService leadservice;
	
	@RequestMapping("/createlead")
	public String viewCreateLeadPage() {
			return "create_lead";
	}
	
	// method to read the data
	@RequestMapping("/savelead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
//@ModelAttribute:it takes the data from the form then creates lead object, stores the data
		// into lead object(@ModelAttribute(("lead")object created), Lead=entity class name. lead = ref varible)
	// no need to give post and get here coz automatically behaves like post and get
  // when you submit a form it acts like post and when you develop link it act as get
//method will behevior accordingly depends on the task	
//ModelMap is a built in class in spring framework,purpose of modelmap is same as request.setattribute,request.getattribute
		leadservice.saveLead(lead);	
		model.addAttribute("msg", "Lead is saved!!"); // this like set attribute
		return "create_lead";//after saves the data, it would be same page
	}
	//when is type inthe url localhost:8080/listall, it will call this mehtod
	
	@RequestMapping("/listall")
	public String listAllLeads( ModelMap model) {
   // press crl+1 create method in interface ,creating method here
		List<Lead> leads = leadservice.listLeads();
		System.out.println(leads);
		model.addAttribute("leads", leads);
	return "lead_search_result";// now take this object address, in the form and we need to display that in the form of table
	}   //this is where we are using the jstl practically,here inorder to use jstl , we have to downlode jstl jar
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id")long id, ModelMap model) {
		leadservice.deleteOneLeadById(id);
		List<Lead> leads = leadservice.listLeads();
		System.out.println(leads);
		model.addAttribute("leads", leads);
		
		return "lead_search_result";
	}
    @RequestMapping("/update")
	public String updateOneLead(@RequestParam("id")long id,ModelMap model) {
		
    	Lead lead = leadservice.getOneLead(id);
    	
model.addAttribute("lead", lead);
		return "lead_update";
	}
			
    @RequestMapping("/updatelead")
    public String updateOneLeadData(LeadData data, ModelMap model) {
    	Lead lead = new Lead();
    	lead.setId(data.getId());
    	lead.setFirstName(data.getFirstName());
    	lead.setLastName(data.getLastName());
    	lead.setEmail(data.getEmail());
    	lead.setMobile(data.getMobile());
    	leadservice.saveLead(lead);
    	List<Lead> leads = leadservice.listLeads();
		model.addAttribute("leads", leads);
	return "lead_search_result";
    }
	
	
	
	
	
	
	
//	@RequestMapping("/savelead")
//	public String saveOneLead(@RequestParam("fiName")String fname,@RequestParam("laName") String lname,@RequestParam("emailid") String email,@RequestParam("mobilno") long mobile, ModelMap model) {
//               Lead l = new Lead();
//              l.setFirstName(lname);
//              l.setLastName(lname);
//              l.setEmail(email);
//              l.setMobile(mobile);
//		leadservice.saveLead(l);
//		
//		
//		model.addAttribute("msg", "Lead is saved!!"); // this like set attribute
//		return "create_lead";//after saves the data, it would be same page
//	}
	
//	@RequestMapping("/savelead")
//	public String saveOneLead(LeadData data, ModelMap model) {
//            Lead lead = new Lead();
//            lead.setFirstName(data.getFiName());
//            lead.setLastName(data.getLaName());
//            lead.setEmail(data.getEmailid());
//            lead.setMobile(data.getMobilno());
//            leadservice.saveLead(lead);
//            
//		
//		
//		model.addAttribute("msg", "Lead is saved!!"); // this like set attribute
//		return "create_lead";//after saves the data, it would be same page
//	}
//	
	
	
}
