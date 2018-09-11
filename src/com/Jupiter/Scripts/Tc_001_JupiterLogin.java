package com.Jupiter.Scripts;

import org.testng.annotations.Test;

import com.Jupiter.Application.Jupiter_Login;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;

public class Tc_001_JupiterLogin extends Jupiter_Login {
	Properties prop;

	@BeforeTest
	public void beforeTest() throws IOException {
		// Calling the browser method in Utility class.
		prop = readProperties();
		browser(prop.getProperty("url"));
	}

	@Test
	public void registration() throws IOException, InterruptedException {
		prop = readProperties();

		contacts();
		wait_implicit();
		type(prop.getProperty("foreName_id"), "abc");
		type(prop.getProperty("email_id"),"vivek.battala@yahoo.com");
		click(prop.getProperty("contacts_reg_submit"));
		wait_implicit();
		validate();

	}

	@AfterTest
	public void afterTest() {
	}

}
