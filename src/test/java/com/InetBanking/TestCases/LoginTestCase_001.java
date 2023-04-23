package com.InetBanking.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.InetBanking.pageObject.LoginPage;

public class LoginTestCase_001 extends BaseClass {
	
	@Test
	public void loginTest() throws Throwable
	{
		
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		Reporter.log("Entered UserName",true);
		
		lp.setPassword(password);
		Reporter.log("Entered password",true);
		
		lp.clickSubmit();
		
//		Thread.sleep(5000);
//		System.out.println(driver.getTitle().toString());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Reporter.log("Login test passed");
		}
		else
		{
			capturescreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			Reporter.log("Login test failed");
		}
	}
	

}
