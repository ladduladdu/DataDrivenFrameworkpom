package com.qa.pom.constatnts.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.pom.Util.TestUtil;
public class testBase {	
	public static WebDriver driver;
	public static Properties  prop;	
	public testBase()
	{
		try {		
			prop=new Properties();		
			FileInputStream fi=new FileInputStream("D:\\eclipse\\DataDrivenFrameWorkWithPOM\\src\\main\\java\\com\\qa\\pom\\Properties\\constants.properties");
			prop.load(fi);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		public static void initalization()
		{
			String browserName=prop.getProperty("browser");
			
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
				driver=new ChromeDriver();
			} else if (browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
				driver=new FirefoxDriver();	
		}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_TimeOut, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
	}

}
