package com.gxuts.wss.dms.controller.sys;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.AttaFile;
import com.gxuts.wss.dms.entity.sys.AttaEditor;

@Controller
@RequestMapping(value = "/upload")
@ResponseBody
public class UploadController {
	@RequestMapping(value = "/some", method = { RequestMethod.POST,RequestMethod.GET })
	public AttaFile some(HttpServletRequest req, HttpServletResponse rep,HttpSession session) {
		String userNo=((UserInfo)session.getAttribute("loginUser")).getNo();
		AttaFile fr=new AttaFile();
		String savePath = req.getSession().getServletContext().getRealPath("");
		String webPath = "\\files\\" + userNo+new Date().getTime()+"\\";
		savePath = savePath + webPath;
		File filePath =new File(savePath);
		filePath.mkdir();
		// 把文件上传到服务器指定位置，并向前台返回文件名
		if (req.getParameter("up") != null) {
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			List fileList = null;
			try {
				// 文件类型解析req
				fileList = (List<FileItem>) upload.parseRequest(req);
			} catch (FileUploadException ex) {
				// 终止文件上传，此处抛出异常
				ex.printStackTrace();
			}
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if (!item.isFormField()) {
					String name = item.getName();
					String type = item.getContentType();
					if (item.getName() == null
							|| item.getName().trim().equals("")) {
						continue;
					}
					File file = new File(savePath + name);
					try {
						// 将文件存入本地服务器
						item.write(file);
						fr.setFileType(name.substring(name.indexOf(".")));
						fr.setWebPath(webPath+name);
						fr.setFileName(name);
						fr.setOk(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return fr;
	}
	@RequestMapping(value = "/editor", method = { RequestMethod.POST,RequestMethod.GET })
	public AttaEditor image(HttpServletRequest req, HttpServletResponse rep,HttpSession session) {
		String userNo=((UserInfo)session.getAttribute("loginUser")).getNo();
		AttaEditor fr=new AttaEditor();
		String savePath = req.getSession().getServletContext().getRealPath("");
		String webPath = "/files/" + userNo+new Date().getTime()+"/";
		savePath = savePath + webPath;
		File filePath =new File(savePath);
		filePath.mkdir();
		// 把文件上传到服务器指定位置，并向前台返回文件名
		if (req.getParameter("up") != null) {
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			List fileList = null;
			try {
				// 文件类型解析req
				fileList = (List<FileItem>) upload.parseRequest(req);
			} catch (FileUploadException ex) {
				// 终止文件上传，此处抛出异常
				ex.printStackTrace();
			}
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if (!item.isFormField()) {
					String name = item.getName();
					String type = item.getContentType();
					if (item.getName() == null
							|| item.getName().trim().equals("")) {
						continue;
					}
					File file = new File(savePath + name);
					try {
						// 将文件存入本地服务器
						item.write(file);
						fr.setMsg(webPath.substring(1)+name);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return fr;
	}
}