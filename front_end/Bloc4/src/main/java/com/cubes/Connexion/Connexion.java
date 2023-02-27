package com.cubes.Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	public static void main(String[] args) throws SQLException {
		String jdbcUrl = "jdbc:mariadb://localhost:3306/flytome";
		String user = "root";
		String password = "";
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String request = "INSERT INTO `heros`(`nomhero`, `competence1`, `competence2`, `competence3`, `password`, `email`, `telephone`, `habitation`) VALUES"
				+ " ('fire',1,2,NULL,'fire','fire','fire','fire');";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl,user,password);
			stat = conn.createStatement();
			rs = stat.executeQuery(request);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (rs!=null) rs.close();
			if (stat!=null) stat.close();
			if (conn!=null) conn.close();
		}
	}
}