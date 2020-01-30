package test.kneteng.testapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.kneteng.testapp.domain.Contractor;
import test.kneteng.testapp.domain.Member;
import test.kneteng.testapp.service.ContractorService;
import test.kneteng.testapp.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private ContractorService contractorService;
	
	@RequestMapping("/test_query")
	public @ResponseBody String getMember() {
	     List<Member> members = null;
	     List<Contractor> contractors = null;
	     
	     try {
	    	 members =  memberService.list();
	    	 contractors = contractorService.list();
	     } catch (Exception e) {
	    	 // TODO Auto-generated catch block
	    	 e.printStackTrace();
	     }
	     
	     return "Member(s): "+members.size()
	     +"<br/>Contractor (s)"+contractors.size();
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
