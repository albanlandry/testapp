package test.kneteng.testapp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import test.kneteng.testapp.domain.Contractor;
import test.kneteng.testapp.mapper.ContractorMapper;
import test.kneteng.testapp.util.MyBatisUtil;

@Service
public class ContractorService {
	public void insert(Contractor contractor) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ContractorMapper contractorMapper = sqlSession.getMapper(ContractorMapper.class);
			contractorMapper.insert(contractor);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}
	
	public void delete(int id) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ContractorMapper contractorMapper = sqlSession.getMapper(ContractorMapper.class);
			contractorMapper.delete(id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}
	
	public void update(Contractor contractor) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ContractorMapper contractorMapper = sqlSession.getMapper(ContractorMapper.class);
			contractorMapper.update(contractor);
			sqlSession.commit();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Contractor> list() throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ContractorMapper contractorMapper = sqlSession.getMapper(ContractorMapper.class);
			return contractorMapper.findAll();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}
	
	public Contractor find(int id) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ContractorMapper contractorMapper = sqlSession.getMapper(ContractorMapper.class);
			return contractorMapper.findById(id);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}
}
