package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThreadToMysql extends Thread {
	public String teacherName;
	public String password;
	public ThreadToMysql(String teacherName, String password) {//构造函数传入要查询登录的老师姓名和密码
		
		this.teacherName=teacherName;
		this.password=password;
	}
	
	public void run() {
		 String url = "jdbc:mysql://127.0.0.1/teacher";  
		 String name = "com.mysql.jdbc.Driver";  
		 String user = "root";  
		 String password = "123456";  
		Connection conn = null;  
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);//获取连接  
			conn.setAutoCommit(false);//关闭自动提交，不然conn.commit()运行到这句会报错
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn!=null) {
		    Long startTime=System.currentTimeMillis();//开始时间
			String sql="select id from t_teacher where t_name='"+teacherName+"' and t_password='"+password+"'";//SQL语句
			String id=null;
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);//获取结果集
				if (rs.next()) {
					id=rs.getString("id");
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


