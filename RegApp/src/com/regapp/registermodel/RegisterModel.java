package com.regapp.registermodel;

import com.regapp.registerdao.RegisterUser;

public class RegisterModel {
	private static String registrationRes;
	private static Boolean registrationCreateRes;
	
	public static String register(String email, String pwd, String repwd ) {
		
		if (email ==null) 
		{
			registrationRes = "Email cannot be null";
				
		}else {
			
			if (pwd == null||repwd == null) {
				registrationRes = "Password cannot be null";				
			}else {
				
				registrationCreateRes = RegisterUser.createUser(email,pwd);
				if (registrationCreateRes) {
					registrationRes = "Registration Success";
				}else{
					registrationRes = "Registration failed since we could not store your information";
				}
				
			}
		}
		
		return registrationRes;
	}

}
