package qlsv.qlchucnang;

import java.util.Scanner;

import qlsv.capnhat.QLDiem;
import qlsv.capnhat.QLMonHoc;
import qlsv.capnhat.QLSinhVien;
import qlsv.hienthibangdiem.QLBangDiem;
import qlsv.timkiem.QLTimKiem;

public class QLCHUCNANG {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		QLSinhVien.KhoiTao();
		QLMonHoc.KhoiTao();
		QLDiem.KhoiTao();
		int chon = -1;
		do
		{
			System.out.println("\n===========CHUONG TRINH QUAN LI SINH VIEN========");
			System.out.println("Chon chuc nang quan ly ");
			System.out.println("\t1 : Cap nhat danh sach ");
			System.out.println("\t2 : Hien thi bang diem ");
			System.out.println("\t3 : Tim kiem thong tin ");
			System.out.println("\t0 : Dong ung dung ");
			System.out.print("Lua chon cua ban ? ");
			try {
				chon = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("loi " + e.getMessage());
			}
			switch (chon) {
			case 1:
				CapNhatDanhSach();
				break;
			case 2:
				QLBangDiem.HienThiBangDiem();
				break;
			case 3:
				QLTimKiem.quanliTimKiem();
				break;
			case 0 :
				System.out.println("\nDa dong ung dung ");
				System.exit(0);
			default: System.out.println("Lua chon khong hop le");
				break;
			}
		}while(true);
	}

	private static void CapNhatDanhSach() {
		do
		{
			System.out.println("\t---------CHUC NANG CAP NHAT DANH SACH------------");
			System.out.println("chon chuc nang cap nhat ");
			System.out.println("\t 1.Cap nhat danh sach sinh vien ");
			System.out.println("\t 2.Cap nhat danh sach mon hoc ");
			System.out.println("\t 3.Cap nhat bang diem ");
			System.out.println("\t 0.Quay lai ");
			System.out.print("Lua chon cua ban ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				QLSinhVien.quanliSinhVien();
				break;
			case 2 :
				QLMonHoc.quanliMonHoc();
				break;
			case 3 :
				QLDiem.quanliDiem();
				break;
			case 0 :
				return;
			default:System.out.println("Lua chon khong hop le");
			}
		}while(true);
		
	}
}
