package com.qa.pom.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.pom.constatnts.base.testBase;
public class HomePage extends testBase
{
	@FindBy(xpath="//td[contains(text(),'User: Arjun Arjun')]") WebElement usernameLabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]") WebElement contactsLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]") WebElement NewcontactsLink;
	@FindBy(xpath="//a[contains(text(),'Deals')]") WebElement dealsLink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]") WebElement tasksLink;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink()
	{
		  contactsLink.click();
		  return new ContactsPage();
	}
	public DealsPage clickonDealsLink()
	{
		  dealsLink.click();
		  return new DealsPage();
	}	
	public TasksPage clickonTasksLink()
	{
		  tasksLink.click();
		  return new TasksPage();
	}
	public void clickOnNewContactLink() {	
		Actions as=new Actions(driver);
		as.moveToElement(contactsLink).build().perform();
		NewcontactsLink.click();	
	}

}
