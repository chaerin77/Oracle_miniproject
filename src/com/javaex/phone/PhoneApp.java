package com.javaex.phone;

import java.util.List;

public class PhoneApp {

	public static void main(String[] args) {

		List<PersonVo>plist;
		PhoneDao phoneDao = new PhoneDao();
		
		PersonVo vo01 = new PersonVo();
		phoneDao.pInsert(null);
	}

}
