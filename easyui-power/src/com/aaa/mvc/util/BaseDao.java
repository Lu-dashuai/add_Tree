package com.aaa.mvc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/*
 * 1、静态代码块
 * 2、连接数据库
 * 3、给参数
 * 4、增删该查
 * 5、关闭数据库资源
 */
public class BaseDao {
	private static final String className = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/mysql827?user=root&password=311415";
	private static Connection con = null;
	private static java.sql.PreparedStatement ps = null;
	private static ResultSet rs = null;
	/**
	 * 静态代码块，注册驱动
	 */
	static{
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 连接数据库
	 */
	public static Connection getConnection(){
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 *传参 
	 */
	public static void giveParams(Object[] params){
		for(int i = 0;i<params.length;i++){
			try {
				ps.setObject(i+1, params[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增删改
	 * @return 
	 */
	public static int insertAndDeleteAndUpdate(String sql,Object[] params){
		con = getConnection();
		int row = 0;
		try {
			ps = con.prepareStatement(sql);
			giveParams(params);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return row;
	}
	/**
	 * 查
	 * 
	 */
	public static List<Map<String,Object>> selectMap(String sql,Object[] params){
		con = getConnection();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			ps = con.prepareStatement(sql);
			giveParams(params);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = ps.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()){
				HashMap<String , Object> rowMap = new HashMap<String , Object>();
				for (int i = 0; i < count; i++) {
					rowMap.put(rsmd.getColumnName(i+1), rs.getObject(i+1));
				}
				list.add(rowMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}
	/**
	 * 关掉数据库资源 
	 */
	public static void closeAll(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
