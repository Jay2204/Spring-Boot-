package com.boot.util;

import java.util.List;

import com.boot.model.User;

public final class FormatUtil {

	private FormatUtil() {

	}

	public static boolean checkIdExist(int id, List<User> studentList) {
		boolean flag = false;

		for (User user : studentList) {
			
			if (id == user.getId()) {
				System.out.println(id+" check "+user.getId());
				flag = true;
				break;
			}

		}
		return flag;
	}

}
