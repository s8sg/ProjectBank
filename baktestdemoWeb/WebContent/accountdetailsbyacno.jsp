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
<% String acno = request.getParameter("acno"); 
   String query1 = "select user_id from useraccountdetails where acc_no=?";
   String query2 = "select * from account where acc_no =?";
%>
<div id="text1" style="position:absolute; overflow:hidden; left:123px; top:41px; width:296px; height:90px; z-index:0">
<div class="wpmd">
<div><font class="ws22">ACCOUNT DETAILS</font></div>
</div></div>

<div id="table1" style="position:absolute; left:116px; top:126px; width:650px; height:43px; z-index:1">
<div class="wpmd">
<TABLE bgcolor="#E4F0F5" border=2>
<TR bgcolor="#D5F7E2" valign=top>
<TD width=100><div class="wpmd">
<div><font class="ws12">USER_ID</font></div>
</div>
</TD>
<TD width=100><div class="wpmd">
<div><font class="ws12">ACC-NO</font></div>
</div>
</TD>
<TD width=100><div class="wpmd">
<div><font class="ws12">ACC_TYPE</font></div>
</div>
</TD>
<TD width=100><div class="wpmd">
<div><font class="ws12">OPEN_DATE</font></div>
</div>
</TD>
<TD width=100><div class="wpmd">
<div><font class="ws12">BRANCH</font></div>
</div>
</TD>
<TD width=100><div class="wpmd">
<div><font class="ws12">BALANCE</font></div>
</div>
</TD>
</TR>
<% Connection conn =  InitConnection.getConnection();
	try{
		PreparedStatement pst1=conn.prepareStatement(query1);
		PreparedStatement pst2=conn.prepareStatement(query2);
		pst1.setString(1,acno);
		pst2.setString(1,acno);
		ResultSet rs1 = pst1.executeQuery();
		ResultSet rs2 = pst2.executeQuery();
		while(rs1.next()) 
		{%>
		<tr valign=top>
		<TD width=100><div class="wpmd">
		<div><font class="ws12"><% out.println(rs1.getString("user_id")); %></font></div>
		</div>
		</TD>
		<% while(rs2.next()){ %>
		<TD width=100><div class="wpmd">
		<div><font class="ws12"><% out.println(acno); %></font></div>
		</div>
		</TD>
		<TD width=100><div class="wpmd">
		<div><font class="ws12"><% out.println(rs2.getString("acc_type")); %></font></div>
		</div>
		</TD>
		<TD width=100><div class="wpmd">
		<div><font class="ws12"><% out.println(rs2.getString("opendate")); %></font></div>
		</div>
		</TD>
		<TD width=100><div class="wpmd">
		<div><font class="ws12"><% out.println(rs2.getString("balance")); %></font></div>
		</div>
		</TD>
		<TD width=100><div class="wpmd">
		<div><font class="ws12"><% out.println(rs2.getString("branch")); %></font></div>
		</div>
		</TD>
		<%} %>
    	</tr> 
    	<% }%>
<%		}catch(Exception e){System.out.println("Exception in Statement: " + e.getMessage());} %>
</TABLE>
</div>
</br></br>
<input type="button"  onClick="window.print()" value="Print"/> </br></br>
<% if(request.getParameter("id").equals("m")) {%>
<a href="mviewaccount.html"><b>GO BACK</b></a>
<%} else{ %>
<a href="cviewaccount.html"><b>GO BACK</b></a>
<%} %>
</div>

</body>
</html>