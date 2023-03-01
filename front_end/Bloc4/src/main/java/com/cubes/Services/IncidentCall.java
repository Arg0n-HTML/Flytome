package com.cubes.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidentCall {

	public static List<User> findByCoordinatesAndDistance(Double searchLatitude, Double searchLongitude, int searchDistance, String competence) throws SQLException {
		String jdbcUrl = "jdbc:mariadb://localhost:3306/flytome";
		String user = "root";
		String password = "";
		Connection conn = null;
		
	    String sql = "SELECT id, heroname, latitude, longitude, telephone, competence1, competence2, competence3, "
	        		+ "( 6371 * acos( cos( radians(?) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?) ) + sin( radians(:lat) ) * sin( radians( latitude ) ) ) )"
	        		+ " AS distance FROM hero HAVING distance < ? WHERE competence1 = ? OR  competence1 = ? OR  competence1 = ? ORDER BY distance";
	
		conn = DriverManager.getConnection(jdbcUrl,user,password);
		PreparedStatement stmt = conn.prepareStatement(sql);
			
	    stmt.setDouble(1, searchLatitude);
	    stmt.setDouble(2, searchLongitude);
	    stmt.setInt(3, searchDistance);
	    stmt.setString(4, competence);
	    stmt.setString(5, competence);
	    stmt.setString(6, competence);
	    
	    ResultSet rs = stmt.executeQuery();
	    
	    List<User> heroes = new ArrayList<User>();
	    
	    while (rs.next()) {
	    	User hero = new User();
	    	hero.Phone = rs.getString("telephone");
	    	hero.Name = rs.getString("nomhero");
	    	hero.Competence1 = rs.getString("competence1");
	    	hero.Competence2 = rs.getString("competence2");
	    	hero.Competence3 = rs.getString("competence3");
	    	heroes.add(hero);
	    	}
	        return heroes;        
	}
}