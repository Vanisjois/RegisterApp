package com.regapp.test.registerdaotest;

import com.regapp.registerdao.RegisterUser;

public class RegisterTest {
	
	public static final String userEmail = "vanisjois@gmail.com";
	public static final String userPassword = "123abc";

	public static void main (String[] args){
		Boolean registrationResult;		
		registrationResult = RegisterUser.createUser(userEmail, userPassword);
		if (registrationResult) {
			System.out.println("User created succesfully");
		} else {
			System.out.println("OOPS !! Something went wrong while storing user");
		}
	}
}
