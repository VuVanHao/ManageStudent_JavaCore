package qlsv.hienthibangdiem;

import java.util.Scanner;

import qlsv.capnhat.QLDiem;
import qlsv.capnhat.QLMonHoc;
import qlsv.capnhat.QLSinhVien;

public class QLBangDiem {

	static Scanner sc = new Scanner(System.in);
	
	public static void HienThiBangDiem()
	{
		int chon = -1;
		do
		{
			System.out.println("-----HIEN THI BANG DIEM-------");
			System.out.println("\t1. Hien thi bang diem tat ca sinh vien theo tung sinh vien");
			System.out.println("\t2. Hien thi bang diem tat ca cac mon hoc theo tung mon hoc");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban ");	
			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (chon) {
			case 1:
				hienThiDiemTheoSinhVien();
				break;
			case 2:
				hienThiDiemTheoMon();
				break;
			case 0:
				return;
			default: System.out.println("Lua chon khong hop le !!!");
			}
		}while(true);
	}
	

	public static void hienThiDiemTheoSinhVien()
	{
		//Sap xep sinh vien theo ma
		QLSinhVien.SapXepMaSV();
		for(int i = 0; i < QLSinhVien.list.size();i++)
		{
			System.out.println("=======================================");
			System.out.println("\t\tMa sinh vien : " + QLSinhVien.list.get(i).getMaSV());
			System.out.println("\t\tHo va ten : " + QLSinhVien.list.get(i).getHoDem() + QLSinhVien.list.get(i).getTen());
			int index = indexOfSinhVien(QLSinhVien.list.get(i).getMaSV());
			
			if(index == -1)
			{
				System.out.println("\tSinh vien khong dang ky mon hoc nao ");
				return;
			}
			hienThiDiemTungSinhVien(i);
		}
		
	}
	
	public static void hienThiDiemTungSinhVien(int index) {
		double tongDiem = 0;
		double tongHeSo = 0;
		System.out.printf("%-8s %-15s %5s%n","Ma MH","Ten MH","Diem");
		for(int i = 0; i < QLDiem.list.size();i++)
		{
			int indexMonHoc = QLMonHoc.indexOfMonHoc(QLDiem.list.get(i).getMaMH());
			if(QLSinhVien.list.get(index).getMaSV() == QLDiem.list.get(i).getMaSV())
			{
				try {
					System.out.printf("%-8s %-15s %5.2f %n",
							QLDiem.list.get(i).getMaMH(),
							QLMonHoc.list.get(indexMonHoc).getTenMH(),
							QLDiem.list.get(i).getDiem());
					tongHeSo += QLMonHoc.getHeSoMon(QLDiem.list.get(i).getMaMH());
					tongDiem += QLMonHoc.getHeSoMon(QLDiem.list.get(i).getMaMH()) * QLDiem.list.get(i).getDiem() ;
				} catch (Exception e) {
					System.out.println("Loi "+ e.getMessage());
				}
			}
		}
		System.out.printf("\tDiem trung binh : %3.1f %n", tongDiem/tongHeSo);
		
	}

	
	private static void hienThiDiemTheoMon() {
		for(int i = 0; i < QLMonHoc.list.size();i++)
		{
			System.out.println("=======================================");
			System.out.println("\t\tMa mon hoc : " + QLMonHoc.list.get(i).getMaMH());
			System.out.println("\t\tTen non hoc : " + QLMonHoc.list.get(i).getTenMH());
			
			int index = indexOfMonHoc(QLMonHoc.list.get(i).getMaMH());
			
			if(index == -1)
			{
				System.out.println("\tMon hoc khong co sinh vien dang ky ");
				return;
			}
			hienThiDiemTungMonHoc(i);
		}
	}
	
	public static void hienThiDiemTungMonHoc(int index) {
		double tongDiem = 0;
		int count = 0;
		System.out.printf("%7s %-25s %5s%n","Ma SV","Ho va Ten","Diem");
		for(int i = 0; i < QLDiem.list.size();i++)
		{
			int indexSinhVien = QLSinhVien.indexOfSinhVien(QLDiem.list.get(i).getMaSV());
			String tenSinhVien = QLSinhVien.list.get(indexSinhVien).getHoDem() + " "+ QLSinhVien.list.get(indexSinhVien).getTen();
			if(QLDiem.list.get(i).getMaMH().compareToIgnoreCase(QLMonHoc.list.get(index).getMaMH()) == 0)
			{
				System.out.printf("%7s %-25s %5s%n",
						QLDiem.list.get(i).getMaSV(),tenSinhVien,QLDiem.list.get(i).getDiem());
				tongDiem += QLDiem.list.get(i).getDiem();
				count++;
			}
		}
		System.out.printf("\tDiem trung binh : %3.1f %n", tongDiem/count);
	}


	//Ham nhan vao ma mon hoc va kiem tra sinh vien co hoc mon do khong
	public static int indexOfMonHoc(String maMH)
	{
		for(int index = 0; index < QLDiem.list.size();index++)
		{
			if(QLDiem.list.get(index).getMaMH().compareToIgnoreCase(maMH) == 0)
			{
				return index;
			}
		}
		return -1;
	}
	
	public static int indexOfSinhVien(int maSV)
	{
		for(int index = 0; index < QLDiem.list.size();index++)
		{
			if(QLDiem.list.get(index).getMaSV() == maSV)
			{
				return index;
			}
		}
		return -1;
	}
}
