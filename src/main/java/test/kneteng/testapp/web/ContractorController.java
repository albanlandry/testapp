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

import com.google.gson.Gson;

import test.kneteng.testapp.domain.Contractor;
import test.kneteng.testapp.domain.Manager;
import test.kneteng.testapp.service.ContractorService;
import test.kneteng.testapp.service.ManagerService;
import test.kneteng.testapp.util.BeansToJSON;

@Controller
@RequestMapping("/contractor")
public class ContractorController {
	private static final int ATT_MAX_MANAGERS = 8;
	private static final String ATT_MAX_CONTRACTOR_LIST = "contractors";
	private static final String ATT_MAX_CONTRACTOR_SINGLE = "contractor";
	private static final String ATT_ACTION = "action";
	
	
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
		/**
		 * Creation of the bean that will be use for the creation of new contractor
		 * */
		Contractor contractor = new Contractor();
		List<Manager> managers= new ArrayList<Manager>();
		
		for(int i = 0; i < ATT_MAX_MANAGERS; i++) {
			managers.add(new Manager());
		}
		
		contractor.setManagers(managers);
		
		model.addAttribute(ATT_MAX_CONTRACTOR_SINGLE, contractor);
		return "form/new_contractor";
	}
	
	@GetMapping("details/{id}")
	public String details(@PathVariable int id, Model m) throws Exception {
		Contractor contractor = contractorService.find(id); 
		
		m.addAttribute(ATT_MAX_CONTRACTOR_SINGLE, contractor);
		
		return "form/new_contractor";
	}
	
	@PostMapping("save")
	public String addContractor(@ModelAttribute Contractor contractor) throws Exception {
		// Insertion of the new contractor
		contractorService.insert(contractor);
		List<Manager> managers = contractor.getManagers();
		// Insertion of the managers
		// Only if all the information is correct
		for(Manager manager : managers) {
			if(manager.getName() != null && !manager.getName().isEmpty()) {
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
			if(manager.getName() != null && !manager.getName().isEmpty()) {
				manager.setContractor(contractor);
				managerService.update(manager);
			}
		}
		
		return "redirect:list" /*"Managers: "+contractor.getManagers()*/;
	}
}
