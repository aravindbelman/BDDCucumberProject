package com.LegacyApplication.PageMethods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import org.apache.log4j.Logger;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class DatabaseConnectionandSqlQueries extends TestBase {
	
	public static final Logger log=Logger.getLogger(DatabaseConnectionandSqlQueries.class.getName());
	
	        //declare Jdbc Objects
		public static Connection con=null;
		public static Statement stmt= null;
		public static ResultSet rs=null;
		public static String updated_date;
		public static String sub_id;
		public static String effective_date;
	
	public static void connect_to_database() throws ClassNotFoundException, SQLException, IOException
	{   
		//Create a variable for Connection string
		load_data();
		String connectionUrl=OR.getProperty("testsql_connectionstring");
		System.out.println(connectionUrl);
		
		//Establish the Connection
		Class.forName(OR.getProperty("connection_establishment"));
		con= DriverManager.getConnection(connectionUrl);
		System.out.println("Connection Established");
	}
	
	public static void update_effdate_newsubmission(String submission_id, int row_num) throws SQLException, IOException, InterruptedException, ParseException
	{
		
		stmt=con.createStatement(); 
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_in_seconds(5);
		rs=stmt.executeQuery("select * from dbo.Submissions where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");
		//rs=stmt.executeQuery("select * from dbo.Submissions where SubmissionID='QAA01473855-1'");
		
		while(rs.next())
		{
			sub_id=rs.getString("SubmissionID");
			System.out.println("The submission id fetched from data base record is "+sub_id);
			
			String name=rs.getString("ApplicantName");
			System.out.println("The applicant name is "+name);
			
			effective_date=rs.getString("EffectiveDate");
			System.out.println("The application effective date is "+effective_date);
			
		}
		
		updated_date=GenericMethods.update_current_date("yyyy-MM-dd HH:mm:ss",-1,0,45,0,0,0);
		stmt.executeUpdate("update dbo.Submissions set EffectiveDate='"+updated_date+"'where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");
		System.out.println("The updated Effective Date for new submission in database is "+updated_date);
		/*stmt.executeUpdate("update dbo.Submissions set Create_date='"+updated_date+"'where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");
		System.out.println("The updated Created Date for new submission in database is "+updated_date);*/
	 }
	
	public static void update_effdate_renewalsubmission(String submission_id, int row_num) throws SQLException, IOException, InterruptedException, ParseException
	{
		
		stmt=con.createStatement(); 
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_in_seconds(5);
		rs=stmt.executeQuery("select * from dbo.Submissions where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");	
		while(rs.next())
		{
			sub_id=rs.getString("SubmissionID");
			System.out.println("The submission id fetched from data base record is "+sub_id);
			
			String name=rs.getString("ApplicantName");
			System.out.println("The applicant name is "+name);
			
			effective_date=rs.getString("EffectiveDate");
			System.out.println("The application effective date is "+effective_date);
			
		}
		
		updated_date=GenericMethods.update_current_date("yyyy-MM-dd HH:mm:ss",0,0,45,0,0,0);
		stmt.executeUpdate("update dbo.Submissions set EffectiveDate='"+updated_date+"'where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");
		System.out.println("The updated Effective Date for Renewal Submission in database is "+updated_date);
		/*stmt.executeUpdate("update dbo.Submissions set Create_date='"+updated_date+"'where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");
		System.out.println("The updated Created Date for Renewal Submission in database is "+updated_date);*/
		
	 }
	
	public static void reminder_email(int reminder_days,String submission_id, int row_num) throws SQLException, IOException, InterruptedException, ParseException
	{
		
		stmt=con.createStatement(); 
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_in_seconds(5);
		rs=stmt.executeQuery("select * from dbo.Submissions where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");
		//rs=stmt.executeQuery("select * from dbo.Submissions where SubmissionID='QAA01473855-1'");
		
		while(rs.next())
		{
			sub_id=rs.getString("SubmissionID");
			System.out.println("The submission id fetched from data base record is "+sub_id);
			
			String name=rs.getString("ApplicantName");
			System.out.println("The applicant name is "+name);
			
			effective_date=rs.getString("EffectiveDate");
			System.out.println("The application effective date is "+effective_date);
			
		}
		
		updated_date=GenericMethods.update_current_date("yyyy-MM-dd HH:mm:ss",-1,0,reminder_days,0,0,0);
		stmt.executeUpdate("update dbo.Submissions set EffectiveDate='"+updated_date+"'where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");
		System.out.println("The updated Effective Date for new submission in database is "+updated_date);
		stmt.executeUpdate("update dbo.Submissions set Create_date='"+updated_date+"'where SubmissionID='"+ExcelReader.get_row_data_from_col(submission_id, row_num)+"'");
		System.out.println("The updated Created Date for new submission in database is "+updated_date);
	 }
	
	

}



