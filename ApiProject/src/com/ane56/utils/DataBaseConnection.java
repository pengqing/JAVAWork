package com.ane56.utils;
import java.sql.*;

public class DataBaseConnection {
	
	public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String dbURL = "jdbc:sqlserver://192.168.10.53\\MSSQLSERVER1;	DatabaseName = aidaijiaNew";
	public static String userName = "un_adj";
	public static String userPwd = "123.com";
	public static Connection Conn;
	public static PreparedStatement preSta = null;
	public static Statement st = null;
	public static ResultSet rs = null;
	
	public static  Connection ConnDb() throws Exception
	{		
		//建立数据库链接，并执行sql查询
		Class.forName(driverName);
		Conn = DriverManager.getConnection(dbURL, userName, userPwd);
		
		return Conn;
	}
	
	public static int ConnCheckState(String orderId) throws Exception
	{	
		//建立数据库链接，并执行sql查询
		Class.forName(driverName);
		Conn = DriverManager.getConnection(dbURL, userName, userPwd);	
		
		String sqlState ="select state from advance_order where order_id ="+ "\'"+orderId+"\'";
		 
		PreparedStatement preSta = Conn.prepareStatement(sqlState.toString());
		
		ResultSet rs = preSta.executeQuery();
		if("".equals(rs)||rs==null)
		{
			throw new Exception("数据为空");
		}
		rs.next();		 
		int state = rs.getInt("state");
		
		rs.close();
		preSta.close();
		Conn.close();
		
		return state;
	}
	
	public static void UpdateDatabase(String sql) throws Exception
	{		
		
		try
		{
		//建立数据库链接，并执行sql查询
		Class.forName(driverName);
		Conn = DriverManager.getConnection(dbURL, userName, userPwd);	
		
		//PreparedStatement preSta = dbConn.prepareStatement(sql.toString());
		st = Conn.createStatement();	//得到运行环境
		st.executeUpdate(sql);		//执行sql
		//rs.next();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			st.close();
			Conn.close();			
		}
	}
	
	
/*	
	public void testSelect() throws Exception{
        //注册驱动(数据库的类型)
        
         * 这种方式存在的问题：
         * 1. 依赖于jar包
         * 2. 导致驱动com.mysql.jdbc.Driver注册两次
         
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //实际开发，应该采用下面的方式注册驱动  --> Java反射
        Class.forName("com.mysql.jdbc.Driver");
 
        //获取连接
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, user, password);
 
        //得到运行环境
        Statement st = conn.createStatement();
 
        //执行SQL
        String sql = "select * from myuser";
        ResultSet rs = st.executeQuery(sql);
 
        //处理结果
        while(rs.next()){
            //每次循环，都取出一条记录
            int userID = rs.getInt("userID");
            String name = rs.getString("userName");
            String userPass = rs.getString("userPass");
            String email = rs.getString("email");
            Date birthday = rs.getDate("birthday");
             
            System.out.println(userID);
            System.out.println(name);
            System.out.println(userPass);
            System.out.println(email);
            System.out.println(birthday);
            System.out.println("*********************");
        }
 
        //释放资源
        rs.close();
        st.close();
        conn.close();
    }
 
   
    public void testInsert(){
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "password";
         
        Connection conn = null;
        Statement st = null;
         
        try{
            //注册驱动(数据库的类型)
            Class.forName("com.mysql.jdbc.Driver");
     
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
             
            //得到运行环境
            st = conn.createStatement();
     
            //执行SQL
            String sql = "insert into myuser(userID,userName) values("+5+",'Tom'"+")";
            System.out.println("sql="+sql);
            int result = st.executeUpdate(sql);
     
            //处理结果
            if(result>0){
                System.out.println("操作成功");
            }else{
                System.out.println("操作失败");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            //释放资源
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    st = null;//--> 让他迅速成为java gc的对象
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    conn = null;//--> 让他迅速成为java gc的对象
                }
            }
        }
 
    }
     
 
    public void testUpate(){
        String sql = "update myuser set username='Tom_AB' where userID=4";
         
        Connection conn = null;
        Statement st = null;
        try {
            //从工具类中获取连接
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            int result = st.executeUpdate(sql);
            //处理结果
            if(result>0){
                System.out.println("操作成功");
            }else{
                System.out.println("操作失败");
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //调用工具类释放资源
            JDBCUtils.release(conn, st, null);
        }
 
    }
     
  
    public void testDelete(){
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "password";
         
        Connection conn = null;
        Statement st = null;
         
        try{
            //注册驱动(数据库的类型)
            Class.forName("com.mysql.jdbc.Driver");
     
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
             
            //得到运行环境
            st = conn.createStatement();
     
            //执行SQL
            String sql = "delete from myuser where userID=5";
            System.out.println("sql="+sql);
            int result = st.executeUpdate(sql);
     
            //处理结果
            if(result>0){
                System.out.println("操作成功");
            }else{
                System.out.println("操作失败");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            //释放资源
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    st = null;//--> 让他迅速成为java gc的对象
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    conn = null;//--> 让他迅速成为java gc的对象
                }
            }
        }
 
    }*/

	
}
