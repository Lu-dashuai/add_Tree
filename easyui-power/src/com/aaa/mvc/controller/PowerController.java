package com.aaa.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.mvc.service.PowerService;

/***
 *@className:PowerController.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-9上午11:53:50
 *@version:
 */
@Controller
@RequestMapping("/power")
public class PowerController {

	@Autowired
	private PowerService powerService;
	
	/**
	 * 权限树json数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/tree")
	public Object powerTree(){
		return powerService.getList();
	}
}
