package model;

import java.util.ArrayList;
import java.util.Date;

public class QLSVModel {
	private ArrayList<Student> dsSinhVien;
	
	public QLSVModel() {
		dsSinhVien = new ArrayList<Student>();
		dsSinhVien.add(new Student(2020772,"Bùi Thiện"
				,Province.getTinhByName("Nghệ An"),new Date(2001,6,17),true,10,10,10));
		dsSinhVien.add(new Student(2020773,"Yến Anh"
				,Province.getTinhByName("Đắk Lắk"),new Date(2003,4,20),false,8,10,9));
		dsSinhVien.add(new Student(2020774,"Vân Chi"
				,Province.getTinhByName("Đắk Lắk"),new Date(2002,4,1),false,10,10,9));
		dsSinhVien.add(new Student(2020775,"Tiểu Trang"
				,Province.getTinhByName("Đắk Lắk"),new Date(2002,07,06),true,10,9,9));
		dsSinhVien.add(new Student(2020776,"Quế Anh"
				,Province.getTinhByName("Đắk Lắk"),new Date(2002,03,26),false,8,9,10));
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
		this.dsSinhVien.remove(student);
	}
	
	public void update(Student student) {
		for(Student st : this.dsSinhVien) {
			if(st.getMaSinhVienInt()==student.getMaSinhVienInt()) {
				remove(student);
			}
		}
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
