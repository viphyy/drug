package com.gxuts.wss.dms.service.csrm.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
import com.gxuts.wss.dms.service.csrm.PurchaseContractService;
import com.gxuts.wss.dms.service.csrm.PurchaseService;
@Service("purchaseContractService")
@Transactional
public class PurchaseContractServiceImpl implements PurchaseContractService {

	@Autowired
	private PurchaseDao purchaseDao;
	@Autowired
	private PurchaseContractDao purchaseContractDao;
	@Autowired
	private DrugDao drugDao;
	@Override
	public Serializable save(PurchaseContractBill contract) {
		return purchaseContractDao.save(contract);
	}

	@Override
	public void delete(PurchaseContractBill contract) {
		contract=purchaseContractDao.get(PurchaseContractBill.class, contract.getId());
		List<DrugInfo> drugs=contract.getDrugs();
		for (DrugInfo drug:drugs) {
			drugDao.delete(drug);
		}
		purchaseContractDao.delete(contract);
	}

	@Override
	public void update(PurchaseContractBill contract) {
		purchaseContractDao.update(contract);
	}

	@Override
	public PurchaseContractBill get(Class<PurchaseContractBill> c,
			Serializable id) {
		return purchaseContractDao.get(c, id);
	}
	//需要产生采购（未保存状态）
	public PurchaseContractBill fromPurchase(Integer purchaseId){
		PurchaseContractBill contract=new PurchaseContractBill();
		PurchaseBill purchase=purchaseDao.get(PurchaseBill.class, purchaseId);
		contract.setPurchaseNo(purchase.getNo());
		contract.setDrugs(purchase.getDrugs());
		return contract;
	}
	@Override
	public int executeHql(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PurchaseContractBill> queryAll(Class<PurchaseContractBill> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseContractBill load(Class<PurchaseContractBill> c,
			Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseContractBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseContractBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PurchaseContractBill> query(String hql,
			Map<String, Object> params, Integer currentPage, Integer rows) {
		return purchaseContractDao.query(hql, params, currentPage, rows);
	}
	 
	 
	 

}
