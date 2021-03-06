package com.gxuts.wss.drug.service.flow;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.SignService;
import com.gxuts.wss.dms.service.process.FlowUserService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestFlowUserService {
	@Autowired
	private FlowUserService flowUserService;
	
	@Test
	public void testOneByRole(){
		String user=flowUserService.oneByRole("主管");
		System.out.println(user);
	}
	@Test
	public void testManyByRole(){
		List<String> users=flowUserService.manyByRole("经理");
		System.out.println(users);
	}
	@Test
	public void testLeaderOneRole(){
		String user=flowUserService.leaderByRole(5,"经理");
		System.out.println(user);
	}
}
