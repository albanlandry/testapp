package test.kneteng.testapp.domain;

import java.io.Serializable;
import java.util.List;

public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;

  	private int managerNo;
  	private String name;
  	private String department;
  	private String tel;
  	private List<Contractor> contractors;

  	public int getManagerNo() {
	  	return managerNo;
  	}

  	public void setManagerNo(int managerNo) {
	  	this.managerNo = managerNo;
  	}

  	public String getName() {
	  	return name;
  	}

  	public void setName(String name) {
	  	this.name = name;
  	}

  	public String getDepartment() {
  		return department;
    }

  	public void setDepartment(String department) {
  		this.department = department;
  	}

  	public String getTel() {
  		return tel;
  	}

  	public void setTel(String tel) {
  		this.tel = tel;
  	}

  	public List<Contractor> getContractors() {
  		return contractors;
  	}

	public void setContractors(List<Contractor> contractors) {
		this.contractors = contractors;
	}

	@Override
	public String toString() {
	    return "Manager [managerNo=" + managerNo + ", name=" + name
	    + ", department=" + department + ", tel=" + tel + "]";
	}
}
