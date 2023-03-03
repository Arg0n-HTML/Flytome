package com.cubes.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cubes.Services.IncidentCall;
import com.cubes.Services.User;

public class Home extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher("/view/home.jsp").forward( request, response );
                
        String lon = request.getParameter("lon");
        String lat = request.getParameter("lat");
        System.out.println(lon + " " + lat);
        if (lon != null && lat != null) {
        Float searchLatitude = Float.parseFloat(lon);
        Float searchLongitude = Float.parseFloat(lat);
        System.out.println(searchLatitude + " " + searchLongitude);
        String competence = request.getParameter("competence1");
        
        try {
        	List<User> heroes = IncidentCall.findByCoordinatesAndDistance(searchLatitude,searchLongitude,5000,competence);
			System.out.println(heroes.toString());
			request.setAttribute("heroes", heroes);
			//request.setAttribute("heroes", heroes);
	   
        } catch (SQLException e) {
        	
		}
    }

        
        }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}