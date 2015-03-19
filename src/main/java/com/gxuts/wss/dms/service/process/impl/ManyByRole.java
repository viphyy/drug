package com.gxuts.wss.dms.service.process.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.process.FlowUserService;
@Component
@SuppressWarnings("serial")
public class ManyByRole implements TaskListener, Serializable {
	@Autowired
	private FlowUserService flowUserService;
	private Expression roleName;

	public Expression getRoleName() {
		return roleName;
	}
	public void setRoleName(Expression roleName) {
		this.roleName = roleName;
	}

	@Override
	public void notify(DelegateTask delegateTask) {
		String role = roleName.getExpressionText();
		//List<UserInfo> users=flowUserService.manyByRole(role);
		delegateTask.setVariable("assignList",Arrays.asList(role+1,role+2,role+3));
		System.out.println("ManyByRole Listener");
	}

}
