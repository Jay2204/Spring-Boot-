package com.boot.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.exception.UserIdExistException;
import com.boot.model.User;
import com.boot.storage.Storage;
import com.boot.util.FormatUtil;

@Component
public class StudentService {

	private List<User> studentList = Storage.getStorage().getStudentDetails();

	public void addStudent(User student) {

		boolean val=FormatUtil.checkIdExist(student.getId(), studentList);
		System.out.println("val"+val);
		if (!val) {
			studentList.add(student);
		} else {
			
			throw new UserIdExistException(student.getId());
		}

	}

	public List<User> viewStudentDetails() {
		return sortList(studentList);
	}

	public List<User> updateStudent(int id, User oldStudent) {
		for (User student : studentList) {
			if (id == student.getId()) {
				student.setName(oldStudent.getName());
				student.setAge(oldStudent.getAge());
				break;
			}
		}

		return sortList(studentList);

	}

	public List<User> deleteStudent(int id) {
		Iterator<User> studIte = studentList.iterator();

		while (studIte.hasNext()) {
			User student = studIte.next();
			if (id == student.getId()) {
				studIte.remove();
			}
		}

		return studentList;

	}

	public List<User> sortList(List<User> studDetails) {
		Collections.sort(studDetails, new Comparator<User>() {
			public int compare(User o1, User o2) {
				return o1.getId() - o2.getId();
			}
		});

		return studDetails;
	}

}
