package qlsv.capnhat;

import java.util.ArrayList;
import java.util.Scanner;

public class QLDiem {

	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<Diem> list = new ArrayList<Diem>();
	
	public static void KhoiTao()
	{
		list.add(new Diem(102, "A", 7));
		list.add(new Diem(102, "C", 10));
		list.add(new Diem(103, "B", 9));
		list.add(new Diem(104, "E", 8));
		list.add(new Diem(104, "A", 7));
		list.add(new Diem(101, "D", 6));
	}
	
	public static void quanliDiem()
	{
		int chon = -1;
		do
		{
			System.out.println("--------CAP NHAT DIEM------");
			System.out.println("Lua chon chuc nang cap nhat diem");
			System.out.println("\t1.Them diem cua mot sinh vien hoc mot mon hoc");
			System.out.println("\t2.Xem danh sach diem cua sinh vien");
			System.out.println("\t3.Sua diem mot mon hoc cua mot sinh vien");
			System.out.println("\t4.Xoa diem mot mon hoc cua mot sinh vien ");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban ");
			
			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (chon) {
			case 1:
				themDiemChoSinhVien();
				break;
			case 2:
				XemDs();
				break;
			case 3:
				suaDiemChoSinhVien();
				break;
			case 4:
				xoaDiemChoSinhVien();
				break;
			case 0:
				return;
			default: System.out.println("Lua chon khong hop le !!!");
			}
		}while(true);
	}

	private static void themDiemChoSinhVien() {
		System.out.println("----------THEM DIEM CHO SINH VIEN-------");
		int maSV = 0;
		System.out.print("Nhap ma sinh vien : ");
		maSV = Integer.parseInt(sc.nextLine());
		if(maSV <= 0)
		{
			System.out.println("\tMa sinh vien phai lon hon 0");
			return;
		}
		int index = QLSinhVien.indexOfSinhVien(maSV);
		if(index == -1)
		{
			System.out.println("\tMa sinh vien can them khong co trong danh sach");
			return;
		}
		System.out.print("Nhap ma mon hoc : ");
		String maMH = sc.nextLine();
		if(maMH.trim().length() == 0)
		{
			System.out.println("\tMa mon khong duoc de trong !");
			return;
		}
		int index1 = QLMonHoc.indexOfMonHoc(maMH);
		if(index1 == -1)
		{
			System.out.println("\tMa mon hoc yeu cau khong co troong danh sach !");
			return;
		}
		int index2 = indexOfSV_Mon(maSV, maMH);
		if(index2 != -1)
		{
			System.out.println("\tSinh vien hoc mon nay da duoc nhap diem !");
			return;
		}
		
		System.out.print("Nhap diem : ");
		double diem = Double.parseDouble(sc.nextLine());
		if(diem < 0 || diem > 10)
		{
			System.out.println("\tDiem nhap vao khong hop le ! ");
			return;
		}
		
		Diem d = new Diem(maSV, maMH, diem);
		list.add(d);
		System.out.println("\tThem diem cho sinh vien thanh cong !");
	}

	private static void XemDs() {
		System.out.println("-------DANH SACH DIEM--------");
		System.out.printf("%6s %-10s %-4s%n","Ma SV","Ma MH","Diem");
		for(Diem x : list)
		{
			x.display();
		}
		
	}

	private static void suaDiemChoSinhVien() {
		System.out.println("----------SUA DIEM CHO SINH VIEN THEO HOC----------");
		System.out.println("Nhap ma sinh vien : ");
		int maSV = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap ma mon hoc : ");
		String maMH = sc.nextLine();
		int index = indexOfSV_Mon(maSV, maMH);
		if(index == -1)
		{
			System.out.println("\tKhong ton tai sinh vien hoc mon nay ! ");
			return;
		}
		System.out.println("Nhap diem moi : ");
		double diem = Double.parseDouble(sc.nextLine());
		list.get(index).setDiem(diem);
		System.out.println("Sua diem thanh cong ! ");
		
	}

	private static void xoaDiemChoSinhVien() {
		System.out.println("----------XOA DIEM CHO SINH VIEN THEO HOC----------");
		System.out.print("Nhap ma sinh vien : ");
		int maSV = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap ma mon hoc : ");
		String maMH = sc.nextLine();
		int index = indexOfSV_Mon(maSV, maMH);
		if(index == -1)
		{
			System.out.println("\tKhong ton tai sinh vien hoc mon nay ! ");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa thong tin thanh cong");
		
	}
	
	//Ham nhan vao ma sinh vien va ma mon, tra lai thong tin da ton tai ma sinh vien va
	// va mon mon trong danh sachs ? 
	public static int indexOfSV_Mon(int id_Sv, String id_Mon)
	{
		for(int index = 0;index < list.size();index++)
		{
			if(list.get(index).getMaSV() == id_Sv 
					&& list.get(index).getMaMH().compareToIgnoreCase(id_Mon) == 0)
			{
				return index;
			}
		}
		return -1;
	}
}
