package test.kneteng.testapp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import test.kneteng.testapp.domain.Manager;
import test.kneteng.testapp.domain.Member;
import test.kneteng.testapp.mapper.ManagerMapper;
import test.kneteng.testapp.mapper.MemberMapper;
import test.kneteng.testapp.util.MyBatisUtil;

@SpringBootTest
class TestappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void getBlogById() 
	{
	     SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	     try{
	     MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
	     ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
	     List<Member> members =  memberMapper.findAll();
	     List<Manager> managers = managerMapper.findAll();
	     /*
	     Blog blog = blogMapper.getBlogById(1);
	     System.out.println(blog);
	     List<Post> posts = blog.getPosts();
	     */
	     for (Member post : members) {
	    	 System.out.println(post);
	     }
	     
	     }finally{
	    	 sqlSession.close();
	     }
	}
}
