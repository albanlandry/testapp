package test.kneteng.testapp.mapper;

import java.util.List;

import test.kneteng.testapp.domain.Member;

public interface MemberMapper {
	  int insert(Member member);

	  List<Member> findAll();

	  int update(Member member);

	  Member findById(int no);

	  int delete(int no);
	  
	  Member findByEmailPassword();
}
