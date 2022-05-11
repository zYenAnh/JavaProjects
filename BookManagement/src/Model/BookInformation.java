package Model;

public class BookInformation {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private String nhaXuatBan;
	private Long giaSach;
	
	public BookInformation() {}
	
	public BookInformation(String maSach, String tenSach, String tacGia, String nhaXuatBan, Long giaSach) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.giaSach = giaSach;
	}

	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	public Long getGiaSach() {
		return giaSach;
	}
	public void setGiaSach(Long giaSach) {
		this.giaSach = giaSach;
	}
	
	
}
