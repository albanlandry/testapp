package test.kneteng.testapp.mapper;

import java.util.List;

import test.kneteng.testapp.domain.Contractor;

public interface ContractorMapper {
	  int insert(Contractor contractor);
	  
	  List<Contractor> findAll();
	  
	  int update(Contractor contractor);
	  
	  Contractor findBy(int no);
	  
	  int delete(int no);
	  
	  int countAll();
}