package com.gxuts.wss.dms.controller.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.business.PurchaseContractService;
import com.gxuts.wss.dms.service.business.DrugService;

import org.springframework.ui.Model;
 
@Controller
@RequestMapping(value = "/drug")
public class DrugController {
	@Autowired
	private DrugService drugService;
	
	
	@RequestMapping(value="list")
	public String getList(HttpServletRequest request,Integer currentPage, Integer row,Model model){
		 Page<Object[]> pages=drugService.queryDrugList(null, null, null);
		 model.addAttribute("pages",pages);
		return "drugList";
	}
	
	@RequestMapping(value = "/toPurchase",method={RequestMethod.POST,RequestMethod.GET})
	public String toPurchase(String[] ids,HttpServletRequest q) {
		String[] ids2=q.getParameterValues("ids");
		if(ids2!=null){
			for (String a:ids2) {
				System.out.println(a);
			}	
		}
		return "purchaseDetail";
	}
	@RequestMapping(value = "/toExport",method=RequestMethod.POST)
	public String toExport(String[] ids,HttpServletRequest q) {
		String[] ids2=q.getParameterValues("ids");
		if(ids2!=null){
			for (String a:ids2) {
				System.out.println(a);
			}	
		}
		
		return "purchaseDetail";
	}
}
