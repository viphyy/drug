package com.gxuts.wss.dms.service.hr;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.SignInfo;

public interface SignService {
	public Serializable save(String userNo,Date recordDate, Date signDate);
	public SignInfo get(Class<SignInfo> c, Serializable id);
	public Serializable save(SignInfo sign);
	public void delete(SignInfo sign);

	public void update(SignInfo sign);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<SignInfo> queryAll(Class<SignInfo> c);

	public SignInfo load(Class<SignInfo> c, Serializable id);

	public SignInfo get(String hql, Map<String, Object> params);

	public SignInfo getObject(String hql, Object[] params);

	public Page<SignInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	public SignInfo getByHql(String hql);
	public SignInfo getByRecord(String userNo,Date recordDate);
	void updateHasLeaveMoonth();

}
