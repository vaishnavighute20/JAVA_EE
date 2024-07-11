package web_pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */

// USING XML TAGS  
/*
 * run time ,class level, mandatory annotation meant for wc
 * when you deploy a web application,wc creates a map
 * key---URL pattern (/hello")
 * value--fully qualified name servlet class name (web_pages.TestServlet)
 * URL-- http://host:port/day1_lab/hello
 * http- app layer protocol(Scheme)
 * host-DNS qualified host name (www.abc.com)or ip address
 * port -tcp port no(default port no -8080)
 * URI-/day1_lab/hello
 /day1_lab-context(=web application)root
  /hello 
  
 */
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("In init from "+ getClass());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
 		System.out.println("In Destroy from "+ getClass());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		response.getWriter().append("Served at: ").append(request.getContextPath());

		// set response content type
		response.setContentType("text/html");
		// 2. get PrintWriter from httpServletResponse,to send buffered text contents -->to the client
		try(PrintWriter pw=response.getWriter()){
			System.out.println("In doget  in xml"+ getClass());
			pw.print("<h4> welcome to servlet 2023,+ server Time Stamp"+LocalDateTime.now()+ "</h4>");

				//add dynamic contents to PW's buffer
		
		}
	}

}
