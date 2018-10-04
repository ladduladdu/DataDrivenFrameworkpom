package com.qa.pom.testCases;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pom.Util.TestUtil;
import com.qa.pom.constatnts.base.testBase;
import com.qa.pom.pages.ContactsPage;
import com.qa.pom.pages.HomePage;
import com.qa.pom.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
public class HomePageTest extends testBase
{
	Logger log=Logger.getLogger(HomePageTest.class);
	HomePage hp;
	LoginPage lp;
	TestUtil tu;
	ContactsPage cp;
  ExtentReports extent;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeTest
	 public void setExtent()
	 {
		extent=new ExtentReports(System.getProperty("user+dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("host name", "Arjun windows");
		extent.addSystemInfo("user name", "Arjun");
		extent.addSystemInfo("Environment", "QA");
	 }

	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}

	@BeforeMethod
	public void setUp()
	{
		initalization();
	tu=new TestUtil();
	cp=new ContactsPage();
		lp=new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(enabled=true)
	public String validateHomePageTitle()
	{
		String Homepagetitle= hp.verifyHomePageTitle();
		Assert.assertEquals(Homepagetitle, "CRMPRO","Home page title not matched");
		return Homepagetitle;
	}
	@Test(enabled=true)
	public boolean validateUserName()
	{ 
		return hp.verifyCorrectUserName();
	}	
	@Test(enabled=true)
	public void clickOnContacts()
	{
		hp.clickonContactsLink();
	}
	@Test(enabled=true)
	public void clickOnNewContactLink()
	{
		hp.clickOnNewContactLink();
	}
	
	@Test(enabled=true)
	public void clickOnDeals()
	{
		hp.clickonDealsLink();
	}
	@Test(enabled=true)
	public void clickOnTasks()
	{
		hp.clickonTasksLink();
	}

	@AfterMethod
	public void  tearDown()
	{
		driver.quit();
	}
}
