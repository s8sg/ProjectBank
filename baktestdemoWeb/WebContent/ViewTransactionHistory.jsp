<%@ page import="initconnection.*" import ="java.sql.Connection" import ="java.sql.PreparedStatement" import ="java.sql.ResultSet"%>

<html>
<head>
<title>Insert title here</title>
<style type="text/css">
/*----------Text Styles----------*/
.ws6 {font-size: 8px;}
.ws7 {font-size: 9.3px;}
.ws8 {font-size: 11px;}
.ws9 {font-size: 12px;}
.ws10 {font-size: 13px;}
.ws11 {font-size: 15px;}
.ws12 {font-size: 16px;}
.ws14 {font-size: 19px;}
.ws16 {font-size: 21px;}
.ws18 {font-size: 24px;}
.ws20 {font-size: 27px;}
.ws22 {font-size: 29px;}
.ws24 {font-size: 32px;}
.ws26 {font-size: 35px;}
.ws28 {font-size: 37px;}
.ws36 {font-size: 48px;}
.ws48 {font-size: 64px;}
.ws72 {font-size: 96px;}
.wpmd {font-size: 13px;font-family: Arial,Helvetica,Sans-Serif;font-style: normal;font-weight: normal;}
/*----------Para Styles----------*/
DIV,UL,OL /* Left */
{
 margin-top: 0px;
 margin-bottom: 0px;
}
</style>

</head>
<body background="resource/images/Coins.jpg">
<%  
	Connection conn = InitConnection.getConnection();
    String uid = session.getAttribute("Name").toString(); 
	String query = "select * from transactiondetails where cid =?";
%>

<div id="text1" style="position:absolute; overflow:hidden; left:116px; top:37px; width:305px; height:90px; z-index:0">
<div class="wpmd">
<div><font class="ws22"><B>Transaction History</B></font></div>
</div></div>
<div id="table1" style="position:absolute; left:112px; top:110px; width:563px; height:47px; z-index:2">
<div class="wpmd">

<TABLE bgcolor="#E4F0F5" border=2 >
	<TR bgcolor="#D5F7E2" valign=top>
		<TD width=100><div class="wpmd">
		<div><font color="#000000" class="ws14"><B>Transaction Id</B></font></div>
		</div>
		</TD>
		<TD width=112><div class="wpmd">
		<div><font color="#000000" class="ws14"><B>Debit ACC_No</B></font></div>
		</div>
		</TD>
		<TD width=123><div class="wpmd">
		<div><font color="#000000" class="ws14"><B>Credit ACC_No</B></font></div>
		</div>
		</TD>
		<TD width=80><div class="wpmd">
		<div><font color="#000000" class="ws14"><B>Amount</B></font></div>
		</div>
		</TD>
		<TD width=104><div class="wpmd">
		<div><font color="#000000" class="ws14"><B>Transaction date</B></font></div>
		</div>
		</TD>
	</TR>
	
	<%
	try{
		PreparedStatement pst1=conn.prepareStatement(query);
		pst1.setString(1,uid);
		ResultSet rs = pst1.executeQuery();
		while(rs.next()) 
		{ %>
     	<tr valign=top>
     	
     	 <td width=100><div class="wpmd">
     	 <%out.println(rs.getString("tid"));%>
    	 </div>
    	 </td>
    	 <td width=112><div class="wpmd">
     	 <%out.println(rs.getString("FROM_ACC_NO"));%>
    	 </div>
    	 </td>
    	 <td width=123><div class="wpmd">
       	 <%out.println(rs.getString("TO_ACC_NO"));%>
    	 </div>
    	 </td>
    	 <td width=80><div class="wpmd">
     	 <%out.println(rs.getString("TAMOUNT"));%>
    	 </div>
    	 </td>
    	 <td width=104><div class="wpmd">
     	 <%out.println(rs.getString("TDATE"));%>
    	 </div>
    	 </td>
    	
    	</tr> 
    	<% 
    	}
		}catch(Exception e){System.out.println("Exception in Statement: " + e.getMessage());} %>
</TABLE>
</div>
</br></br>
<input type="button"  onClick="window.print()" value="Print"/> </br></br>
<a href="customerhome.jsp"><b>GO BACK</b></a>

</div>
</body>
</html>