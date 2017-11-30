package MySQL;

import java.sql.*;

public class GetConnection {

	public static void main(String[] args) throws InterruptedException {
		try {
//			Class.forName("driverClass");            //加载驱动程序
//			Class.forName("oracle.jdbc.driver.OracleDriver");  //加载数据区Oracle驱动
			
			
			Class.forName("com.mysql.jdbc.Driver");  //加载数据MySQL库驱动
			System.out.println("成功加载MySQL驱动");
			System.out.println("---------------------------------------------------------------------------------------------------");
		}catch(ClassNotFoundException e){
			System.out.println("找不到MySQL驱动");
			e.printStackTrace();
			System.out.println("---------------------------------------------------------------------------------------------------");
		}
		String url = "jdbc:mysql://localhost:3306/test";  //数据库地址
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, "root", "123456");  //获得数据库链接
			Statement stmt = conn.createStatement();  //创建Statement对象
		
			String sql = "SELECT * FROM information WHERE `姓名` = '张四';";
//			String sql1 = "select * from information where '出生日期'='1988-12-05'";
			ResultSet rs = stmt.executeQuery(sql);
//			ResultSet rs1 = stmt.executeQuery(sql1);
			while(rs.next()) {
//				System.out.println(rs.getString("ID")+","+rs.getString("grade")+","+rs.getString("class")+","+rs.getString("sname")+","+rs.getString("TYnumber")+","+rs.getString("ICCID")
//				+","+rs.getString("NONUMBER"));
				System.out.println(rs.getString("姓名")+","+rs.getString("性别")+","+rs.getString("出生日期")+","+rs.getString("年级")+","+rs.getString("班级")+","+rs.getString("家庭地址")
				+","+rs.getString("身份证"));
				Thread.sleep(1);
//				System.out.println(rs.getString("出生日期"));
			}
			System.out.println("---------------------------------------------------------------------------------------------------");
			stmt.close();
			conn.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("---------------------------------------------------------------------------------------------------");
		}
	}
}
