package com.aaa.mvc.dao;

import java.util.List;

import com.aaa.mvc.entity.TreeNode;

/***
 *@className:PowerDao.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-9上午11:19:51
 *@version:
 */
public interface PowerDao {

	/**
	 * 获取权限数据
	 * @return
	 */
	List<TreeNode> getList();
}
