package com.app.core;
// it is pojo class and in this class we can declre only data members , constructors 
//we cant write business logic  (plain old java object)
//we can resuse it multiple time
public class User {
	private String email;
	private String password;
	private String name;
	private int age;
	public User() {
 	}
	public User(String email, String password, 
			String name, int age) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", age=" + age + "]";
	}
	

	
	
	

}
