package com.ane56.utils;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.sql.ResultSetMetaData;

public class DAO {
	private static String URL = "jdbc:mysql://192.168.1.22:3306/cos_salesfmb";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String USERNAME = "root";
	private static String PASSWORD = "admin";
	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultset = null;
	private static ResultSetMetaData resultMetaData = null;
	
	/**
	 * This method is used to get the version value 
	 * @param sql   the sql statement to be passed into the method
	 * @return		it will return a String value. 
	 * @throws Exception
	 */
	public static String getCurrentVersion(String sql) throws Exception
	{
		String currentValue = null;
		try
		{
			Class.forName(DRIVER);
	        Connection connect = DriverManager.getConnection(DAO.URL,DAO.USERNAME,DAO.PASSWORD);
		    Statement statement = connect.createStatement();
		    ResultSet rs = statement.executeQuery(sql);
		    if(rs.next())
		    {
		    	currentValue = String.valueOf(rs.getLong(1));
		    }
		    
		    //Release the resource
		    rs.close();
		    statement.close();
		    connect.close();
		}
		catch(Exception ex)
		{
		    ex.printStackTrace();
		}
		
		return currentValue;
	}
	
	public static Map<String, Object> checkDBRecord(String sql, String keyValue) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		String fullSQl = sql + "'" + keyValue + "'";
		
		try {
			//获得DB链接
			Class.forName(DRIVER);
			connect = DriverManager.getConnection(DAO.URL,DAO.USERNAME,DAO.PASSWORD);
			//获取statement
			statement = connect.createStatement();
			//查询得到results
			resultset = statement.executeQuery(fullSQl);
			resultMetaData = resultset.getMetaData();
			//获得查询结果包含的字段数量
			int cols_len = resultMetaData.getColumnCount();
			int counter = 1;
			while(resultset.next())
			{
				for(int i=1;i<=cols_len;i++)
				{
					String colName = resultMetaData.getColumnName(i);
					//int columnType = resultMetaData.getColumnType(i);
					//System.out.println(columnType);
					Object colValue = resultset.getObject(i);
					map.put(colName+"_"+counter, colValue);
				}
				counter += 1;
			}
			
			} catch (Exception e) { 
				System.out.println("query exception"); 
				}
			finally { 
				resultset.close();
				statement.close();
				connect.close();
			}
		return map;
	}
	
	public static void main(String[] args) throws Exception
	{
		
	}

}
