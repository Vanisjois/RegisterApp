package com.regapp.registerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class RegisterUser {
	
	private static OracleDataSource ods = null;
	private static Connection conn = null;
	private static PreparedStatement create_user = null;	
	
	static {
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:appdata/app@localhost:1521/orcl");
			conn = ods.getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null )
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
		}
		
	}
	
	public static boolean createUser(String email, String pwd){
		String insert_sql = "INSERT INTO USERS(EMAIL,PASSWORD) VALUES (?,?)";
		boolean result = false;
		
		try {
			create_user = conn.prepareStatement(insert_sql);
			create_user.setString(1, email);
			create_user.setString(2, pwd);
			result = create_user.execute();
			if (result) 
			conn.commit();
			else
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
