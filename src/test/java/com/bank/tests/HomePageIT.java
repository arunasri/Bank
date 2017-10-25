package com.bank.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePagePO;

public class HomePageIT extends BaseIT {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeMethod(alwaysRun = true)
	public void SetUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.wellsfargo.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void testWellsFargo() throws Exception {
		// preconditions
		driver.get(baseUrl);
		//Search for jobs
		HomePagePO home = new HomePagePO(driver);
		home.searchTextfield.sendKeys("jobs wells fargo");
		home.searchButton.click();	
		//Job search results displayed 
		// verify search results title
		WebElement search = driver.findElement(By.id("skip"));
		Assert.assertEquals(true, search.isDisplayed());
		System.out.println("Search results displayed");
	
	}
	
	@Test(priority=2)
	public void testEnroll() throws Exception {
		 driver.get(baseUrl);
	   //click on enroll link
	   HomePagePO home1 = new HomePagePO(driver);
	   home1.enrollLink.click();
   }
	
		
//		EnrollPO enroll = new EnrollPO(driver);
//		enroll.continueButton.click();
//		enroll.homeLink.click();		
//		enroll.exitButton.click();
//	    enroll.wellsFargologo.click();
//		System.out.println("Logo link is clicked");
//		this.screenshot(driver,"home", "home_link.png");
	
	
	@Test(priority=3)
	public void testCareers() throws Exception {
		//open browser
		driver.get(baseUrl);
		HomePagePO home = new HomePagePO(driver);
		home.careersLink.click();
		//Verify page title is present
		WebElement careers = driver.findElement(By.id("skip"));
		Assert.assertEquals(true, careers.isDisplayed());
		System.out.println("careers title is present");
	
		
	}
	
		@AfterMethod
		@AfterClass(alwaysRun = true)
		public void tearDown() throws Exception {
			driver.close();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				Assert.fail(verificationErrorString);
			}
		}
}
