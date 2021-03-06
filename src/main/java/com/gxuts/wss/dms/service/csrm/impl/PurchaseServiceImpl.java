package com.gxuts.wss.dms.service.csrm.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.csrm.DrugDao;
import com.gxuts.wss.dms.dao.csrm.PurchaseContractDao;
import com.gxuts.wss.dms.dao.csrm.PurchaseDao;
import com.gxuts.wss.dms.entity.csrm.DrugInfo;
import com.gxuts.wss.dms.entity.csrm.PurchaseBill;
import com.gxuts.wss.dms.entity.csrm.PurchaseContractBill;
import com.gxuts.wss.dms.service.csrm.DrugService;
import com.gxuts.wss.dms.service.csrm.PurchaseContractService;
import com.gxuts.wss.dms.service.csrm.PurchaseService;
@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseDao purchaseDao;
	@Autowired
	private PurchaseContractDao purchaseContractDao;
	@Autowired
	private PurchaseContractService purchaseContractService;
	@Autowired
	private DrugDao drugDao;
	@Override
	public Serializable save(PurchaseBill purchase) {
		return purchaseDao.save(purchase);
	}

	@Override
	public void delete(PurchaseBill purchase) {
		PurchaseBill p=purchaseDao.get(PurchaseBill.class, purchase.getId());
		List<DrugInfo> drugs=p.getDrugs();
		purchaseDao.delete(p);
		for (DrugInfo drug:drugs) {
			drugDao.delete(drug);
		}
	}

	@Override
	public void update(PurchaseBill purchase) {
		purchaseDao.update(purchase);
		
	}
	@Override
	public PurchaseBill get(Class<PurchaseBill> c, Serializable id) {
		return purchaseDao.get(c, id);
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}
	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		return 0;
	}
	@Override
	public List<PurchaseBill> queryAll(Class<PurchaseBill> c) {
		return null;
	}
	@Override
	public PurchaseBill load(Class<PurchaseBill> c, Serializable id) {
		return null;
	}
	@Override
	public PurchaseBill get(String hql, Map<String, Object> params) {
		return null;
	}
	@Override
	public PurchaseBill getObject(String hql, Object[] params) {
		return null;
	}
	@Override
	public Page<PurchaseBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return purchaseDao.query("from PurchaseBill", params, currentPage, rows);
	}
	
	 

}
