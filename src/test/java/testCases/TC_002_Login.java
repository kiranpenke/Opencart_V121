package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.Login_Page;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass 
{

	@Test(groups= {"sanity","master"})
	public void test_Login()
	{
		logger.info(" Starting TC_002_Login ");
		
		try
		{
			driver.get(bg.getString("appURL"));
			logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			hp.clickLogin();
			logger.info("Clicked on Login ");
			
            Login_Page lp=new Login_Page(driver);
			
			lp.setEmail(bg.getString("email"));
			logger.info("Provided Email ");
			
			lp.setPassword(bg.getString("password"));
			logger.info("Provided Password ");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
			
			
			boolean targetpage=lp.isMyAccountPageExists();
			
			if(targetpage)
			{
				logger.info("Login Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed ");
				captureScreen(driver, "test_Login"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		}	
		catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_Login ");
		
	}
	
	
}

