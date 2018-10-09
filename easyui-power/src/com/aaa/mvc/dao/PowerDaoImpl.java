package com.aaa.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aaa.mvc.entity.TreeNode;
import com.aaa.mvc.util.BaseDao;

/***
 *@className:PowerDaoImpl.java
 *@discripton:
 *@author:zz
 *@createTime:2018-10-9上午11:21:04
 *@version:
 */
@Repository
public class PowerDaoImpl implements PowerDao {

	@Override
	public List<TreeNode> getList() {
		// TODO Auto-generated method stub
		//查询数据
		List<Map<String, Object>> powerMapList = BaseDao.selectMap("select id,name,parentid,state,iconcls,url from tb_power", new Object[]{});
		//定义返回列表
		List<TreeNode> powerList = new ArrayList<TreeNode>();
		//判断是否为空
		 if(powerMapList!=null&&powerMapList.size()>0){
			 TreeNode treeNode = null;
			 //循环遍历，构造TreeNode对象，加入powerList
			 for(Map powerMap:powerMapList){
				// treeNode = new TreeNode(id, text, parentId, state, iconCls, url);
				 treeNode = new TreeNode(Integer.valueOf(powerMap.get("id")+""), powerMap.get("name")+"",
						 Integer.valueOf(powerMap.get("parentid")+""), powerMap.get("state")+""
						 , powerMap.get("iconcls")+"", powerMap.get("url")+"");
				 powerList.add(treeNode);
			 }
		 }
		return powerList;
	}


}
