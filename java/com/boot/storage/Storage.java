package com.boot.storage;

import java.util.ArrayList;
import java.util.List;

import com.boot.model.User;

public class Storage {

	private static Storage storage=new Storage();
	
	private static List<User> studentDetails=new ArrayList<User>();
	private Storage(){
		
	}
		
	public static Storage getStorage(){
		return storage;
	}
	
	public List<User> getStudentDetails(){
		return studentDetails;
	}
	
}
