package com.mistrutswebapp.model;


public class ReferenceGenerator{
	public static String getReference(String user_ID){
		StringBuffer reference = new StringBuffer();
		reference.append(user_ID);
		int rand = (int)Math.floor(Math.random()*999);
		reference.append(rand);
		System.out.println("reference = " + reference.toString());
		return reference.toString();
	}
	
}
