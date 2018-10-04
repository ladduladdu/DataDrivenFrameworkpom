package com.qa.pom.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import com.qa.pom.Util.TestUtil;
import com.qa.pom.constatnts.base.testBase;
import com.qa.pom.pages.HomePage;
import com.qa.pom.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;

public class LoginPageTest extends testBase {
	Logger log = Logger.getLogger(LoginPageTest.class);
	LoginPage lp;
	HomePage homePage;
	TestUtil tu;
	ExtentReports extent;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info(
				"****************************** Starting test cases execution  *****************************************");
		initalization();
		lp = new LoginPage();
		tu = new TestUtil();

	}

	@Test(priority = 0)
	public void loginPageTitleTest() {
		String title = lp.validatLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	@Test(priority = 1)
	public void crmImageTest() {
		boolean flag = lp.validateCrmImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
