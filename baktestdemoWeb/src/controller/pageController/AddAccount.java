package controller.pageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CheckMethods;
import dao.InsertMethods;

import entity_pojo.AccountInf;

/**
 * Servlet implementation class AddAccount
 */
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean status = CheckMethods.checkunincustomer(request.getParameter("username"));
		PrintWriter pw = response.getWriter();
		if(status==true)
		{
		AccountInf account = new AccountInf();
		account.setBranch(request.getParameter("branch"));
		account.setAcc_type(request.getParameter("acctype"));
		account.setBalance(request.getParameter("initbalance"));
		account.setUser_id(request.getParameter("username"));
		account.setOpendate(Calendar.getInstance().getTime().toString());
		String accNo = InsertMethods.addAccount(account);
		if(accNo == null)
		{
			pw.println("Error in AddAccount with user_id:" + request.getParameter("username"));
		}
		else
			pw.println("<h2>Account Successfully Created</h2> </br> For Customer user_id: " + request.getParameter("username") + "</br>" + "New Accountno: " + accNo);
		}else{pw.println("<h2>Error: This customer (" + request.getParameter("username") +") does'nt exist</h2>");}
		pw.println("</br></br><a href=\"managerhome.html\">Go Back to Home Page</a>");
	}

}
