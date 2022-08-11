package qlsv.capnhat;

public class SinhVien {
	private int maSV;
	private String hoDem;
	private String ten;
	private int namSinh;
	private String gender;
	
	public void display()
	{
		System.out.printf("%10d %-15s %-10s %10d %-15s%n",maSV,hoDem,ten,namSinh,gender);
	}
	public SinhVien(int maSV, String hoDem, String ten, int namSinh, String gender) {
		super();
		this.maSV = maSV;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gender = gender;
	}
	public SinhVien() {
		super();
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getGioiTinh() {
		return gender;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gender = gioiTinh;
	}
	
	
}
