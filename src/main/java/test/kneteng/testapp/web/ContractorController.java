package test.kneteng.testapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import test.kneteng.testapp.service.MemberService;

@Controller
public class ContractorController {
	@Autowired
	private MemberService ContractorService;
	
	@GetMapping("/contractors")
	public String list() {
		return "display/contractor";
	}
	
	@GetMapping("/contractor/new")
	public String add() {
		return "form/contractor";
	}
}
