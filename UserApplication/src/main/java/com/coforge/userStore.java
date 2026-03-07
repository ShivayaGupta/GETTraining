package com.coforge;

import java.util.HashSet;

public class userStore {
 public static HashSet<User> users = new HashSet<>();
 
 public static void addUser(User user) {
	 users.add(user);
 }
 public static String validate(String userN,String password) {
	 
	 
	 for(User u:users) {
		 if(u.getUname().equals(userN)&& u.getPassword().equals(password)) {
			 return u.getUname()+"   "+u.getEmail()+"  "+u.getUserId()+"  "+ u.getMobile();
		 }
	 }
	 return null;
 }
} 
