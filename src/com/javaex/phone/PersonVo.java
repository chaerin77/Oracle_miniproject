package com.javaex.phone;

public class PersonVo { //사람 정보 클래스

	//필드
	private String person_id;
	private String name;
	private String hp;
	private String company;
	
	//생성자
	public PersonVo() {
		
	}
	

	public PersonVo(String person_id, String hp, String company) {
		super();
		this.person_id = person_id;
		this.hp = hp;
		this.company = company;
	}


	public PersonVo(String person_id, String name, String hp, String company) {
		this.person_id = person_id;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	
	//메소드 g/s 
	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	//메소드 일반
	
}
