package com.gem.Hibernate.pojo;

public class Person {
	private int pid;
	private String pname ;
	private int age;
	private String address;
	
	Person(){}

	public Person(String pname, int age, String address) {
		super();
		this.pname = pname;
		this.age = age;
		this.address = address;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", age=" + age
				+ ", address=" + address + "]";
	}

}