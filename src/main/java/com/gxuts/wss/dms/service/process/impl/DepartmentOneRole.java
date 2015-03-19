package com.gxuts.wss.dms.service.process.impl;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowUserService;
@SuppressWarnings("serial")
@Component
public class DepartmentOneRole implements TaskListener, Serializable {
	@Autowired
	private UserService userService;
	private Expression roleName;

	public Expression getRoleName() {
		return roleName;
	}
	public void setRoleName(Expression roleName) {
		this.roleName = roleName;
	}

	@Override
	public void notify(DelegateTask delegateTask) {
//		System.out.println(userService);
//		System.out.println(flowUserService);
		String role = roleName.getExpressionText();
		int departmentId=(int) delegateTask.getVariable("departmentId");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		FlowUserService flowUserService=(FlowUserService) context.getBean("flowUserService");
		UserInfo user=flowUserService.departmentOneRole(departmentId, role);
		delegateTask.setAssignee(user.getNo());
		flowUserService.departmentOneRole(departmentId, role);
		System.out.println("DepartmentOneRole Listener");
		
	}

}
