package controller.pageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;

/**
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    private String adminname;
    private String adminpass;
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		adminname=this.getInitParameter("adminuname");
		adminpass=this.getInitParameter("adminpass");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String senduid = request.getParameter("uname");
		String sendpass = request.getParameter("pwrd");
		HttpSession session  = request.getSession(true);
		if(senduid.equals(adminname) && sendpass.equals(adminpass))//Checking if manager
		{
			response.sendRedirect("managerhome.html");
		}
		else
		{
			String name=null;
			name = CheckMethods.loginCheck(senduid,sendpass);
			if(name!=null)
			{
				session.setAttribute("Name", senduid);
				request.getRequestDispatcher("customerhome.jsp").forward(request, response);	
				
				
			}
			else
			{
				pw.println("<h1>Error: Wrong Username-Password</h1>");
				pw.println("<a href=\"login.html\">Go Back To The Login Page</a>");
			}
			
		}
	}

}
