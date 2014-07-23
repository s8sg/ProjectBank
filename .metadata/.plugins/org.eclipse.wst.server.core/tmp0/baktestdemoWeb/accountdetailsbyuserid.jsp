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
<% String uid = request.getParameter("uid"); 
   int pagestat = 0;
   if(uid==null || uid=="")
   {
	   uid = session.getAttribute("Name").toString();
	   pagestat = 1;
   }
   String query1 = "select acc_no from useraccountdetails where user_id =?";
   String query2 = "select * from account where acc_no =?";
%>
<div id="text1" style="position:absolute; overflow:hidden; left:116px; top:37px; width:305px; height:90px; z-index:0">
<div class="wpmd">
<div><font class="ws22"><B>ACCOUNT DETAILS</B></font></div>
</div></div>

<div id="text2" style="position:absolute; overflow:hidden; left:116px; top:117px; width:150px; height:90px; z-index:1">
<div class="wpmd">
<div><font class="ws12">USER ID : <% out.print(uid);%></font></div>
</div></div>

<div id="table1" style="position:absolute; left:112px; top:177px; width:563px; height:47px; z-index:2">
<div class="wpmd">
<TABLE bgcolor="#E4F0F5" border=2 >
<TR bgcolor="#D5F7E2" valign=top>
<TD width=100><div class="wpmd">
<div><font color="#000000" class="ws14"><B>ACC_NO</B></font></div>
</div>
</TD>
<TD width=112><div class="wpmd">
<div><font color="#000000" class="ws14"><B>ACC_TYPE</B></font></div>
</div>
</TD>
<TD width=123><div class="wpmd">
<div><font color="#000000" class="ws14"><B>OPEN_DATE</B></font></div>
</div>
</TD>
<TD width=80><div class="wpmd">
<div><font color="#000000" class="ws14"><B>BRANCH</B></font></div>
</div>
</TD>
<TD width=104><div class="wpmd">
<div><font color="#000000" class="ws14"><B>BALANCE</B></font></div>
</div>
</TD>
</TR>
<% Connection conn =  InitConnection.getConnection();
	try{
		PreparedStatement pst1=conn.prepareStatement(query1);
		pst1.setString(1,uid);
		ResultSet rs1 = pst1.executeQuery();
		PreparedStatement pst2=conn.prepareStatement(query2);
		while(rs1.next()) 
		{%>
     	<tr valign=top>
     	<% String acNo = rs1.getString("acc_no"); %>
     	<td width=100><div class="wpmd">
     	<%out.println(acNo);%>
    	</div>
    	</td>
    	<% 
    	pst2.setString(1,acNo);  
    	ResultSet rs2 = pst2.executeQuery();
    	while(rs2.next()){
    	%>
    	<td width=112><div class="wpmd">
     	<%out.println(rs2.getString("acc_type"));%>
    	</div>
    	</td>
    	<td width=123><div class="wpmd">
     	<%out.println(rs2.getString("opendate"));%>
    	</div>
    	</td>
    	<td width=80><div class="wpmd">
     	<%out.println(rs2.getString("balance"));%>
    	</div>
    	</td>
    	<td width=104><div class="wpmd">
     	<%out.println(rs2.getString("branch"));%>
    	</div>
    	</td><% } %>
    	</tr> 
    	<% }%>
<% 		}catch(Exception e){System.out.println("Exception in Statement: " + e.getMessage());} %>
</TABLE>
</div>
</br></br>
<input type="button"  onClick="window.print()" value="Print"/> </br></br>
<% if (pagestat==1) { %>
<a href="cviewaccount.html"><b>GO BACK</b></a>
<%} else {%>
<a href="mviewaccount.html"><b>GO BACK</b></a>
<%} %>
</div>

</body>
</html>