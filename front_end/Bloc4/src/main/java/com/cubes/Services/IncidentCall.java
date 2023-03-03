package com.cubes.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidentCall {

	public static List<User> findByCoordinatesAndDistance(Float searchLatitude, Float searchLongitude, int searchDistance, String competence) throws SQLException {
		String jdbcUrl = "jdbc:mariadb://localhost:3306/flytome";
		String user = "root";
		String password = "";
		Connection conn = null;
		
	    String sql = "SELECT idhero, nomhero, lattitude, longitude, telephone, competence1, competence2, competence3 FROM heros WHERE competence1 = ? OR competence2 = ? OR competence3 = ?;";
	    
	    
		conn = DriverManager.getConnection(jdbcUrl,user,password);
		PreparedStatement stmt = conn.prepareStatement(sql);
			
	    stmt.setString(1, competence);
	    stmt.setString(2, competence);
	    stmt.setString(3, competence);
	    
	    ResultSet rs = stmt.executeQuery();
	    
	    
	    List<User> heroes = new ArrayList<User>();
	    
	    while (rs.next()) {
	    	
	    	User hero = new User();
	    	hero.Phone = rs.getString("telephone");
	    	hero.Name = rs.getString("nomhero");
	    	hero.Competence1 = rs.getString("competence1");
	    	hero.Competence2 = rs.getString("competence2");
	    	hero.Competence3 = rs.getString("competence3");
	    	hero.Longitude = rs.getFloat("longitude");
	    	hero.Latitude = rs.getFloat("lattitude");
	    	System.out.println(hero.Longitude);
	    	System.out.println(hero.Latitude);
	    	double dist = org.apache.lucene.util.SloppyMath.haversinMeters(searchLatitude, searchLongitude, hero.getLatitude(), hero.getLongitude());
	    	if (dist < searchDistance){
	    		heroes.add(hero);
	    	}
	    }
	    
	    	System.out.println(heroes);
	        return heroes; 
	}
}