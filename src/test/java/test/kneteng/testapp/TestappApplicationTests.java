package test.kneteng.testapp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.kneteng.testapp.domain.Contractor;
import test.kneteng.testapp.domain.Manager;
import test.kneteng.testapp.domain.Member;
import test.kneteng.testapp.mapper.ContractorMapper;
import test.kneteng.testapp.mapper.ManagerMapper;
import test.kneteng.testapp.mapper.MemberMapper;
import test.kneteng.testapp.service.ContractorService;
import test.kneteng.testapp.service.ManagerService;
import test.kneteng.testapp.service.MemberService;
import test.kneteng.testapp.util.MyBatisUtil;

@SpringBootTest
class TestappApplicationTests {
	@Autowired
	private MemberService memberService;

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private ContractorService contractorService;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void getBlogById() throws Exception 
	{
	     List<Member> members =  memberService.list();
	     List<Manager> managers = managerService.list();
	     List<Contractor> contractors = contractorService.list();
	     /*
	     Blog blog = blogMapper.getBlogById(1);
	     System.out.println(blog);
	     List<Post> posts = blog.getPosts();
	     */
	     for (Member post : members) {
	    	 System.out.println(post);
	     }
	}
	
	@Test
	public void memberInsertion() {
	     SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	     try{
	     }finally{
	    	 sqlSession.close();
	     }
	}
}
