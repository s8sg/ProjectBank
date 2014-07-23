package dao;

 class AllStatement {
	//All check statement
	 	//Customer inf
	 		static String checkunpass= "select * from userlogindetails  where user_id=? and password=?";
	 		static String checkunacno= "select user_id from useraccountdetails where acc_no =?";
	 		static String checkacnoun= "select * from useraccountdetails where user_id =?";
	 		static String getun = "select user_id from customer";
	 		static String getan = "select acc_no from account";
	 		static String checkunincustomer = "select * from customer where user_id =?";
	 		static String checkacnoinaccount = "select * from account where acc_no =?";
	 		static String getpassbyuid = "select password from userlogindetails where user_id=?";
	 	//Account inf:
	 		static String getacbyuid = "select acc_no from account where user_id =?";
	 		static String checkuidacnopair = "select * from useraccountdetails where user_id=? and acc_no=?";
	 		static String getamountbyacno = "select balance from account where acc_no =?";
	
	//All insertion statement
		//Customer inf
			static String insertcinf = "insert into customer(name,e_mail,user_id,address,dob,phno) values(?,?,unseq.nextval,?,?,?)";
			static String insertunpass = "insert into userlogindetails(user_id,password) values(?,?)";
		//Account inf
			static String insertainf = "insert into account(acc_no,acc_type,opendate,balance,branch) values(anseq.nextval,?,?,?,?)";
			static String insertunacno = "insert into useraccountdetails(user_id,acc_no) values(?,?)";
		//Transaction inf
			static String insertninf = "insert into transactiondetails values(tnseq.nextval,?,?,?,?,?)";
			static String gettid = "select tid from transactiondetails";
			
	//All delete statements
		//Account inf
			static String deleteainf = "delete from account where acc_no =?";
			static String deleteunacno = "delete from useraccountdetails where acc_no =?";
		//Customer inf	
			static String deletecinf = "delete from customer where user_id =?";
			static String deleteunpass = "delete from userlogindetails where user_id =?";
	//All update statements
		//Customer inf
			static String updatepass = "update userlogindetails set password =? where user_id =?";
			
		//Account inf
			static String updatebalance = "update account set balance =? where acc_no =?";
 }
