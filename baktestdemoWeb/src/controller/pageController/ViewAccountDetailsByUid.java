package controller.pageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

/**
 * Servlet implementation class ViewAccountDetailsByUid
 */
public class ViewAccountDetailsByUid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAccountDetailsByUid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String uid = request.getParameter("uid");
		if(CheckMethods.checkunincustomer(uid))
		{
			request.getRequestDispatcher("accountdetailsbyuserid.jsp").forward(request, response);
		}
		else
		{
			pw.println("<h1>Error: Wrong Username</h1>");
			pw.println("<a href=\"mviewbyusername.html\">Go Back</a>");
		}
	}

}
