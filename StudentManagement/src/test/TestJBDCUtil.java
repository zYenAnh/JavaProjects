package test;

import java.sql.Connection;

import com.mysql.cj.xdevapi.Statement;

import database.JBDCUtil;

public class TestJBDCUtil {
	public static void main(String[] args) {
		try {
			Connection connection = JBDCUtil.getConnection();
			java.sql.Statement st = connection.createStatement();
			String sqlString = "INSERT INTO sinhvien(id,name,dateofbirth,province,sex,diemtoan,diemly,diemhoa)\r\n"
					+ "VALUES (2,\"Yen Anh\",\"2001-06-17\",\"Nghe An\",1,10,10,10)";
			
			int check = st.executeUpdate(sqlString);
			System.out.println("So dong thay doi: " + check);
			if(check>0)
				System.out.println("them du lieu thanh cong");
			else 
				System.out.println("them that bai");
			// Ngắt
			JBDCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
