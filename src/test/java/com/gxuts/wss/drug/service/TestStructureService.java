package com.gxuts.wss.drug.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.service.hr.StructureService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestStructureService {
	@Autowired
	private StructureService structureService;
	
	@Test
	public void testSave(){
		StructureInfo structure=new StructureInfo();
		structure.setName("业务三部");
		structureService.save(structure);
	}
}