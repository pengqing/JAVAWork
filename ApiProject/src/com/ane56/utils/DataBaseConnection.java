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
		//�������ݿ����ӣ���ִ��sql��ѯ
		Class.forName(driverName);
		Conn = DriverManager.getConnection(dbURL, userName, userPwd);
		
		return Conn;
	}
	
	public static int ConnCheckState(String orderId) throws Exception
	{	
		//�������ݿ����ӣ���ִ��sql��ѯ
		Class.forName(driverName);
		Conn = DriverManager.getConnection(dbURL, userName, userPwd);	
		
		String sqlState ="select state from advance_order where order_id ="+ "\'"+orderId+"\'";
		 
		PreparedStatement preSta = Conn.prepareStatement(sqlState.toString());
		
		ResultSet rs = preSta.executeQuery();
		if("".equals(rs)||rs==null)
		{
			throw new Exception("����Ϊ��");
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
		//�������ݿ����ӣ���ִ��sql��ѯ
		Class.forName(driverName);
		Conn = DriverManager.getConnection(dbURL, userName, userPwd);	
		
		//PreparedStatement preSta = dbConn.prepareStatement(sql.toString());
		st = Conn.createStatement();	//�õ����л���
		st.executeUpdate(sql);		//ִ��sql
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
        //ע������(���ݿ������)
        
         * ���ַ�ʽ���ڵ����⣺
         * 1. ������jar��
         * 2. ��������com.mysql.jdbc.Driverע������
         
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //ʵ�ʿ�����Ӧ�ò�������ķ�ʽע������  --> Java����
        Class.forName("com.mysql.jdbc.Driver");
 
        //��ȡ����
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, user, password);
 
        //�õ����л���
        Statement st = conn.createStatement();
 
        //ִ��SQL
        String sql = "select * from myuser";
        ResultSet rs = st.executeQuery(sql);
 
        //������
        while(rs.next()){
            //ÿ��ѭ������ȡ��һ����¼
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
 
        //�ͷ���Դ
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
            //ע������(���ݿ������)
            Class.forName("com.mysql.jdbc.Driver");
     
            //��ȡ����
            conn = DriverManager.getConnection(url, user, password);
             
            //�õ����л���
            st = conn.createStatement();
     
            //ִ��SQL
            String sql = "insert into myuser(userID,userName) values("+5+",'Tom'"+")";
            System.out.println("sql="+sql);
            int result = st.executeUpdate(sql);
     
            //������
            if(result>0){
                System.out.println("�����ɹ�");
            }else{
                System.out.println("����ʧ��");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            //�ͷ���Դ
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    st = null;//--> ����Ѹ�ٳ�Ϊjava gc�Ķ���
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    conn = null;//--> ����Ѹ�ٳ�Ϊjava gc�Ķ���
                }
            }
        }
 
    }
     
 
    public void testUpate(){
        String sql = "update myuser set username='Tom_AB' where userID=4";
         
        Connection conn = null;
        Statement st = null;
        try {
            //�ӹ������л�ȡ����
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            int result = st.executeUpdate(sql);
            //������
            if(result>0){
                System.out.println("�����ɹ�");
            }else{
                System.out.println("����ʧ��");
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //���ù������ͷ���Դ
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
            //ע������(���ݿ������)
            Class.forName("com.mysql.jdbc.Driver");
     
            //��ȡ����
            conn = DriverManager.getConnection(url, user, password);
             
            //�õ����л���
            st = conn.createStatement();
     
            //ִ��SQL
            String sql = "delete from myuser where userID=5";
            System.out.println("sql="+sql);
            int result = st.executeUpdate(sql);
     
            //������
            if(result>0){
                System.out.println("�����ɹ�");
            }else{
                System.out.println("����ʧ��");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            //�ͷ���Դ
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    st = null;//--> ����Ѹ�ٳ�Ϊjava gc�Ķ���
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    conn = null;//--> ����Ѹ�ٳ�Ϊjava gc�Ķ���
                }
            }
        }
 
    }*/

	
}
