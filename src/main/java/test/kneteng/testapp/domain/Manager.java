package test.kneteng.testapp.domain;

import java.io.Serializable;

public class Manager implements Serializable {

  private static final long serialVersionUID = 1L;

  private int managerNo;
  private int contractorNo;
  private String name;
  private String department;
  private String tel;

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

  public int getContractorNo() {
    return contractorNo;
  }

  public void setContractorNo(int contractorNo) {
    this.contractorNo = contractorNo;
  }

  @Override
  public String toString() {
    return "Manager [managerNo=" + managerNo + ", contractorNo=" + contractorNo + ", name=" + name
        + ", department=" + department + ", tel=" + tel + "]";
  }
}
