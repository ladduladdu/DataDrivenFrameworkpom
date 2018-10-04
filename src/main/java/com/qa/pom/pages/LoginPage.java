package com.qa.pom.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.pom.constatnts.base.testBase;
public class LoginPage  extends testBase
{
	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement upwd;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]") WebElement signup;
	@FindBy(xpath="//img[contains(@class,'img-responsive')]") WebElement crm_logo;
public  LoginPage()
{
	PageFactory.initElements(driver, this);
}

public  String validatLoginPageTitle()
{
	 return driver.getTitle();
}
public boolean validateCrmImage()
{
	 return crm_logo.isDisplayed();
}
public HomePage login(String uid,String pwd) 
{
	uname.sendKeys(uid);
	upwd.sendKeys(pwd);
	loginbtn.click();
	return new HomePage();	
}
}
