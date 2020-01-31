package test.kneteng.testapp.domain;

import java.io.Serializable;

public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;

  	private int managerNo;
  	private String name;
  	private String department;
  	private String tel;
  	private Contractor contractor;

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

  	public Contractor getContractor() {
  		return contractor;
  	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public boolean isEmpty() {
		return  (this.getTel() == null || this.getTel().isEmpty())
				&& (this.getName() == null || this.getName().isEmpty())
				&& (this.getDepartment() == null || this.getDepartment().isEmpty());
	}
	
	@Override
	public String toString() {
	    return "{\"managerNo\":\"" + managerNo + "\", \"name\":\"" + name
	    + "\", \"department\":\"" + department + "\", \"tel\":\"" + tel + "\"}";
	}
}
