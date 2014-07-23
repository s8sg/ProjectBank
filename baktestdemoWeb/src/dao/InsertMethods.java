package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import initconnection.*;
import entity_pojo.*;

public class InsertMethods {
	
	public static String addCustomer(CustomerInf customer)
	{
		try{	
		Connection conn = InitConnection.getConnection();
		PreparedStatement pst=conn.prepareStatement(AllStatement.insertcinf);
		/*
		System.out.println(customer.getName());
		System.out.println(customer.getEmail());
		System.out.println(customer.getAddress());
		System.out.println(customer.getDob());
		System.out.println(customer.getPhno());
		*/
		pst.setString(1, customer.getName());
		pst.setString(2, customer.getEmail());
		pst.setString(3, customer.getAddress());
		pst.setString(4, customer.getDob());
		pst.setString(5, customer.getPhno());
		int updtcnt = pst.executeUpdate();
		pst.close();
		if(updtcnt!=0)
		{
			//Getting the userid
			pst = conn.prepareStatement(AllStatement.getun);
			ResultSet rs = pst.executeQuery();	
			while(rs.next())
			{
				customer.setUserid(rs.getString("user_id"));
			}
			
			pst = conn.prepareStatement(AllStatement.insertunpass);
			pst.setString(1, customer.getUserid());
			pst.setString(2, customer.getPassword());
			updtcnt = pst.executeUpdate();
			if(updtcnt!=0)
				return customer.getUserid();
			else
				throw new Exception("updateCount to table userlogindetails is '0'");
		}
		else{throw new Exception("updateCount to table customer is '0'");}
		
		}catch(Exception e){System.out.println("Error in InsertMethods-addCustomer: " + e.getMessage());return null;}
	}
	
	
	public static String addAccount(AccountInf account)
	{
		try{

		Connection conn = InitConnection.getConnection();
		PreparedStatement pst=conn.prepareStatement(AllStatement.insertainf); //acc_type,opendate,balance,branch
		pst.setString(1, account.getAcc_type());
		pst.setString(2, account.getOpendate());
		pst.setString(3, account.getBalance());
		pst.setString(4, account.getBranch());
		int updtcnt = pst.executeUpdate();
		pst.close();
		if(updtcnt!=0)
		{
			//Getting the accno
			pst = conn.prepareStatement(AllStatement.getan);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				account.setAcc_no(rs.getString("acc_no"));
			}
		
			pst = conn.prepareStatement(AllStatement.insertunacno);
			pst.setString(1, account.getUser_id());
			pst.setString(2, account.getAcc_no());
			updtcnt = pst.executeUpdate();
			if(updtcnt!=0)
				return account.getAcc_no();
			else
				throw new Exception("updateCount to table useraccountdetails is '0'");
		}
		else{throw new Exception("updateCount to table account is '0'");}
		
		}catch(Exception e){System.out.println("Error in InsertMethods-addAccount: " + e.getMessage());return null;}
	}
	
	public static boolean setnewpassword(String npass,String uid)
	{
		try{
		Connection conn = InitConnection.getConnection();
		PreparedStatement pst=conn.prepareStatement(AllStatement.updatepass);
		pst.setString(1, npass);
		pst.setString(2, uid);
		int updtcnt = pst.executeUpdate();
		if(updtcnt!=0)
		{
		return true;
		}
		else
			throw new Exception("updateCount to table useraccountdetails for change pass is '0'");
		}catch(Exception e){System.out.println("Error in InsertMethods-setnewpassword: " + e.getMessage());return false;}
	}
	
	public static boolean transferAmount(String dacno,String cacno,int amount)
	{
	try{
		Connection conn = InitConnection.getConnection();
		PreparedStatement pst1 = conn.prepareStatement(AllStatement.getamountbyacno);
		PreparedStatement pst2 = conn.prepareStatement(AllStatement.updatebalance);
		pst1.setString(1, dacno);
		ResultSet rs = pst1.executeQuery();
		String dbalance = null;
		while(rs.next())
		{
			dbalance = rs.getString("balance");
		}
		int db = Integer.parseInt(dbalance);
		db = db - amount;
		Integer dbal = db;
		dbalance = dbal.toString();
		pst2.setString(1, dbalance);
		pst2.setString(2, dacno);
		int updtcnt = pst2.executeUpdate();
		if(updtcnt==0){throw new Exception("update count to dacno is 0");}
		pst1.setString(1, cacno);
		rs = pst1.executeQuery();
		String cbalance = null;
		while(rs.next())
		{
			cbalance = rs.getString("balance");
		}
		int cb = Integer.parseInt(cbalance);
		cb = cb + amount;
		Integer cbal = cb;
		cbalance = cbal.toString();
		pst2.setString(1, cbalance);
		pst2.setString(2, cacno);
		updtcnt = pst2.executeUpdate();
		if(updtcnt==0){throw new Exception("update count to cacno is 0");}
		
			return true;
		}catch(Exception e){System.out.println("Error in InsertMethods-transferAmount: " + e.getMessage());return false;}
	}
	
	public static String addfundTransferdetailsintable(String uid,String dacno,String cacno,String amount)
	{
		try{
		Connection conn = InitConnection.getConnection();
		PreparedStatement pst = conn.prepareStatement(AllStatement.insertninf);
		pst.setString(1, uid);
		pst.setString(2, dacno);
		pst.setString(3, cacno);
		pst.setString(4, amount);
		pst.setString(5, Calendar.getInstance().getTime().toString());
		int updtcnt = pst.executeUpdate();
		if(updtcnt != 0)
		{
			String tid = null;
			pst = conn.prepareStatement(AllStatement.gettid);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				tid = rs.getString("tid");
			}
			return tid;
		}
		else
			throw new Exception("Error: update count to addfundTransferdetailsintable is zero");
		}catch(Exception e){System.out.println(e.getMessage());return null;}
	}
}
