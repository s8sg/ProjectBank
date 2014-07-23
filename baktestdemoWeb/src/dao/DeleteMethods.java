package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;



import initconnection.InitConnection;

public class DeleteMethods {
	
	public static String deleteAccount(String accno)
	{
		try{
			Connection conn = InitConnection.getConnection();
			PreparedStatement pst=conn.prepareStatement(AllStatement.deleteainf);
			pst.setString(1, accno);
			int updtcnt = pst.executeUpdate();
			if(updtcnt!=0)
			{
				String username = CheckMethods.findUnByAcno(accno);//Getting the username
				pst = conn.prepareStatement(AllStatement.deleteunacno);
				pst.setString(1, accno);
				updtcnt = pst.executeUpdate();
				if(updtcnt!=0)
				{
					System.out.println("Userid : " + username);
					boolean status = CheckMethods.findAcnoByUn(username);
					if(status==false)
					{
						status = deleteUserInf(username);
						if(status==true)
						{
							return accno;
						}
						else
						{
							throw new Exception("Problem in deleteUserInf");
						}
					}
				
				}
				else
				{
					throw new Exception("UpdateCount for delete_uname_acno is '0'");
				}
			}
			else
			{
				throw new Exception("Account No. Not Found");
			}
		}
		catch(Exception e){System.out.println("Error in DeleteMethods: " + e.getMessage());return e.getMessage();}
		return accno;
		
	}
	
	public static boolean deleteUserInf(String username)
	{
		try{
		Connection conn = InitConnection.getConnection();
		PreparedStatement pst=conn.prepareStatement(AllStatement.deletecinf);
		pst.setString(1, username);
		int updtcnt = pst.executeUpdate();
		System.out.println("UpdateCount deletecinf: " + updtcnt );	
			if(updtcnt>=1)
			{
			pst = conn.prepareStatement(AllStatement.deleteunpass);
			pst.setString(1, username);
			updtcnt = pst.executeUpdate();
			System.out.println("UpdateCount deleteunpass: " + updtcnt );
				if(updtcnt>=1)
				{
				return true;
				}
				else
				{
					throw new Exception("Update Count for Delete_un_pass is '0'");
				}
			}
			else{
			throw new Exception("Update Count for Delete_c_inf is '0'");
			}
		}catch(Exception e){System.out.println("Error in delete user inf: " + e.getMessage());return false;}
	}
}
