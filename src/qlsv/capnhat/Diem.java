package qlsv.capnhat;

public class Diem {
	private int maSV;
	private String maMH;
	private double diem;
	
	public void display()
	{
		System.out.printf("%6d %-10s %4.1f%n",maSV,maMH,diem);
	}
	public Diem(int maSV, String maMH, double diem) {
		super();
		this.maSV = maSV;
		this.maMH = maMH;
		this.diem = diem;
	}
	public Diem() {
		super();
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	
	
}
