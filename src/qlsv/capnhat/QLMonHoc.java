package qlsv.capnhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;




public class QLMonHoc {

	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<MonHoc> list = new ArrayList<MonHoc>();
	
	public static void KhoiTao() {
		list.add(new MonHoc("A", "Java", 3));
		list.add(new MonHoc("B", "PHP", 2));
		list.add(new MonHoc("C", "CSharp", 4));
		list.add(new MonHoc("D", "C/C++", 6));
		list.add(new MonHoc("E", "Python", 2));
	}
	
	public static void quanliMonHoc() {
		int chon = -1;
		do
		{
			System.out.println("---------CAP NHAT THONG TIN MON HOC--------");
			System.out.println("Lua chon chuc nang cap nhat mon hoc");
			System.out.println("\t1.Them mon hoc vao danh sach");
			System.out.println("\t2.Xem danh sach mon hoc");
			System.out.println("\t3.Sua thong tin mon hoc ");
			System.out.println("\t4.Xoa thong tin mon hoc");
			System.out.println("\t5.Sap xep danh sach mon hoc");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban ");
			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (chon) {
			case 1:
				themMoiMonHoc();
				break;
			case 2:
				xemDsMonHoc();
				break;
			case 3:
				suaMonHoc();
				break;
			case 4:
				xoaMonHoc();
				break;
			case 5:
				sapXep();
				break;
			case 0:
				return;
			default: System.out.println("Lua chon khong hop le !!!");
			}
		}while(true);
	}

	private static void themMoiMonHoc() {
		System.out.println("-----------THEM MOI MON HOC----------");
		System.out.print("Nhap ma mon hoc : ");
		String maMH = sc.nextLine();
		if(maMH.trim().length() == 0)
		{
			System.out.println("\tMa mon hoc khong duoc de trong !");
			return;
		}
		int index = indexOfMonHoc(maMH);
		if(index != -1)
		{
			System.out.println("\tDa ton tai mon hoc nay trong danh sach mon hoc");
			System.out.println("\tKhong the tiep tuc !");
			return;
		}
		System.out.print("Nhap ten mon hoc : ");
		String ten = sc.nextLine();
		if(ten.trim().length() == 0)
		{
			System.out.println("\tTen mon hoc khong duoc de trong !");
			return;
		}
		System.out.print("Nhap he so mon hoc : ");
		double hs = 0;
		hs = Double.parseDouble(sc.nextLine());
		if(hs <= 0 )
		{
			System.out.println("\tHe so mon hoc khong duoc am !");
			return;
		}
		MonHoc mh = new MonHoc(maMH, ten, hs);
		list.add(mh);
	}

	private static void xemDsMonHoc() {
		System.out.println("--------DANH SACH MON HOC----------");
		System.out.printf("%-10s %-20s %10s%n","Ma MH","Ten MH","He So Mon");
		for(MonHoc x : list)
		{
			x.display();
		}
		
	}

	private static void suaMonHoc() {
		System.out.println("---------SUA THONG TIN MON HOC--------------");
		System.out.print("Nhap ma mon hoc can sua : ");
		String ma = sc.nextLine();
		int index = indexOfMonHoc(ma);
		if(index == -1)
		{
			System.out.println("Khong co sinh vien can sua trong danh sach ");
			return;
		}
		int chon = -1;
		do
		{
			System.out.println("Chon noi dung can sua : ");
			System.out.println("\t1. Sua ten mon hoc");
			System.out.println("\t2. Sua he so mon hoc");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban : ");
			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("loi " + e.getMessage());
			}
			switch (chon) {
			case 1:
				suaTen(index);
				break;
			case 2:
				suaHS(index);
				break;
			case 0 :
				return;
			default: System.out.println("Lua chon khong hop le !!!");
			}
		}while(true);
		
		
	}

	private static void suaHS(int index) {
		System.out.print("Nhap he so mon hoc moi : ");
		Double hs = Double.parseDouble(sc.nextLine());
		if(hs <= 0)
		{
			System.out.println("\tHe so mon hoc khong duoc nho hon 0 !! ");
			return;
		}
		list.get(index).setHeSo(hs);
		System.out.println("Sua he so mon hoc thanh cong !!! ");
	}

	private static void suaTen(int index) {
		System.out.print("Nhap ten mon hoc moi : ");
		String ten = sc.nextLine();
		if(ten.trim().length() == 0)
		{
			System.out.println("\tten mon hoc khong duoc de trong !! ");
			return;
		}
		list.get(index).setTenMH(ten);
		System.out.println("Sua ten mon hoc thanh cong !!! ");
	}

	private static void xoaMonHoc() {
		System.out.println("-----------XOA THONG TIN MON HOC----------");
		System.out.print("Nhap ma mon hoc : ");
		String maMH = sc.nextLine();
		if(maMH.trim().length() == 0)
		{
			System.out.println("\tMa mon hoc khong duoc de trong !");
			return;
		}
		int index = indexOfMonHoc(maMH);
		if(index != -1)
		{
			System.out.println("\tDa ton tai mon hoc nay trong danh sach mon hoc");
			System.out.println("\tKhong the tiep tuc !");
			return;
		}
		int i = 0;
		while ( i < QLDiem.list.size() && QLDiem.list.get(i).getMaMH().compareToIgnoreCase(maMH) != 0) {
			i++;
		}
		if (i < QLDiem.list.size()) {
			System.out.println("\tSinh vien da hoc, khong the xoa");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa thanh cong");
		
	}

	private static void sapXep() {
		Collections.sort(list,new Comparator<MonHoc>() {

			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				// TODO Auto-generated method stub
				return o1.getTenMH().compareToIgnoreCase(o2.getTenMH());
			}
		});
	}
	
	//ham nhan vao ma mon hoc vaa kiem tra co ton tai khong
	public static int indexOfMonHoc(String maMH) {
		for(int index = 0; index < list.size();index++)
		{
			if(list.get(index).getMaMH().equalsIgnoreCase(maMH))
			{
				return index;
			}
		}
		return -1;
	}
	
	//Ham nhan vao ma mon hoc va tra ve he so cua mon do
	public static double getHeSoMon(String maMh) {
		
		for (MonHoc x : list) {
			if (x.getMaMH().compareToIgnoreCase(maMh) == 0) {
				return x.getHeSo();
			}
		}
		return -1;
	}
}
