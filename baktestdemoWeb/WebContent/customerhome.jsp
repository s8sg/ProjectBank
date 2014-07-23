<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<script language="JavaScript1.4" type="text/javascript">
<!--
function jsPlay(soundobj) {
 var thissound= eval("document."+soundobj);
 try {
     thissound.Play();
 }
 catch (e) {
     thissound.DoPlay();
 }
}
//-->
</script>

<script language="javascript" type="text/javascript">
<!--
function MM_swapImgRestore() {
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() {
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) {
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() {
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function logOut()
{
	 document.forms["hiddenform"].submit();
}

//-->
</script>
</head>
<body background="resource/images/Coins.jpg">
<%! String heading=null; 
	String userId=null;
%>
<% Object sobj = session.getAttribute("Name"); 
   String uid = sobj.toString();
%>
<% 
   heading  = "Welcome User: ";
   userId = "User ID: ";
%>
<div id="text1" style="position:absolute; overflow:hidden; left:83px; top:43px; width:284px; height:48px; z-index:0">
<div class="wpmd">
<div><font class="ws11"><B><% out.println(heading); out.println(CheckMethods.getnamebyuserid(uid)); %>
</br>
<%
 out.println(userId + uid);
%>
</B></font></div>
</div></div>

<div id="nav10d" style="position:absolute; left:90px; top:110px; z-index:1"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('nav10','','resource/images/customerhome/nav24716330a.gif',1)"  href="cviewaccount.html"><img name="nav10"  alt="" border=0 src="resource/images/customerhome/nav24716330i.gif"></a></div>
<div id="nav11d" style="position:absolute; left:90px; top:165px; z-index:1"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('nav11','','resource/images/customerhome/nav24716331a.gif',1)"  href="changepassword.html"><img name="nav11"  alt="" border=0 src="resource/images/customerhome/nav24716331i.gif"></a></div>
<div id="nav12d" style="position:absolute; left:90px; top:220px; z-index:1"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('nav12','','resource/images/customerhome/nav24716332a.gif',1)"  href="fundtransfer.html"><img name="nav12"  alt="" border=0 src="resource/images/customerhome/nav24716332i.gif"></a></div>
<div id="nav13d" style="position:absolute; left:90px; top:275px; z-index:1"><a onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('nav13','','resource/images/customerhome/nav24716333a.gif',1)"  onclick="document.getElementById('hiddenform2').submit();" ><img name="nav13"  alt="" border=0 src="resource/images/customerhome/nav24716333i.gif"></a></div>

<div id="image1" style="position:absolute; overflow:hidden; left:360px; top:50px; width:24px; height:24px; z-index:2"><img src="resource/images/customerhome/login.png" alt="" title="" border=0 width=24 height=24></div>

<form id="hiddenform" method="get" action="Logout" style="margin:0px">
<input type="hidden" name="sname" id="sn" value="Name"></input>
</form>

<form id="hiddenform2" method="get" action="ViewTransactionHistory.jsp" style="margin:0px">
<input type="hidden" name="sname2" id="sn" value="Name"></input>
</form>


<button name="formbutton1" type="button" onclick="logOut()" style="position:absolute;left:387px;top:50px;width:90px;z-index:4">Logout</button>
</body>
</html>