package MySQL;

import java.sql.*;

public class GetConnection {

	public static void main(String[] args) throws InterruptedException {
		try {
//			Class.forName("driverClass");            //������������
//			Class.forName("oracle.jdbc.driver.OracleDriver");  //����������Oracle����
			
			
			Class.forName("com.mysql.jdbc.Driver");  //��������MySQL������
			System.out.println("�ɹ�����MySQL����");
			System.out.println("---------------------------------------------------------------------------------------------------");
		}catch(ClassNotFoundException e){
			System.out.println("�Ҳ���MySQL����");
			e.printStackTrace();
			System.out.println("---------------------------------------------------------------------------------------------------");
		}
		String url = "jdbc:mysql://localhost:3306/test";  //���ݿ��ַ
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, "root", "123456");  //������ݿ�����
			Statement stmt = conn.createStatement();  //����Statement����
		
			String sql = "SELECT * FROM information WHERE `����` = '����';";
//			String sql1 = "select * from information where '��������'='1988-12-05'";
			ResultSet rs = stmt.executeQuery(sql);
//			ResultSet rs1 = stmt.executeQuery(sql1);
			while(rs.next()) {
//				System.out.println(rs.getString("ID")+","+rs.getString("grade")+","+rs.getString("class")+","+rs.getString("sname")+","+rs.getString("TYnumber")+","+rs.getString("ICCID")
//				+","+rs.getString("NONUMBER"));
				System.out.println(rs.getString("����")+","+rs.getString("�Ա�")+","+rs.getString("��������")+","+rs.getString("�꼶")+","+rs.getString("�༶")+","+rs.getString("��ͥ��ַ")
				+","+rs.getString("���֤"));
				Thread.sleep(1);
//				System.out.println(rs.getString("��������"));
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
