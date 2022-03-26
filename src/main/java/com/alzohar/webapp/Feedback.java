package com.alzohar.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Feedback() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// response.sendRedirect("login.html");
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("feedback.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type.
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get value from form
		// request params
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("useremail");
		String reviews = request.getParameter("reviews");
		String rating = request.getParameter("rating");

		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("feedback.html").include(request, response);

		if (userEmail.equals("") || userName.equals("")) {
			out.println("<h2 style='color:red'>Registration Failed  * Required filled are missing! </h2>");
		} else {
			out.println("<h2 style='color:green'>Registration sucessfull ! for user '" + userName + "' </h2>");
		}
	}

}
