package com.gxuts.wss.drug.service.finance;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.entity.finance.ExpenseBill;
import com.gxuts.wss.dms.entity.finance.ExpenseItem;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.business.DrugService;
import com.gxuts.wss.dms.service.business.PurchaseContractService;
import com.gxuts.wss.dms.service.finance.ExpenseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TestExpenseService {
	@Autowired
	private ExpenseService expenseService;
	@Test
	public void testSave() {
		ExpenseBill bill=new ExpenseBill();
		bill.setName("test");
		ExpenseItem item1=new ExpenseItem();
		item1.setName("电话费");
		List<ExpenseItem> items=new ArrayList<ExpenseItem>();
		items.add(item1);
		bill.setItems(items);
		expenseService.save(bill);

	}
	
	@Test
	public void get (){
		ExpenseBill bill=expenseService.get(ExpenseBill.class,1);
		System.out.println(bill.getItems().get(0).getName());
	}
	@Test
	public void update (){
		ExpenseBill bill=expenseService.get(ExpenseBill.class,1);
		ExpenseItem it=bill.getItems().get(0);
		it.setName("交通费");
		expenseService.update(bill);
	}
	
	@Test
	public void delete (){
		expenseService.delete(new ExpenseBill(1));
	}
	 
}