package com.botree.controller;

import java.util.List;
import java.util.Scanner;

import com.botree.bean.StdUser;
import com.botree.bean.Student;
import com.botree.business.StdLoginBo;
import com.botree.business.StudentBo;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;
import com.botree.exception.InvalidStdUserException;

public class StdMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag=true;
		
		do {
			var user = login();
			
			var LoginBo = new StdLoginBo();
			
			try {
				flag = !LoginBo.validateUser(user);
			}catch(InvalidStdUserException e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		do {
			System.out.println("Select option");
			
			System.out.println("""
					1. Register Student \n 
					2. Find by Register_Number \n 
					3. Update Student \n 
					4. Delete Student \n 
					5. Show All Student \n
					6. Exit 
					""");
            int option = sc.nextInt();
			
			switch(option) {
			case 1 -> register();
			
			case 2 -> find();
			
			case 3 -> update();

			case 4 -> delete();

			case 5 -> showAll();
			
			case 6 -> System.exit(0);

			default -> System.out.println("Wrong Choice");
			}
			
			
		}while(true);
	}
	
	public static void register() {

		System.err.println("Register Page");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Register_Number : ");
		String Reg_Number = sc.next();

		System.out.println("Enter Student_Name : ");
		String Student_Name = sc.next();

		System.out.println("Enter Branch : ");
		String Branch = sc.next();

		System.out.println("Enter Contact_Number : ");
		String Contact_Number = sc.next();
		
		System.out.println("Enter Date_of_Birth : ");
		String Date_of_Birth = sc.next();
		
		System.out.println("Enter Date_of_Joining : ");
		String Date_of_Joining = sc.next();
		
		System.out.println("Enter Address : ");
		String Address = sc.next();
		
		System.out.println("Enter Email_id : ");
		String Email_id = sc.nextLine();
		
		var std = new Student(Reg_Number, Student_Name, Branch, Contact_Number, Date_of_Birth, Date_of_Joining, Address, Email_id);

		var stdBo = new StudentBo();

		try {
			stdBo.registerStudent(std);
			System.out.println(Reg_Number + "registered successfully");

		} catch (DuplicateIdException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void find() {
		System.err.println("Search Page");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Reg_Number : ");
		String Reg_Number = sc.next();
		
		var stdBo = new StudentBo();
		try {
		System.out.println(stdBo.findStudent(Reg_Number));
		}catch(IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void update() {
		System.err.println("Update Page");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Reg_Number : ");
		String Reg_Number = sc.next();
		
		System.out.println("Enter Branch : ");
		String Branch = sc.next();
		
		var stdBo = new StudentBo();
		try {
		System.out.println(stdBo.updateStudent(Reg_Number,Branch));
		}catch(IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void delete() {
		System.err.println("Delete Page");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Reg_Number : ");
		String Reg_Number = sc.next();
			
		var stdBo = new StudentBo();
		
		try {
		stdBo.deleteStudent(Reg_Number);
		System.out.println(Reg_Number+"deleted successfully");
		
		}catch(IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	 public static void showAll() {
	        System.err.println("Display Page");

	        var stdBo = new StudentBo();
	        List<Student> student = stdBo.showAllStudent();

	        if (student.isEmpty()) {
	            System.out.println("No student found.");
	        } else {
	            System.out.println("Student List:");
	            for (Student students : student) {
	                System.out.println(students);
	            }
	        }
	    }

	public static StdUser login() {
		
		System.err.println("Login Page");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name : ");
		String name = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		return new StdUser(name, password);
		
	}
}
