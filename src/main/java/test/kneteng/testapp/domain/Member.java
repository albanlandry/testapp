package test.kneteng.testapp.domain;

import java.io.Serializable;

public class Member implements Serializable {

  private static final long serialVersionUID = 1L;

  private int memberNo;
  private String name;
  private String email;
  private String password;
  private String department;
  private int grade;

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return "Member [memberNo=" + memberNo + ", name=" + name + ", email=" + email + ", password="
        + password + ", department=" + department + ", grade=" + grade + "]";
  }
}
