package com.techymeet.railwayBo;

public class PassengerBO {

  private int id;
  private String name;
  private int age;
  private Gender gender;
  private BerthPreference berthPrefernce;
  
  
public PassengerBO(int id,String name, int age, Gender gender, BerthPreference berthPrefernce) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.berthPrefernce = berthPrefernce;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
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
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
public BerthPreference getBerthPrefernce() {
	return berthPrefernce;
}
public void setBerthPrefernce(BerthPreference berthPrefernce) {
	this.berthPrefernce = berthPrefernce;
}
  
  
  
}
