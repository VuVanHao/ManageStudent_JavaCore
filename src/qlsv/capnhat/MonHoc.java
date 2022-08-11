package qlsv.capnhat;

public class MonHoc {

	private String maMH;
	private String tenMH;
	private double heSo;
	
	public void display()
	{
		System.out.printf("%-10s %-20s %10f%n",maMH,tenMH,heSo);
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public double getHeSo() {
		return heSo;
	}
	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}
	public MonHoc(String maMH, String tenMH, double heSo) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.heSo = heSo;
	}
	public MonHoc() {
		super();
	}
	
	
}
