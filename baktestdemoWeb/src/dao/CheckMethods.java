package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import initconnection.*;

public class CheckMethods {
	
	public static String loginCheck(String userid,String password)
	{
		try{
			Connection conn = InitConnection.getConnection();
			PreparedStatement pst=conn.prepareStatement(AllStatement.checkunpass);
			pst.setString(1, userid);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			int count=0;
			while(rs.next())
			{
				count++;
			}
			if(count>=1)
			{
				String name = CheckMethods.getnamebyuserid(userid);
				return name;   
			}
			else
			{
				return null;
			}
			}catch(Exception e){
			System.out.println("Error in CheckMethods.loginCheck: " + e.getMessage());
			return null;
			}
	}
	
	public static String findUnByAcno(String accNo)
	{
		try{
			Connection conn = InitConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(AllStatement.checkunacno);
			pst.setString(1, accNo);
			ResultSet rs = pst.executeQuery();
			String username = null;
			while(rs.next())
			{
			username = rs.getString("user_id");
			}
			if(username==null){throw new Exception("Username is Null");}
			else
				return username;
		}catch(Exception e){System.out.println("Error in CheckMethods.findUnByAcno: " + e.getMessage());
		return null;}
	}
	
	public static boolean findAcnoByUn(String userId)
	{
		try{
			Connection conn = InitConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(AllStatement.checkacnoun);
			pst.setString(1, userId);
			ResultSet rs = pst.executeQuery();
			int rowcount = 0;
			while(rs.next()){rowcount++;}
			if(rowcount>=1)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}catch(Exception e){System.out.println("Error in CheckMethods.findUnByAcno: ");
		System.out.print(e.getMessage());
		return false;}
	}
	
	public static boolean checkunincustomer(String uid)
	{
		try{
		Connection conn = InitConnection.getConnection();
		PreparedStatement pst = conn.prepareStatement(AllStatement.checkunincustomer);
		pst.setString(1, uid);
		ResultSet rs = pst.executeQuery();
		int rowcount = 0;
		while(rs.next()){rowcount++;}
		if(rowcount>=1)
		{
			return true;
		}
		else
		{
			return false;
		}
		}catch(Exception e){System.out.println("Error in checkunincustomer : "+ e.getMessage());return false;}
	}
	
	public static boolean checkacnoinaccount(String acno)
	{
		try{
		Connection conn = InitConnection.getConnection();
		PreparedStatement pst = conn.prepareStatement(AllStatement.checkacnoinaccount);
		pst.setString(1, acno);
		ResultSet rs = pst.executeQuery();
		int rowcount = 0;
		while(rs.next()){rowcount++;}
		if(rowcount>=1)
		{
			return true;
		}
		else
		{
			return false;
		}
		}catch(Exception e){System.out.println("Error in checkacnoinaccount : "+ e.getMessage());return false;}
	}	
	
	public static String getnamebyuserid(String uid)
	{
		try{
		Connection conn = InitConnection.getConnection();
		PreparedStatement pst = conn.prepareStatement(AllStatement.checkunincustomer);
		pst.setString(1, uid);
		ResultSet rs = pst.executeQuery();
		String name=null;
		while(rs.next())
		{
		name=rs.getString("name");
		}

		return name;
		
		
		}catch(Exception e){System.out.println("Error in getnamebyuserid : "+ e.getMessage());return null;}
	}

	public static String getoldpassword(String uid)
	{
		try{
			Connection conn = InitConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(AllStatement.getpassbyuid);
			pst.setString(1, uid);
			ResultSet rs = pst.executeQuery();
			String pass=null;
			while(rs.next())
			{
			pass=rs.getString("password");
			}

			return pass;
			
			
			}catch(Exception e){System.out.println("Error in getoldpassword : "+ e.getMessage());return null;}
	}

	public static boolean checkuidacnopair(String uid,String acNo)
	{
		try{
			Connection conn = InitConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(AllStatement.checkuidacnopair);
			pst.setString(1, uid);
			pst.setString(2, acNo);
			ResultSet rs = pst.executeQuery();
			int rowcount = 0;
			while(rs.next()){rowcount++;}
			if(rowcount>=1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e){System.out.println("Error in getoldpassword : "+ e.getMessage());return false;}
	}
}
	


