package com.gxuts.wss.dms.entity.csrm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.gxuts.wss.dms.entity.hr.UserInfo;
@Entity
public class ExportBill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String no;
	private String name;
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="exportBill")
	private List<ExportDrug> exportDrugs;
	
	public ExportBill(){}
	public ExportBill(Integer id2) {
		this.id=id2;
	}


	public Integer getId() {
		return id;
	}


	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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


	public List<ExportDrug> getExportDrugs() {
		return exportDrugs;
	}


	public void setExportDrugs(List<ExportDrug> exportDrugs) {
		this.exportDrugs = exportDrugs;
	}


	@Override
	public String toString() {
		return "ExportBill [id=" + id + ", name=" + name + ", exportDrugs="
				+ exportDrugs + "]";
	}
	
}
