package test;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import dataaccessobject.studentDAO;
import database.JDBCUtil;
import model.Province;
import model.Student;

public class TestJBDCUtil {
	public static void main(String[] args) {
		Student tStudent = new Student(2,"Hồng Ánh",Province.getTinhByName("Hà Tĩnh"),new Date(2003,6,17),true,9,10,8);
		ArrayList<Student> arrayList = studentDAO.getInstance().selectByCondition("province = 'Nghệ An'");
		for(Student st: arrayList) {
			System.out.println(st);
		}
		
	}
}
