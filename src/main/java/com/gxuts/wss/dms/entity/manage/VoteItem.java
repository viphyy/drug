package com.gxuts.wss.dms.entity.manage;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class VoteItem implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String pic;
	private int voteNum;
	private String users;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	
	public VoteItem() {}
	public VoteItem(String name) {
		this.name = name;
	}
	public VoteItem(String name,int voteNum) {
		this.name = name;
		this.voteNum = voteNum;
	}
	public Integer getId() {
		return id;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getVoteNum() {
		return voteNum;
	}
	public void setVoteNum(int voteNum) {
		this.voteNum = voteNum;
	}
	
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "name=" + name + ", voteNum=" + voteNum + ", users="
				+ users ;
	}
	
}

