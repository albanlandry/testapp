package test.kneteng.testapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.kneteng.testapp.domain.Member;
import test.kneteng.testapp.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/")
	public @ResponseBody String getMember() {
	     List<Member> members = null;
	     
	     try {
	    	 members =  memberService.list();
	     } catch (Exception e) {
	    	 // TODO Auto-generated catch block
	    	 e.printStackTrace();
	     }
	     
	     return "Member(s): "+members.size();
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
