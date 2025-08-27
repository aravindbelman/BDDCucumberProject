package com.LegacyApplication.AutoRenewBrokerFee;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.LegacyApplication.PageMethods.DatabaseConnectionandSqlQueries;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC025_DatabaseConnection extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC025_DatabaseConnection.class.getName());
	
	@Test
	public static void connect_to_database() throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{   
		DatabaseConnectionandSqlQueries.connect_to_database();
		DatabaseConnectionandSqlQueries.update_effdate_newsubmission("Submission Id", 4);
		DatabaseConnectionandSqlQueries.update_effdate_renewalsubmission("Renewal Submission Id", 4);
	}
}


