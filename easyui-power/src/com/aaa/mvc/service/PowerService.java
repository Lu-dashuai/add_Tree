package com.aaa.mvc.service;

import java.util.List;

import com.aaa.mvc.entity.TreeNode;

/***
 *@className:PowerService.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-9上午11:31:24
 *@version:
 */
public interface PowerService {

	/**
	 * 获取权限数据
	 * @return
	 */
	List<TreeNode> getList();
}
