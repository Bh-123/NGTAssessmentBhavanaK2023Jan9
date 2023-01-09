package com.myntra.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.pages.CheckForBag;
import com.myntra.pages.SearchProductVerify;

public class AppTests {
	static WebDriver driver;
	SearchProductVerify product;
	CheckForBag bag;
	@BeforeMethod
	public void setUp() throws Exception {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				rootFolder + "\\src\\test\\resources\\webdriver_selenium\\chromedriver.exe");
		
		// Instantiate a ChromeDriver class.
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		product=new SearchProductVerify(driver);
		bag=new CheckForBag(driver);
		//driver.get("https://myntra.com");
	}
	@Test(priority=1)
	public void searchProductVerify() {
		product.launchApp();
		product.searchProduct();
		product.verifyResult();
	}
	@Test(priority=2)
	public void checkForBags() throws InterruptedException {
		bag.launchApp1();
		bag.login();
		bag.checkForBag();
		
		Assert.assertEquals(bag.getActualText(), bag.getExpectedText());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
