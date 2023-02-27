package com.cubes.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListHero extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        		String jdbcUrl = "jdbc:mariadb://localhost:3306/flytome";
    			String user = "root";
    			String password = "";
    			Connection conn = null;
    			Statement stmt = null;
    			ResultSet rs = null;
    			String requestsql = "SELECT * FROM `heros`;";
    			
    			try {
    				conn = DriverManager.getConnection(jdbcUrl,user,password);
    				stmt = conn.createStatement();
    				rs = stmt.executeQuery(requestsql);
    				
    				while(rs.next()) {
    					System.out.print(rs.getString("nomhero"));
    				}
    				
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
        		
                this.getServletContext().getRequestDispatcher("/view/listHero.jsp").forward( request, response );
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
