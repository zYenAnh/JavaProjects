package model;

import java.util.ArrayList;
import java.util.Date;

import dataaccessobject.studentDAO;

public class QLSVModel {
	private ArrayList<Student> dsSinhVien;
	
	public QLSVModel() {
		this.dsSinhVien = new ArrayList<Student>();
		this.dsSinhVien = studentDAO.getInstance().selectAll();
	}
	
	public QLSVModel(ArrayList<Student> dsSinhVien) {
		super();
		this.dsSinhVien = dsSinhVien;
	}

	public ArrayList<Student> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<Student> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	
	public void insert(Student student) {
		this.dsSinhVien.add(student);
	}
	
	public void remove(Student student) {
		int i;
		for(i=0;i<this.dsSinhVien.size();i++) {
			if(this.dsSinhVien.get(i).getMaSinhVienInt()==student.getMaSinhVienInt())
				break;
		}
		this.dsSinhVien.remove(i);
	}
	
	public void update(Student student) {
		int i;
		for(i=0;i<this.dsSinhVien.size();i++) {
			if(this.dsSinhVien.get(i).getMaSinhVienInt()==student.getMaSinhVienInt())
				break;
		}
		this.dsSinhVien.remove(i);
		this.dsSinhVien.add(student);
	}

	public boolean kiemTraStudentTonTai(Student st) {
		for(Student student: this.dsSinhVien) {
			if(student.getMaSinhVienInt() == st.getMaSinhVienInt())
				return true;
		}
		return false;
	}
}
