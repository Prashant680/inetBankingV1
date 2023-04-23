package com.InetBanking.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.InetBanking.Utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationUrl();
	public String password=readconfig.getPassword();
	public String userName=readconfig.getUserName();
	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
	        option.addArguments("--remote-allow-origins=*");

	        WebDriverManager.chromedriver().setup();
	          driver = new ChromeDriver(option);
	}
	
		else if(br.equals("internetExplorer"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(baseURL);
		}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void capturescreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshot/"+ tname+ ".png");
		FileUtils.copyFile(src, target);
		Reporter.log("Screenshot is taken");
	}
			
}
