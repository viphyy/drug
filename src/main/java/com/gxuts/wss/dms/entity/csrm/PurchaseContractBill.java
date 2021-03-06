package com.gxuts.wss.dms.entity.csrm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

 












import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.gxuts.wss.dms.entity.hr.UserInfo;
@Entity
public class PurchaseContractBill implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String no;
	private String purchaseNo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	@ManyToOne
	private UserInfo createUser;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	
	private Date updateDate;
	private UserInfo updateUser;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "contract",orphanRemoval=true)
	private List<DrugInfo> drugs;

	public PurchaseContractBill(){};
	public PurchaseContractBill(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UserInfo getCreateUser() {
		return createUser;
	}

	public void setCreateUser(UserInfo createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public UserInfo getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UserInfo updateUser) {
		this.updateUser = updateUser;
	}

 

	public List<DrugInfo> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<DrugInfo> drugs) {
		this.drugs = drugs;
	}

	@Override
	public String toString() {
		return "PurchaseContractBill [id=" + id + ", name=" + name + ", no="
				+ no + ", drugs=" + drugs + "]";
	}

 
	
	
}
