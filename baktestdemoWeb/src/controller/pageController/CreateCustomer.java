package controller.pageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

import dao.InsertMethods;

import entity_pojo.CustomerInf;
import entity_pojo.AccountInf;
/**
 * Servlet implementation class CreateCustomer
 */
public class CreateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	String default_pass;
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		default_pass = this.getInitParameter("default_pass");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Setting Customer Pojo
		PrintWriter pw = response.getWriter();
		CustomerInf customer = new CustomerInf();
		String name = request.getParameter("fname") + " " + request.getParameter("lname");
		customer.setName(name);
		customer.setEmail(request.getParameter("email"));
		customer.setAddress(request.getParameter("addrs"));
		customer.setDob(request.getParameter("dob"));
		customer.setPhno(request.getParameter("pno"));
		customer.setPassword(default_pass);
		String user_id = InsertMethods.addCustomer(customer);
		if(user_id==null)
		{
			pw.println("Error in AddCustomer");
		}
		else
		{
		// Setting Account Pojo
		AccountInf account = new AccountInf();
		account.setUser_id(user_id);
		account.setAcc_type(request.getParameter("acctype"));
		account.setBalance(request.getParameter("initbalance"));
		account.setBranch(request.getParameter("branch"));
		account.setOpendate(Calendar.getInstance().getTime().toString());
		String accNo = InsertMethods.addAccount(account);
		if(accNo == null)
		{
			pw.println("Error in AddAccount with user_id:" + user_id);
		}
		else
			pw.println("<h2>Customer Successfully Created</h2> </br> New Customer user_id: " + user_id + "</br>" + "New Account No.: " + accNo);
		}
		pw.println("</br></br><a href=\"managerhome.html\">Go Back to Home Page</a>");
	}

}
