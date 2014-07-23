package controller.pageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CheckMethods;

/**
 * Servlet implementation class ViewAccountDetailsByAcNo
 */
public class ViewAccountDetailsByAcNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAccountDetailsByAcNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String acno = request.getParameter("acno");
		pw.println(acno);
		pw.println(CheckMethods.checkacnoinaccount(acno));
		if(CheckMethods.checkacnoinaccount(acno))
		{
			request.getRequestDispatcher("accountdetailsbyacno.jsp").forward(request, response);
		}
		else
		{
			pw.println("<h1>Error: Wrong Account No</h1>");
			pw.println("<a href=\"macountviewbyacno.html\">Go Back</a>");
		}
	}

}
