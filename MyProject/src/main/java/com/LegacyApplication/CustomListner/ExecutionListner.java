package com.LegacyApplication.CustomListner;

import org.apache.log4j.Logger;
import org.testng.IExecutionListener;

import com.LegacyApplication.TestBase.TestBase;

public class ExecutionListner extends TestBase implements IExecutionListener {

	public static final Logger log=Logger.getLogger(ExecutionListner.class.getName());
	
	int startTime= ((int)System.currentTimeMillis()/1000)/60;
	
	@Override
	public void onExecutionStart() {
		
		
		log.info("The testNG started running the test scripts");
		
	}

	@Override
	public void onExecutionFinish() {
		
		log.info("The testNG finished running the test scripts and took around " + (((int)System.currentTimeMillis()/1000)/60-startTime) +" minutes");
		
	}

}
