package com.gxuts.wss.dms.entity.sys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UrlInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String url;
	
	public UrlInfo(){	}
	public UrlInfo(String url){
		this.url=url;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public boolean equals(Object obj) {
		return  this.url.equals(((UrlInfo)obj).getUrl());
	}
	
	
	
}
