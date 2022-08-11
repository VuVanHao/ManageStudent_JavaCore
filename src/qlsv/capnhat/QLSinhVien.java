package qlsv.capnhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class QLSinhVien {

	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<SinhVien> list = new ArrayList<SinhVien>();
	
	static int autoId = 101;
	
	public static void KhoiTao()
	{
		list.add(new SinhVien(autoId++, "Vu Van", "Hao", 2001, "Nam"));
		list.add(new SinhVien(autoId++, "Nguyen Thi", "Anh", 2002, "Nu"));
		list.add(new SinhVien(autoId++, "Tran Cong", "Hoan", 2000, "Nam"));
		list.add(new SinhVien(autoId++, "Le Thi ", "Huong", 2003, "Nu"));
		list.add(new SinhVien(autoId++, "Do Linh", "Dan", 2000, "Nu"));
	}
	
	public static void quanliSinhVien()
	{
		int chon = -1;
		do {
			System.out.println("\n----CAP NHAT SINH VIEN---------");
			System.out.println("Lua chon chuc nang cap nhat sinh vien");
			System.out.println("\t1.Them sinh vien vao danh sach");
			System.out.println("\t2.Xem danh sach sinh vien");
			System.out.println("\t3.Sua thong tin sinh vien ");
			System.out.println("\t4.Xoa thong tin sinh vien");
			System.out.println("\t5.Sap xep danh sach sinh vien");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban ");
			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (chon) {
			case 1:
				themMoiSinhVien();
				break;
			case 2:
				XemDsSinhVien();
				break;
			case 3 :
				SuaSinhVien();
				break;
			case 4 : 
				XoaSinhVien();
				break;
			case 5 : 
				SapXep();
				break;
			case 0 :
				return;
			default:
				System.out.println("Lua chon khong hop le !!!");
			}
		}while(true);
	}

	private static void themMoiSinhVien() {
		System.out.println("--------THEM MOI SINH VIEN---------");
		System.out.print("Nhap ho dem : ");
		String hoDem = sc.nextLine();
		if(hoDem.trim().length() == 0)
		{
			System.out.println("\tHo dem khong duoc de trong");
			return;
		}
		System.out.print("Nhap ten : ");
		String ten = sc.nextLine();
		if(ten.trim().length() == 0)
		{
			System.out.println("\tTen sinh vien khong duoc de trong");
			return;
		}
		System.out.print("Nhap nam sinh : ");
		int namsinh = Integer.parseInt(sc.nextLine());
		if(namsinh < 0)
		{
			System.out.println("\tNam sinh khong duoc am");
			return;
		}
		System.out.print("Nhap gioi tinh : ");
		String gender = sc.nextLine();
		if(gender.trim().length() == 0)
		{
			System.out.println("\tGioi tinh khong duoc de trong");
			return;
		}
		//ma sinh vien tu dong tang nen khong the trung.
		SinhVien sv = new SinhVien(autoId++, hoDem, ten, namsinh, gender);
		list.add(sv);
	}

	private static void XemDsSinhVien() {
		System.out.println("------DANH SACH SINH VIEN---------");
		System.out.printf("%10s %-15s %-10s %10s %-15s%n","Ma SV","Ho dem","Ten","Nam Sinh","Gioi tinh");
		for(SinhVien x : list)
		{
			x.display();
		}
	}

	private static void SuaSinhVien() {
		System.out.println("---------SUA THONG TIN SINH VIEN--------------");
		System.out.print("Nhap ma sinh vien can sua");
		int maSV = Integer.parseInt(sc.nextLine());
		int index = indexOfSinhVien(maSV);
		if(index == -1)
		{
			System.out.println("Khong co sinh vien can sua trong danh sach ");
			return;
		}
		int chon = -1;
		do
		{
			System.out.println("Chon noi dung can sua : ");
			System.out.println("\t1. Sua ho dem");
			System.out.println("\t2. Sua ten");
			System.out.println("\t3. Sua nam sinh");
			System.out.println("\t4. Sua gioi tinh");
			System.out.println("\t0. Quay lai");
			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("loi " + e.getMessage());
			}
			switch (chon) {
			case 1:
				suaHoDem(index);
				break;
			case 2:
				suaTen(index);
				break;
			case 3 :
				suaNamSinh(index);
				break;
			case 4 :
				suaGioiTinh(index);
				break;
			case 0 :
				return;
			default: System.out.println("Lua chon khong hop le !!!");
			}
		}while(true);
		
	}

	private static void suaHoDem(int index) {
		System.out.print("Nhap ho dem moi : ");
		String hodem = sc.nextLine();
		if(hodem.trim().length() == 0)
		{
			System.out.println("Ho dem khong duoc de trong !! ");
			return;
		}
		list.get(index).setHoDem(hodem);
		System.out.println("Sua ho dem thanh cong !!! ");
	}

	private static void suaTen(int index) {
		System.out.print("Nhap ten moi : ");
		String ten = sc.nextLine();
		if(ten.trim().length() == 0)
		{
			System.out.println("ten khong duoc de trong !! ");
			return;
		}
		list.get(index).setTen(ten);
		System.out.println("Sua ten thanh cong !!! ");
		
	}

	private static void suaNamSinh(int index) {
		System.out.print("Nhap nam sinh moi : ");
		int namsinh = Integer.parseInt(sc.nextLine());
		if(namsinh < 0)
		{
			System.out.println("Nam sinh khong duoc am !! ");
			return;
		}
		list.get(index).setNamSinh(namsinh);
		System.out.println("Sua nam sinh thanh cong !!! ");
		
	}

	private static void suaGioiTinh(int index) {
		System.out.print("Nhap gioi tinh moi : ");
		String gender = sc.nextLine();
		if(gender.trim().length() == 0)
		{
			System.out.println("Ho dem khong duoc de trong !! ");
			return;
		}
		list.get(index).setGioiTinh(gender);
		System.out.println("Sua gioi tinh thanh cong !!! ");
		
	}

	private static void XoaSinhVien() {
		System.out.println("-----------XOA THONG TIN SINH VIEN----------");
		System.out.print("\tNhap ma sinh vien can xoa : ");
		int maSV = Integer.parseInt(sc.nextLine());
		if(maSV <= 0)
		{
			System.out.println("\tMa sinh vien phai lon hon 0");
			return;
		}
		int indexSinhVien = QLSinhVien.indexOfSinhVien(maSV);
		if(indexSinhVien == -1)
		{
			System.out.println("\tMa sinh vien can them khong co trong danh sach");
			return;
		}
		int i = 0;
		while ( i < QLDiem.list.size() && QLDiem.list.get(i).getMaSV() != maSV) {
			i++;
		}
		if (i < QLDiem.list.size()) {
			System.out.println("\tSinh vien da hoc, khong the xoa");
			return;
		}
		list.remove(indexSinhVien);
		System.out.println("\tXoa thanh cong");
		
		
	}

	private static void SapXep() {
		Collections.sort(list,new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return o1.getTen().compareToIgnoreCase(o2.getTen());
			}
		});
		
	}
	
	//ham nhan vao id va kiem tra xem co sinh vien trong danh sach ?
	public static int indexOfSinhVien(int id) {
		for(int index = 0; index < list.size();index++)
		{
			if(list.get(index).getMaSV() == id)
			{
				return index;
			}
		}
		return -1;
	}
	
	public static void SapXepMaSV()
	{
		Collections.sort(list,new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return o1.getMaSV() - o2.getMaSV();
			}
		});
	}
}
