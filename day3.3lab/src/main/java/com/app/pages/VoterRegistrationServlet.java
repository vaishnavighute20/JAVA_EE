package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VoterRegistrationServlet
 */
@WebServlet("/Registration")
public class VoterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
 	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
 	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// set content type
 		response.setContentType("text/html");
 		try ( PrintWriter pw=response.getWriter()){
 			// get http session
 			HttpSession session=request.getSession();
 			// get request parameter
 			String fName =request.getParameter("fn");
 			String lName =request.getParameter("ln");
 			String email =request.getParameter("em");
 			String password =request.getParameter("pass");
 			LocalDate birthDate =LocalDate.parse(request.getParameter("fn"));
 			int age =Period.between(birthDate, LocalDate.now()).getYears();
    if(age>=21) {
          // create voter instance
    	    User newVoter=new User(fName,lName,email);

               }


 			
 		}
 		
	}

}

