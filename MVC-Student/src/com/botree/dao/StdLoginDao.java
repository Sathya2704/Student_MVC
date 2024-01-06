package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.botree.bean.StdUser;
import com.botree.constants.StdQueryConstants;
import com.botree.util.StdUtil;

public class StdLoginDao {

	public StdUser getUser(StdUser user) {
		
		Connection conn = StdUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StdUser u = null;
		
		try {
			pstmt = conn.prepareStatement(StdQueryConstants.LOGIN_SQL); 
			pstmt.setString(1, user.username());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				u = new StdUser(user.username(), rs.getString("password")); 
			}
			
		}catch(Exception e) {
			
		}
		return u;
	}
}
