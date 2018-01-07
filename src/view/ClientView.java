package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.SinhVien;

public class ClientView {
	 private ArrayList<SinhVien> listSV = new ArrayList<>();
	public SinhVien nhapSV() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten: ");
		String ten = sc.nextLine();
		System.out.println("Nhap email: ");
		String email = sc.nextLine();
		SinhVien sv = new SinhVien(ten,email);
		return sv;	
		
	}
	public void showMess(String mess) {
		System.out.println(mess);
	}
	public int menu() {
		System.out.println("Moi chon cac lua chon: ");
		System.out.println("1. Add");
		System.out.println("2. View");
		System.out.println("3. Edit");
		System.out.println("4. Delete");
		System.out.println("5. Save");
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi nhap: ");
		int choice = Integer.parseInt(sc.nextLine());
		return choice;
	}
	public void showListSV(ArrayList<SinhVien> listSV) {
		
		System.out.println("-------------DSSV--------------");
		for(SinhVien x: listSV) {
			System.out.println(x.getMaSV()+"--"+x.getTenSV()+"--"+x.getEmail());
		}
	}
	public SinhVien search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		SinhVien sv = new SinhVien();
		sv.setMaSV(maSV);
		return sv;
	}
	
}
