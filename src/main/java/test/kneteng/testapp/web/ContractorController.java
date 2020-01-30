package test.kneteng.testapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.kneteng.testapp.domain.Contractor;
import test.kneteng.testapp.domain.Manager;
import test.kneteng.testapp.service.ContractorService;
import test.kneteng.testapp.service.ManagerService;
import test.kneteng.testapp.util.BeansToJSON;
import test.kneteng.testapp.web.form.ContractorForm;
import test.kneteng.testapp.web.form.ManagerForm;

@Controller
@RequestMapping("/contractor")
public class ContractorController {
	private static final int ATT_MAX_MANAGERS = 8;
	private static final String ATT_MAX_CONTRACTOR_LIST = "contractors";
	private static final String ATT_MAX_CONTRACTOR_SINGLE = "contractor";
	private static final String ATT_ACTION = "action";
	private static String ATT_ACTION_UPDATE = "../update";
	private static String ATT_ACTION_SAVE = "save";
	
	
	@Autowired
	private ContractorService contractorService;
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<Contractor> contractors = contractorService.list();
		
		model.addAttribute(ATT_MAX_CONTRACTOR_LIST, contractors);
		return "display/contractor";
	}
	
	@GetMapping("json")
	@ResponseBody
	public String getToJson() throws Exception{
		List<Contractor> contractors = new ArrayList<Contractor>();
		try {
			contractors = contractorService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return BeansToJSON.ContractorsToJSON(contractors);
	}
	
	@GetMapping("new")
	public String newContractor(Model model) {
		 // Creation of the bean that will be used 
		// for the creation of new contractor
		Contractor contractor = new Contractor();
		contractor = ContractorForm.addEmptyManager(contractor, ATT_MAX_MANAGERS);
		
		model.addAttribute(ATT_ACTION, ATT_ACTION_SAVE);
		model.addAttribute(ATT_MAX_CONTRACTOR_SINGLE, contractor);
		return "form/new_contractor";
	}
	
	@GetMapping("details/{id}")
	public String details(@PathVariable int id, Model model) throws Exception {
		Contractor contractor = contractorService.find(id); 
		contractor = ContractorForm.addEmptyManager(contractor, ATT_MAX_MANAGERS - contractor.getManagers().size());
		// For the modification, all managers need to be visible
		// We add the number of empty space necessary for 8 managers
		
		model.addAttribute(ATT_MAX_CONTRACTOR_SINGLE, contractor);
		model.addAttribute(ATT_ACTION, ATT_ACTION_UPDATE);
		
		return "form/new_contractor";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) throws Exception {
		contractorService.delete(id);
		return "redirect:../list";
	} 
	
	@PostMapping("save")
	public String addContractor(@ModelAttribute Contractor contractor) throws Exception {
		// Insertion of the new contractor
		contractorService.insert(contractor);
		List<Manager> managers = contractor.getManagers();
		// Insertion of the managers
		// Only if all the information is correct
		for(Manager manager : managers) {
			if(!manager.isEmpty()) {
				manager.setContractor(contractor);
				managerService.insert(manager);
			}
		}
		
		return "redirect:list" /*"Managers: "+contractor.getManagers()*/;
	}
	
	@PostMapping("update")
	public String update(@ModelAttribute Contractor contractor) throws Exception {
		// Insertion of the new contractor
		contractorService.update(contractor);
		List<Manager> managers = contractor.getManagers();
		// Insertion of the managers
		// Only if all the information is correct
		for(Manager manager : managers) {
			if(manager.getManagerNo() != 0 && !manager.isEmpty()) {
				manager.setContractor(contractor);
				managerService.update(manager);
			}else if(manager.getManagerNo() != 0 && manager.isEmpty()) { // We delete if the manager exists in db but is empty
				managerService.delete(manager.getManagerNo());
			}else if(!manager.isEmpty()) {
				manager.setContractor(contractor);
				managerService.insert(manager);
			}
		}
		
		return "redirect:list" /*"Managers: "+contractor.getManagers()*/;
	}
}
