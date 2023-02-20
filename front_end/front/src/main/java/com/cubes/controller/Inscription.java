package com.cubes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        this.getServletContext().getRequestDispatcher("/view/inscription.jsp"
	                ).forward( request, response );
	    }
	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	 String Name = request.getParameter("Name");
	    	 String Email = request.getParameter("Email");
	    	 String Password = request.getParameter("Password");
	    	 
	    	 request.setAttribute("Name", Name);
	         request.setAttribute("Email", Email);
	         request.setAttribute("Password", Password);
	         
	    	 URL url = new URL("http://localhost:8082/api/user");
	    	 URLConnection con = url.openConnection();
	    	 HttpURLConnection http = (HttpURLConnection)con;
	    	 http.setRequestMethod("POST"); // PUT is another valid option
	    	 http.setDoOutput(true);
	         
	    	 byte[] out = "{\"Name\":\"root\",\"Email\":\"Email\",\"Password\":\"motdepass\"}".getBytes(StandardCharsets.UTF_8);
	    	 int length = out.length;

	    	 http.setFixedLengthStreamingMode(length);
	    	 http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	    	 http.connect();
	    	 try(OutputStream os = http.getOutputStream()) {
	    	     os.write(out);
	    	 }
	    	 
	         
	         
	         this.getServletContext().getRequestDispatcher("/view/inscription.jsp").forward(request, response);
    }
}
