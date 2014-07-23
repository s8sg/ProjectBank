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
 * Servlet implementation class FundTransfer
 */
public class FundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String dacno = request.getParameter("dacno");
		String cacno = request.getParameter("cacno");
		String amount = request.getParameter("amount");
		String uid = session.getAttribute("Name").toString();
		PrintWriter pw = response.getWriter();
		if(dacno.equals(cacno) != true)
		{
			if(CheckMethods.checkuidacnopair(uid, dacno))
			{
				System.out.println("Enter");
				if(CheckMethods.checkacnoinaccount(cacno))
				{
					System.out.println("Before");
					boolean status1 = InsertMethods.transferAmount(dacno,cacno,Integer.parseInt(amount));
					System.out.println("middle");
					String status2 = InsertMethods.addfundTransferdetailsintable(uid,dacno,cacno,amount);
					System.out.println("after");
					if(status1==true && status2!=null)
					{
						pw.println("<b>Tranjaction successfully Complete</b>");
						pw.println("<b>Tranjaction Id:" + status2 +"</b>");
					}
					else
					{
						pw.println("<b>Problem in : InsertMethods.transferAmount</b>");
					}
				}
				else{
					pw.println("<b>The Credit Account No Not Valid</b>");
				}
			}
			else
			{
				pw.println("<b>The Debit Account No Not Valid</b>");
			}
		
		}else{pw.println("<b>Both accountno is same </b>");};
		pw.println("</br></br><a href=\"fundtransfer.html\"><b>Go Back</b></a>");
	}

}
