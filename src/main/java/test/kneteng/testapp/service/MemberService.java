package test.kneteng.testapp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import test.kneteng.testapp.domain.Member;
import test.kneteng.testapp.mapper.MemberMapper;
import test.kneteng.testapp.util.MyBatisUtil;

@Service
public class MemberService {
	public void insert(Member member) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
			  MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			  memberMapper.insert(member);
		  }catch(Exception e) {
			  throw new Exception(e.getMessage());
		  }finally{
			  sqlSession.close();
		  }
	}
	
	public void delete(int id) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
			  MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			  memberMapper.delete(id);
		  }catch(Exception e) {
			  throw new Exception(e.getMessage());
		  }finally{
			  sqlSession.close();
		  }
	}
	
	public void update(Member member) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
			  MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			  memberMapper.update(member);
		  }catch(Exception e) {
			  throw new Exception(e.getMessage());
		  }finally{
			  sqlSession.close();
		  }
	}
	
	public List<Member> list() throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
			 MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			  return memberMapper.findAll();
		  }finally{
			  sqlSession.close();
		  }
	}
	
	public Member find(int id) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
			  MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			  return memberMapper.findById(id);
		  }catch(Exception e) {
			  throw new Exception(e.getMessage());
		  }finally{
			  sqlSession.close();
		  }
	}
}
