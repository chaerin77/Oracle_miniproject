package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		Showp showp = new Showp();
		showp.showInfo();
		
		PhoneDao phoneDao = new PhoneDao();
		
		//데이터 5개 넣어놓기]
		/*
		PersonVo vo01 = new PersonVo("이효리","010-1111-1111","02-1111-1111");
		phoneDao.pInsert(vo01);
		
		PersonVo vo02 = new PersonVo("정우성", "010-2222-2222", "02-2222-2222");
		phoneDao.pInsert(vo02);
		
		PersonVo vo03 = new PersonVo("유재석", "010-3333-3333", "02-3333-3333");
		phoneDao.pInsert(vo03);
		
		PersonVo vo04 = new PersonVo("이정재", "010-4444-4444", "02-4444-4444");
		phoneDao.pInsert(vo04);

		PersonVo vo05 = new PersonVo("서장훈", "010-5555-5555", "02-5555-5555");
		phoneDao.pInsert(vo05); */
		
		Boolean flag = true;
		Scanner sc = null;
		
		while(flag) {
			sc = new Scanner(System.in);
			
			List<PersonVo> personlist;
			
	        int num = sc.nextInt();
			
			switch(num) {  
				case 1:
			         System.out.println("<리스트>"); 
			         
			         personlist = phoneDao.PersonSelect();
			 		 for(int i=0; i<personlist.size(); i++) {
			 			PersonVo vo = personlist.get(i);
			 			System.out.println(vo.getPersonId()+"   "+vo.getName()+"   "+vo.getHp()+"   "+vo.getCompany());
			 		 }
			 		 System.out.println("\n");
			 		 showp.showlist();
			         break;
				case 2:
					 sc.nextLine();
					 System.out.println("<2.등록>");
					 System.out.print("이름 > ");
					 String name = sc.nextLine();
					 System.out.print("휴대전화 > ");
					 String phone = sc.nextLine();
					 System.out.print("회사번호 > ");
					 String company = sc.nextLine();
					
					 PersonVo vo = new PersonVo(name,phone,company);
					 phoneDao.pInsert(vo);
					
					 System.out.println("[1건 등록되었습니다.]" + "\n");
					 showp.showlist();
					 break;
				case 3:
					 System.out.println("<3.수정>");
					 System.out.print("번호 > ");
					 int pid = sc.nextInt();
					 sc.nextLine();
					 System.out.print("이름 > ");
					 String uname = sc.nextLine();
					 System.out.print("휴대전화 > ");
					 String uphone = sc.nextLine();
					 System.out.print("회사번호 > ");
					 String ucompany = sc.nextLine();
	
					 PersonVo uvo = new PersonVo(pid,uname,uphone,ucompany);
					 phoneDao.pUpdate(uvo);
					 
					 System.out.println("[1건 수정되었습니다.]" + "\n");
					 showp.showlist();
					 break;
				case 4:
					 System.out.println("<4.삭제>");
					 System.out.print(">번호 : ");
					 int number = sc.nextInt();
					 phoneDao.pDelete(number);
					 
					 System.out.println("[1건 삭제되었습니다.]" + "\n");
					 showp.showlist();
					 break;
				case 5:	 
					 System.out.println("<5.검색>");
					 System.out.print("검색어 : ");
					 String search = sc.nextLine();
					 break;
				case 6:
					 showp.showlast();
					 flag = false;
				     break;
				default :
					 System.out.println("[다시 입력해주세요.]" + "\n"); //위에 해당안하는 나머지들
			         showp.showlist();
					 break;
			} 
		}
		
		sc.close();

	}

}
