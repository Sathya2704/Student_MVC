package com.botree.constants;

public class StdQueryConstants {

	public static final String LOGIN_SQL = """
			select password from user where username=?
			""";
	
	public static final String INSERT_SQL="""
			insert into Student_Info values(?,?,?,?,?,?,?,?);
			""";
	
	public static final String SEARCH_SQL="""
			select * from Student_Info where Reg_Number =?;
			""";
	
//	public static final String UPDATE_NAME_SQL="""
//			update employee set name=? where id =?;
//			""";
	
	public static final String UPDATE_BRANCH_SQL="""
			update Student_Info set Branch=? where Reg_Number =?;
			""";
	
	public static final String DELETE_SQL="""
			delete from Student_Info where Reg_Number =?;
			""";
	
	public static final String SELECT_SQL="""
			select * from Student_Info;
			""";
	
}
