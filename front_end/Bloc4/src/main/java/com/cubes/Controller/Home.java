package com.cubes.Controller;

import com.cubes.Services.*;
import com.cubes.Services.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class Home extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/view/home.jsp"
                ).forward( request, response );
        Double searchLatitude = Double.parseDouble(request.getParameter("lon"));
        Double searchLongitude = Double.parseDouble(request.getParameter("lat"));
        String competence = request.getParameter("competence1");
        System.out.println("je suis passé dans je home.java");
        try {
			IncidentCall.findByCoordinatesAndDistance(searchLatitude,searchLongitude,5000,competence);
		} catch (SQLException e) {
			System.out.println("erreur");
		}
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}