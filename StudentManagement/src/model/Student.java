package model;

import java.util.Date;
import java.util.Objects;

public class Student {
	private int maSinhVienInt;
	private String tenSinhVienString;
	private Province queQuanProvince;
	private Date ngaySinhDate;
	private boolean gioiTinh;
	private float diemToan,diemLy,diemHoa;
	
	public Student() {
	}

	public Student(int maSinhVienInt, String tenSinhVienString, Province queQuanProvince, Date ngaySinhDate,
			boolean gioiTinh, float diemToan, float diemLy, float diemHoa) {
		super();
		this.maSinhVienInt = maSinhVienInt;
		this.tenSinhVienString = tenSinhVienString;
		this.queQuanProvince = queQuanProvince;
		this.ngaySinhDate = ngaySinhDate;
		this.gioiTinh = gioiTinh;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}

	public int getMaSinhVienInt() {
		return maSinhVienInt;
	}

	public void setMaSinhVienInt(int maSinhVienInt) {
		this.maSinhVienInt = maSinhVienInt;
	}

	public String getTenSinhVienString() {
		return tenSinhVienString;
	}

	public void setTenSinhVienString(String tenSinhVienString) {
		this.tenSinhVienString = tenSinhVienString;
	}

	public Province getQueQuanProvince() {
		return queQuanProvince;
	}

	public void setQueQuanProvince(Province queQuanProvince) {
		this.queQuanProvince = queQuanProvince;
	}

	public Date getNgaySinhDate() {
		return ngaySinhDate;
	}

	public void setNgaySinhDate(Date ngaySinhDate) {
		this.ngaySinhDate = ngaySinhDate;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}

	public float getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}

	@Override
	public String toString() {
		return "Student [maSinhVienInt=" + maSinhVienInt + ", tenSinhVienString=" + tenSinhVienString
				+ ", queQuanProvince=" + queQuanProvince + ", ngaySinhDate=" + ngaySinhDate + ", gioiTinh=" + gioiTinh
				+ ", diemToan=" + diemToan + ", diemLy=" + diemLy + ", diemHoa=" + diemHoa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diemHoa, diemLy, diemToan, gioiTinh, maSinhVienInt, ngaySinhDate, queQuanProvince,
				tenSinhVienString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Float.floatToIntBits(diemHoa) == Float.floatToIntBits(other.diemHoa)
				&& Float.floatToIntBits(diemLy) == Float.floatToIntBits(other.diemLy)
				&& Float.floatToIntBits(diemToan) == Float.floatToIntBits(other.diemToan) && gioiTinh == other.gioiTinh
				&& maSinhVienInt == other.maSinhVienInt && Objects.equals(ngaySinhDate, other.ngaySinhDate)
				&& Objects.equals(queQuanProvince, other.queQuanProvince)
				&& Objects.equals(tenSinhVienString, other.tenSinhVienString);
	}
	
	
}
