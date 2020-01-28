package test.kneteng.testapp.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.kneteng.testapp.domain.Manager;
import test.kneteng.testapp.domain.Member;
import test.kneteng.testapp.mapper.ManagerMapper;
import test.kneteng.testapp.mapper.MemberMapper;
import test.kneteng.testapp.util.MyBatisUtil;

@Controller
public class MemberController {
	
	@RequestMapping("/")
	public @ResponseBody String testString() {
	     SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	     MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
	     ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
	     List<Member> members =  memberMapper.findAll();
	     List<Manager> managers = managerMapper.findAll();
	     
		return "Member(s): "+members.size()+"<br /> Manager(s): "+managers.size();
	}
}
