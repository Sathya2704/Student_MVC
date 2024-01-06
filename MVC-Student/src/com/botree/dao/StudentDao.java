package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.botree.bean.Student;
import com.botree.constants.StdQueryConstants;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;
import com.botree.util.StdUtil;

public class StudentDao {

public boolean addStudent(Student std) throws DuplicateIdException{
		
		Connection conn = StdUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
		      pstmt=conn.prepareStatement(StdQueryConstants.INSERT_SQL);
		      pstmt.setString(1, std.Reg_Number());
		      pstmt.setString(2, std.Student_Name());
		      pstmt.setString(3, std.Branch());
		      pstmt.setString(4, std.Contact_Number());
		      pstmt.setString(5, std.Date_of_Birth());
		      pstmt.setString(6, std.Date_of_Joining());
		      pstmt.setString(7, std.Address());
		      pstmt.setString(8, std.Email_id());

		      pstmt.execute();
		      
		      return true;
		      
		}catch(Exception e) {
			e.printStackTrace();
			throw new DuplicateIdException(std.Reg_Number()+"already exist");
		}
	}
	
	
	public Student findStudent(String Reg_Number) throws IdNotFoundException {
		
	    Connection conn = StdUtil.getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        pstmt = conn.prepareStatement(StdQueryConstants.SEARCH_SQL);
	        pstmt.setString(1, Reg_Number);
	        
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) 
	        	
	            return new Student(rs.getString("Reg_Number"), rs.getString("Student_Name"), rs.getString("Branch"), rs.getString("Contact_Number"), rs.getString("Date_of_Birth"), rs.getString("Date_of_Joining"), rs.getString("Address"), rs.getString("Email_id"));
	            
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
        throw new IdNotFoundException(Reg_Number+" not found");

	}
	

	public boolean updateStudent(String Reg_Number, String Branch) throws IdNotFoundException {

		Connection conn = StdUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(StdQueryConstants.UPDATE_BRANCH_SQL);
			pstmt.setString(1, Branch);
			pstmt.setString(2, Reg_Number);

			 pstmt.execute();
          return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new IdNotFoundException(Reg_Number + " not found");

	}

	
	public boolean deleteStudent(String Reg_Number) throws IdNotFoundException {

		Connection conn = StdUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(StdQueryConstants.DELETE_SQL);
			pstmt.setString(1, Reg_Number);
			
			pstmt.execute();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new IdNotFoundException(Reg_Number + " not found");
		}
	}
	
	
	public List<Student> showAllStudent()  {
		List<Student> stdList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = StdUtil.getConnection();
        try {
        pstmt = conn.prepareStatement(StdQueryConstants.SELECT_SQL);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            Student student = new Student(rs.getString("Reg_Number"), rs.getString("Student_Name"), rs.getString("Branch"), rs.getString("Contact_Number"), rs.getString("Date_of_Birth"), rs.getString("Date_of_Joining"), rs.getString("Address"), rs.getString("Email_id"));
            stdList.add(student);
        }
        }catch(Exception e) {
        	e.printStackTrace();
        }

        return stdList;
    }

}
