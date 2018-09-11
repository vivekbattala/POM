package com.Jupiter.Application;

import java.io.IOException;
import java.util.Properties;

import com.Jupiter.Helper.Utility;

public class Jupiter_Login extends Utility{

	public void contacts() throws IOException {
		// TODO Auto-generated constructor stub
		Properties prop=readProperties();
		click(prop.getProperty("contacts"));
	}
	public void validate() throws IOException, InterruptedException {
		Properties prop=readProperties();
		String loc_name_err=getTextbyXpath(prop.getProperty("forenameError"));
		String loc_email_err=getTextbyXpath(prop.getProperty("emailError"));
		String loc_msg_err=getTextbyXpath(prop.getProperty("msgError"));
		int anyError=(loc_name_err+loc_email_err+loc_msg_err).length();
		
		System.out.println(anyError);
		
		if (anyError>0)
		{			
			closeBrowser();
		}
		
	}

	public void Assert() {

	}
}
