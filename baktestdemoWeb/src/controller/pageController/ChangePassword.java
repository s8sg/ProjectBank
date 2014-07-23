package controller.pageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheckMethods;
import dao.InsertMethods;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String soldpass = request.getParameter("opass");
		String snewpass = request.getParameter("npass");
		HttpSession session = request.getSession(true);
		Object sobj = session.getAttribute("Name");
		String uid = sobj.toString();
		String opass = CheckMethods.getoldpassword(uid);
		if(opass.equals(soldpass))
		{
			if(InsertMethods.setnewpassword(snewpass,uid))
			{
				pw.println("<b>Password successfully changed</b>");
			}
			else
			{
				pw.println("<b>Problem in setnewpassword.</b>");
			}
			
		}
		else
		{
			pw.println("<b>Wrong 'Old Password' Given.</b>");
		}
		pw.println("</br></br><a href=\"customerhome.jsp\"><b>Go Back</b></a>");
	}

}
