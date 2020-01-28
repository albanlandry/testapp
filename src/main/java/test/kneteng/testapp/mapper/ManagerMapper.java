package test.kneteng.testapp.mapper;

import java.util.List;

import test.kneteng.testapp.domain.Manager;

public interface ManagerMapper {
	  int insert(Manager manager);

	  List<Manager> findAll();

	  int update(Manager manager);

	  Manager findById(int no);

	  int delete(int no);
}
