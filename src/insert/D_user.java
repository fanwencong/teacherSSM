package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class D_user extends Thread {
	public String id;
	public String password;
	public D_user(String id) {
		this.id=id;
	}
	
	public void run() {
		 String url = "jdbc:mysql://127.0.0.1/d_user";  
		 String name = "com.mysql.jdbc.Driver";  
		 String user = "root";  
		 String password = "123456";  
		Connection conn = null;  
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);//获取连接  
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn!=null) {
		    Long startTime=System.currentTimeMillis();
			String sql="select user_id from d_user where user_id="+id;
			String id=null;
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				if (rs.next()) {
					id=rs.getString("user_id");
				}
				conn.commit();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			    Long end=System.currentTimeMillis();
			    System.out.println(currentThread().getName()+"  查询结果:"+id+"   开始时间:"+startTime+"  结束时间:"+end+"  用时:"+(end-startTime)+"ms");
			
			
		} else {
			System.out.println(currentThread().getName()+"数据库连接失败:");
		}
	}
	
}


