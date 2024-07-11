package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;
import static com.app.utils.DBUtils.*;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(value = "/login", loadOnStartup = 1) // eager init  ambiguity error if uncomment
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	private CandidateDaoImpl candidateDao;

//	private String dbURL,userName,password;
	public LoginServlet() {
		System.out.println("in def ctor ");
		System.out.println("config " + getServletConfig());// null  default call constructor
	}

//	public LoginServlet(String dbURL, String userName, String password) {
//		super();
//		System.out.println("in parameterized ctor....");
//		this.dbURL = dbURL;
//		this.userName = userName;
//		this.password = password;
	// paramaterised consturctor never called only default will call
//	}

	/*
	 * overriding form of the method CAN'T throw any NEW or BROADER checked excs
	 */
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		System.out.println("in init of " + getClass()+" cofig "+config);//not null
		try {
			//open db connection once
			openConnection(config.getInitParameter("db_url"),
					config.getInitParameter("user_name"),
					config.getInitParameter("password"));
			userDao = new UserDaoImpl();
			candidateDao=new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init - " + getClass(), e);
		}
	}

	/**
	 *  destroyed call by web container
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			candidateDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			System.out.println("err in destroy - " + getClass());
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. Get PW to send text resp
		try (PrintWriter pw = response.getWriter()) {// reading request parameter
			// 3. Get req params(email n pwd) from the req
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// 4. Invoke user dao's --sign in method for user authentication
			User user = userDao.signIn(email, password);
			// 5 . check if valid (via null)
			if (user == null) {
				// invalid login --send retry link --login.html
				pw.print("<h5>Invalid Login , Please  <a href='login.html'>Retry</a><h5>");
			} else {
				// valid login --1. Get HttpSession from WC
				HttpSession session = request.getSession();
				System.out.println("Login servlet , session is new " + session.isNew());// t // returns new session
				System.out.println("session ID " + session.getId());// once per client
				// 2. store the state of the clnt under the session scope
				session.setAttribute("user_info", user);
				// add daos under session scope
				session.setAttribute("user_dao", userDao);// 
				session.setAttribute("candidate_dao", candidateDao);//
				// continue to role based authorization
//				
				if (user.getRole().equals("voter")) {
					// => voter login --> check the voting status
					if (user.isStatus()) // => already voted --> redirect to logout page
						response.sendRedirect("logout");// alredy voted candidate  // call doget method
					else // voter : not yet voted --> redirect to candidate list page
						response.sendRedirect("candidate_list");// client pool technique 
					/*
					 * WC - 1. clears / empties the PW's buffer 2. sends temp redirect response - SC 302
					 * , Header - 1. Location="candidate_list", 2. Set-Cookie - cookie name:
					 * JSESSIONID -value -alphanumeric random string unique per client response body
					 * -empty 3. Client browser -checks privacy settings cookies blocked -- cookies
					 * won't be stored--can't remember the client accepted -- cookie age --def value
					 * -1 => saves it in cache(cookie storage) 4. client browser - sends NEXT request
					 * (redirect) URL -http://host:port/day3.1/candidate_list method - GET -->
					 * CandidateList Servlet + adds the cookie in request header
					 */

				} else {
					// admin login -- redirect the clnt to admin page in NEXT request coming from
					// the clnt
					response.sendRedirect("admin");
				}

			}

		} // JVM : pw.close --> flush --> render/commits the response
		catch (Exception e) {
			// inform the WC about the exc
			throw new ServletException("err in servicing " + getClass(), e);
		}

	}

}
// client send request then get method is called