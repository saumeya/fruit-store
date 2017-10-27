package ecommerce;

import java.io.Serializable;

public class User implements Serializable{
	public int phone,pincode;
	public String name,email,street,city,state,username,password;
	
	public User(int phone, String name, String email,String street,String city,String password,int pincode,String state,String username) {
		this.phone = phone;
		this.name = name;
		this.street=street;
		this.city= city;
		this.email=email;
		this.username = username;
		this.state=state;
		this.pincode=pincode;
		this.password=password;
	}
}