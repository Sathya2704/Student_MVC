package com.botree.business;

import java.util.List;
import com.botree.bean.Student;
import com.botree.dao.StudentDao;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;

public class StudentBo {

	StudentDao stdDao = new StudentDao();

	public boolean registerStudent(Student std) throws DuplicateIdException {

		return stdDao.addStudent(std);
	}

public Student findStudent(String Reg_Number) throws IdNotFoundException{
		
		return stdDao.findStudent(Reg_Number);
	}

	public boolean updateStudent(String Reg_Number, String Branch) throws IdNotFoundException {

		return stdDao.updateStudent(Reg_Number, Branch);
	}

	public boolean deleteStudent(String Reg_Number) throws IdNotFoundException {
		
		return stdDao.deleteStudent(Reg_Number);
		
	}

	public List<Student> showAllStudent() {

		return stdDao.showAllStudent();

	}
}
