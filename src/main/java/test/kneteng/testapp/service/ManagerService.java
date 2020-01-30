package test.kneteng.testapp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import test.kneteng.testapp.domain.Manager;
import test.kneteng.testapp.mapper.ManagerMapper;
import test.kneteng.testapp.util.MyBatisUtil;

@Service
public class ManagerService {
	public void insert(Manager manager) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
			managerMapper.insert(manager);
			sqlSession.commit();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}
	
	public void delete(int id) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
			managerMapper.delete(id);
			sqlSession.commit();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}
	
	public void update(Manager manager) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
			managerMapper.update(manager);
			sqlSession.commit();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Manager> list() throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
			  ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
			  return managerMapper.findAll();
		  }finally{
			  sqlSession.close();
		  }
	}
	
	public Manager find(int id) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
			  ManagerMapper managerMapper = sqlSession.getMapper(ManagerMapper.class);
			  return managerMapper.findById(id);
		  }catch(Exception e) {
			  throw new Exception(e.getMessage());
		  }finally{
			  sqlSession.close();
		  }
	}
}
