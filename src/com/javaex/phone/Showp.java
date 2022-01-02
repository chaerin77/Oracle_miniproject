package com.javaex.phone;

public class Showp {

	//꾸미기 형식
	
	public void showInfo() {
		System.out.println("*************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("*************************************");
		System.out.println("1.리스트 2.등록 3.수정 4.삭제 5.검색 6.종료");
		System.out.println("-------------------------------------");
		System.out.print(">메뉴번호:");
	}
	
	public void showlist() {
		System.out.println("1.리스트 2.등록 3.수정 4.삭제 5.검색 6.종료");
		System.out.println("-------------------------------------");
		System.out.print(">메뉴번호:");
	}
	
	public void showlast() {
		System.out.println("*************************************");
		System.out.println("*              감사합니다              *");
		System.out.println("*************************************");
	}	
}
