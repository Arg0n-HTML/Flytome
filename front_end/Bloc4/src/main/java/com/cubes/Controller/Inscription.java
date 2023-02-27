package com.cubes.Controller;

import com.cubes.Services.ApiCall;
import com.cubes.Services.ApiGet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        this.getServletContext().getRequestDispatcher("/view/inscription.jsp"
	                ).forward( request, response );
	    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	String jdbcUrl = "jdbc:mariadb://localhost:3306/flytome";
			String user = "root";
			String password = "";
			Connection conn = null;
			//Statement stat = null;
			//ResultSet rs = null;
			
			// Récuperation des données des inputs
			String Name = request.getParameter("name");
			String Comp1 = request.getParameter("competence1");
			String Comp2 = request.getParameter("competence2");
			String Comp3 = request.getParameter("competence3");
			String Email = request.getParameter("email");
			String Password = request.getParameter("password");
			String Telephone = request.getParameter("telephone");
			String HabitationNon = request.getParameter("habitation");
			
			String ch = "%20";
			String Habitation = HabitationNon.replaceAll(String.valueOf(' '),String.valueOf(ch));
			
			
			// Hashage du mot de passe en SHA-256
			MessageDigest digest = null;
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			byte[] hash = digest.digest(Password.getBytes(StandardCharsets.UTF_8));
			
			// Appel a une API pour avoir lattitude et longitude d'une adresse
			ApiGet resultApi = ApiCall.apiCall(Habitation);
			String lat = resultApi.getLatitude();
			String lon = resultApi.getLongitude();
			System.out.println(lat + " " + lon);
			
			// Requete preparée pour eviter les injections où le premier argument de setString est egal a la place du "?" dans VALUES
			String request1 = "INSERT INTO `heros`(`nomhero`, `competence1`, `competence2`, `competence3`, `password`, `email`, `telephone`, `habitation`) VALUES (?,?,?,?,?,?,?,?,?);";
			
			try {
				conn = DriverManager.getConnection(jdbcUrl,user,password);
				PreparedStatement stmt = conn.prepareStatement(request1);
				stmt.setString(1, Name);
				stmt.setString(2, Comp1);
				stmt.setString(3, Comp2);
				stmt.setString(4, Comp3);
				stmt.setBytes(5, hash);
				stmt.setString(6, Email);
				stmt.setString(7, Telephone);
				stmt.setString(8, lat );
				stmt.setString(9, lon );
				stmt.executeUpdate();
				stmt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	         
	         
	         this.getServletContext().getRequestDispatcher("/view/inscription.jsp").forward(request, response);
    }
}
