package controller.pageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

/**
 * Servlet implementation class CloseAccount
 */
public class CloseAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String accno = DeleteMethods.deleteAccount(request.getParameter("acno"));
		if(accno.equals(request.getParameter("acno")))
		{
			pw.println("Account '" + accno + "' successfully Deleted");
		}
		else
		{
			pw.println("Error in Delete Operation : " + accno);
		}
		pw.println("</br><a href=\"managerhome.html\">Return to Manager Home</a>");
	}

}
