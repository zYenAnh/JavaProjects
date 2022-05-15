package dataaccessobject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import database.JDBCUtil;
import model.Province;
import model.Student;

public class studentDAO implements DAOInterface<Student> {

	public static studentDAO getInstance() {
		return new studentDAO();
	}
	
	@Override
	public int add(Student t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO sinhvien(id,name,dateofbirth,province,sex,diemtoan,diemly,diemhoa) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setInt(1, t.getMaSinhVienInt());
			pst.setString(2, t.getTenSinhVienString());
			pst.setDate(3, (Date) t.getNgaySinhDate());
			pst.setString(4, t.getQueQuanProvince().getTenTinhString());
			pst.setInt(5, t.isGioiTinh()?1:0);
			pst.setFloat(6, t.getDiemToan());
			pst.setFloat(7, t.getDiemLy());
			pst.setFloat(8, t.getDiemHoa());
			
			result = pst.executeUpdate();
			JDBCUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(Student t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "UPDATE sinhvien "
					+ " SET " 
					+ " name = ?"
					+ ", dateofbirth = ?"
					+ ", province = ?"
					+ ", sex = ?"
					+ ", diemtoan = ?"
					+ ", diemly = ?"
					+ ", diemhoa = ?"
					+ " WHERE id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, t.getTenSinhVienString());
			pst.setDate(2, (Date) t.getNgaySinhDate());
			pst.setString(3, t.getQueQuanProvince().getTenTinhString());
			pst.setInt(4, t.isGioiTinh()?1:0);
			pst.setFloat(5, t.getDiemToan());
			pst.setFloat(6, t.getDiemLy());
			pst.setFloat(7, t.getDiemHoa());
			pst.setInt(8, t.getMaSinhVienInt());
			
			result = pst.executeUpdate();
			JDBCUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(Student t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "DELETE FROM sinhvien "
					+ " WHERE id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setInt(1, t.getMaSinhVienInt());
			
			result = pst.executeUpdate();
			JDBCUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<Student> selectAll() {
		ArrayList<Student> resultList = new ArrayList<Student>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sinhvien";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date dateOfBirth = rs.getDate("dateofbirth");
				Province province = Province.getTinhByName(rs.getString("province"));
				boolean isGioiTinh = (rs.getInt("sex")==1?true:false);
				float diemToan = rs.getFloat("diemtoan");
				float diemLy = rs.getFloat("diemly");
				float diemHoa = rs.getFloat("diemHoa");
				
				Student t = new Student(id,name,province,dateOfBirth,isGioiTinh,diemToan,diemHoa,diemLy);
				
				resultList.add(t);
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Student selectById(Student t) {
		Student result = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sinhvien "
					+ "WHERE id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setInt(1, t.getMaSinhVienInt());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date dateOfBirth = rs.getDate("dateofbirth");
				Province province = Province.getTinhByName(rs.getString("province"));
				boolean isGioiTinh = (rs.getInt("sex")==1?true:false);
				float diemToan = rs.getFloat("diemtoan");
				float diemLy = rs.getFloat("diemly");
				float diemHoa = rs.getFloat("diemHoa");
				
				result = new Student(id,name,province,dateOfBirth,isGioiTinh,diemToan,diemHoa,diemLy);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Student> selectByCondition(String condition) {
		ArrayList<Student> resultList = new ArrayList<Student>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sinhvien WHERE " + condition;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date dateOfBirth = rs.getDate("dateofbirth");
				Province province = Province.getTinhByName(rs.getString("province"));
				boolean isGioiTinh = (rs.getInt("sex")==1?true:false);
				float diemToan = rs.getFloat("diemtoan");
				float diemLy = rs.getFloat("diemly");
				float diemHoa = rs.getFloat("diemHoa");
				
				Student t = new Student(id,name,province,dateOfBirth,isGioiTinh,diemToan,diemHoa,diemLy);
				
				resultList.add(t);
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
