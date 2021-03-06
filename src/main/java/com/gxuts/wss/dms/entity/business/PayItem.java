package com.gxuts.wss.dms.entity.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 付款申请明细
 * @author nf0830
 *	
 */
@Entity
public class PayItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String no;               
	private String used; 				//用途
	private Double income; 				//已收
	private Double recome; 				//应收
	private Double computed; 			//折算
	private Double payment;  			//付款总计
	private String payCurrency;  		 //付款币种
	private String incCurrency;  		 //已收币种
	
	public PayItem(Integer id) {
		this.id = id;
	}
	public PayItem() {
	}
	public PayItem(String no) {
		this.no=no;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Double getRecome() {
		return recome;
	}
	public void setRecome(Double recome) {
		this.recome = recome;
	}
	public Double getComputed() {
		return computed;
	}
	public void setComputed(Double computed) {
		this.computed = computed;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public String getPayCurrency() {
		return payCurrency;
	}
	public void setPayCurrency(String payCurrency) {
		this.payCurrency = payCurrency;
	}
	public String getIncCurrency() {
		return incCurrency;
	}
	public void setIncCurrency(String incCurrency) {
		this.incCurrency = incCurrency;
	}
	 
	
}
