package com.gxuts.wss.dms.service.manage.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.manage.VoteDao;
import com.gxuts.wss.dms.dao.manage.VoteItemDao;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.VoteInfo;
import com.gxuts.wss.dms.entity.manage.VoteItem;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.manage.VoteService;
import com.gxuts.wss.dms.util.QueryFilter;
@Service("voteService")
@Transactional
public class VoteServiceImpl implements VoteService {
	@Autowired
	private VoteDao voteDao;
	@Autowired
	private VoteItemDao voteItemDao;

	@Override
	public Serializable save(VoteInfo vote) {
		return voteDao.save(vote);
		
	}
	@Override
	public VoteInfo get(Class<VoteInfo> c, Serializable id) {
		return voteDao.get(c, id);
	}

	@Override
	public VoteInfo get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public VoteInfo load(Class<VoteInfo> c, Serializable id) {
		return null;
	}

	@Override
	public VoteInfo getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public List<VoteInfo> queryAll() {
		return voteDao.queryAll(VoteInfo.class);
	}

	@Override
	public Page<VoteInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return voteDao.query("from VoteInfo", params, currentPage, rows);
	}

	@Override
	public VoteInfo getByNo(Class<VoteInfo> c, String no) {
		return null;
	}

	@Override
	public VoteInfo getByHql(String hql) {
		return null;
	}

	@Override
	public void delete(VoteInfo vote) {
		voteDao.delete(vote);
	}

	@Override
	public void update(VoteInfo vote) {
		voteDao.update(vote);
	}
	@Override
	public Json vote(UserInfo user,int voteId,int itId) {
		VoteInfo vote=voteDao.get(VoteInfo.class, voteId);
		if(vote.getEndTime().before(new Date())){
			return new Json("已过期", "300", null, null, null, null);
		}
		if(vote.getIsOpen()==false){
			return new Json("投票未开启", "300", null, null, null, null);
		}
		StringBuilder oUsers=new StringBuilder();
		List<VoteItem> its=vote.getItems();
		for(VoteItem it:its){
			String iu=it.getUsers();
			if(iu !=null){
				oUsers.append(iu);
			}
		}
		if(oUsers.indexOf(user.getNo())>-1){
			return new Json("您已经投过票了", "300", null, null, null, null);
		}
		voteItem(user, itId);
		return new Json("投票成功", "200", null, null,"forward","vote/view/"+voteId);
	}
	public void voteItem(UserInfo user, int itId) {
		VoteItem voteItem = voteItemDao.get(VoteItem.class, itId);
		String iusers=voteItem.getUsers();
		if(iusers==null||iusers.length()<1){
			voteItem.setUsers(user.getName()+"("+user.getNo()+")");
		}else{
			voteItem.setUsers(iusers+","+user.getName()+"("+user.getNo()+")");
		}
		voteItem.setVoteNum(voteItem.getVoteNum()+1);
		voteItemDao.update(voteItem);
	}
	@Override
	public Page<VoteInfo> find(QueryFilter filter) {
		return voteDao.find(filter);
	}
	@Override
	public VoteInfo getAvailable() {
		return  voteDao.getAvailable();
	}
	 
}
