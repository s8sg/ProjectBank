package controller.pageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheckMethods;

/**
 * Servlet implementation class ViewAccountByAcNoCustomer
 */
public class ViewAccountByAcNoCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAccountByAcNoCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String sendacno = request.getParameter("acno");
		String uid = session.getAttribute("Name").toString();
		PrintWriter pw = response.getWriter();
		if(CheckMethods.checkuidacnopair(uid, sendacno))
		{
			request.getRequestDispatcher("accountdetailsbyacno.jsp").forward(request, response);
		}
		else
		{
			pw.println("<b>The Account No Not Valid</b>");
		}

		pw.println("</br></br><a href=\"cviewaccount.html\"><b>Go Back</b></a>");
	}

}
