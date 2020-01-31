package test.kneteng.testapp.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Contractor implements Serializable {

  private static final long serialVersionUID = 1L;

  private int contractorNo;
  private String company;
  // company registration number ?��?��?�� ?��록번?��
  private String crn;
  private String owner;
  private String address;
  // ?��?��
  private String business;
  // 종목
  private String item;
  private String tel;
  private String fax;
  // 계좌번호
  private String accountNo;
  private Date lastDate;
  private Date date;
  // �??�� 개발 ?���??��
  private String requisitionForm;
  // ?��방서
  private String specification;
  // ?��?�� ?���?
  private String productDrawing;

  // Managers
  private List<Manager> managers;

  
  
  public Contractor() {
	super();
	this.contractorNo = 0;
	this.company = "";
	this.crn = "";
	this.owner = "";
	this.address = "";
	this.business = "";
	this.item = "";
	this.tel = "";
	this.fax = "";
	this.accountNo = "";
	this.lastDate = null;
	this.date = null;
	this.requisitionForm = "";
	this.specification = "";
	this.productDrawing = "";
	this.managers = null;
}

public int getContractorNo() {
    return contractorNo;
  }

  public void setContractorNo(int contractorNo) {
    this.contractorNo = contractorNo;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getCrn() {
    return crn;
  }

  public void setCrn(String crn) {
    this.crn = crn;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getBusiness() {
    return business;
  }

  public void setBusiness(String business) {
    this.business = business;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public Date getLastDate() {
    return lastDate;
  }

  public void setLastDate(Date lastDate) {
    this.lastDate = lastDate;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getRequisitionForm() {
    return requisitionForm;
  }

  public void setRequisitionForm(String requisitionForm) {
    this.requisitionForm = requisitionForm;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }

  public String getProductDrawing() {
    return productDrawing;
  }

  public void setProductDrawing(String productDrawing) {
    this.productDrawing = productDrawing;
  }

  	public List<Manager> getManagers() {
  		return managers;
	}
	
	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

@Override
  public String toString() {
    return "{\"contractorNo\":" + contractorNo + ", \"company\":\"" + company + "\", \"crn\":\"" + crn
        + "\", \"owner\":\"" + owner + "\", \"address\":\"" + address + "\", \"business\":\"" + business + "\", \"item\":\"" + item
        + "\", \"tel\":\"" + tel + "\", \"fax\":\"" + fax + "\", \"accountNo\":\"" + accountNo + "\", \"lastDate\":\"" + lastDate
        + "\", \"date\":\"" + date + "\", \"requisitionForm\":\"" + requisitionForm + "\", \"specification\":\""
        + specification + "\", \"productDrawing\":\"" + productDrawing + "\", \"managers\":"+managers
        + "}";
  }
}
