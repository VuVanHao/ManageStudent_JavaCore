package qlsv.timkiem;

import java.util.Scanner;

import qlsv.capnhat.QLMonHoc;
import qlsv.capnhat.QLSinhVien;
import qlsv.hienthibangdiem.QLBangDiem;

public class QLTimKiem {

	static Scanner sc = new Scanner(System.in);
	
	public static void quanliTimKiem() {
		int chon = -1;
		do
		{
			System.out.println("--------CHUC NANG TIM KIEM--------");
			System.out.println("Lua chon chuc nang tim kiem");
			System.out.println("\t1.Tim kiem theo ma sinh vien");
			System.out.println("\t2.Tim kiem theo ma mon hoc");
			System.out.println("\t0.Quay lai");
			System.out.print("Lua chon cua ban ");
			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (chon) {
			case 1:
				timKiemTheoMaSV();
				break;
			case 2:
				timKiemTheoMaMH();
				break;
			case 0 :
				return;
			default: System.out.println("Lua chon khong hop le !!!");
			}
		}while(true);
	}

	private static void timKiemTheoMaSV() {
		System.out.print("\tNhap ma sinh vien can tim kiem : ");
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
		for(int i = 0; i < QLSinhVien.list.size();i++)
		{
			if(QLSinhVien.list.get(i).getMaSV() == maSV)
			{
				System.out.println("---------KET QUA TIM KIEM------");
				QLSinhVien.list.get(i).display();
				QLBangDiem.hienThiDiemTungSinhVien(i);
				break;
			}
		}
	}

	private static void timKiemTheoMaMH() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ma mon hoc : ");
		String maMH = sc.nextLine();
		if(maMH.trim().length() == 0)
		{
			System.out.println("\tMa mon hoc khong duoc de trong !");
			return;
		}
		int indexMonHoc = QLMonHoc.indexOfMonHoc(maMH);
		if(indexMonHoc == -1)
		{
			System.out.println("\tKhong ton tai mon hoc nay trong danh sach mon hoc");
			System.out.println("\tKhong the tiep tuc !");
			return;
		}
		for(int i = 0; i < QLMonHoc.list.size();i++)
		{
			if(QLMonHoc.list.get(i).getMaMH().compareToIgnoreCase(maMH) == 0)
			{
				System.out.println("---------KET QUA TIM KIEM------");
				QLMonHoc.list.get(i).display();
				QLBangDiem.hienThiDiemTungMonHoc(i);
				break;
			}
		}
	}
}
