package com.myntra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchProductVerify {
	static WebDriver driver;
	public SearchProductVerify(WebDriver driver){this.driver=driver;}
	public void launchApp() {
		driver.get("https://myntra.com");
	}
	public void searchProduct() {
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")).sendKeys("Redmi 10");
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/a/span")).click();
		
	}
	public void verifyResult() {
		String Expected="Redmi 10 - Buy Redmi 10 online in India";
		String Actual=driver.getTitle();
		Assert.assertEquals(Actual, Expected);
		
	}
}
