
package com.myntra.pages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckForBag {
	static WebDriver driver;
	Properties properties;
	static String bag_xpath = "//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/a[2]/span[3]";

	static String add_to_bag_xpath = "//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]";

	static String empty_bag_xpath = "//div[text()=\"There is nothing in your bag. Let's add some items.\"]";

	static String selected_xpath = "//*[@id=\"appContent\"]/div/div/div/div/div[1]/div[5]/div[2]";
	//*[@id="appContent"]/div/div/div/div/div[1]/div[5]/div[2]
	public CheckForBag(WebDriver driver) {
		this.driver = driver;
	}

	public void launchApp1() {
		// driver.get("https://www.myntra.com/login/password");
	}

	public void login() {
		// BufferedReader reader;
		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\katbhava\\eclipse-workspaceII\\NGTAssessmentBhavana2023Jan\\src\\test\\resources\\ReadData\\details.properties");
			properties.load(fis);
			String email = properties.getProperty("email");
			String pwd = properties.getProperty("pwd");
			String appurl = properties.getProperty("appurl");
			// System.out.println(email+pwd+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
			driver.get(appurl);
			driver.findElement(By.xpath("//*[@id=\"mobileNumberPass\"]")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[2]/input")).sendKeys(pwd);
			driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")).click();
			Thread.sleep(35000);
			driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("properties not found ");
		}

		/*
		 * reader = new BufferedReader(new FileReader(
		 * "C:\\\\Users\\\\katbhava\\\\eclipse-workspaceII\\\\NGTAssessmentBhavana2023Jan\\\\src\\\\test\\\\resources\\\\ReadData\\\\details.properties"
		 * )); properties = new Properties(); Thread.sleep(3500);
		 * properties.load(reader); Properties propObj1=new Properties();
		 * FileInputStream fis=new FileInputStream(
		 * "C:\\Users\\katbhava\\eclipse-workspaceII\\NGTAssessmentBhavana2023Jan\\src\\test\\resources\\ReadData\\details.properties"
		 * ); propObj1.load(fis); String email=properties.getProperty("email");
		 */
	}

	public void checkForBag() throws InterruptedException {

		driver.findElement(By.xpath(bag_xpath)).click();

		try {

			driver.findElement(By.xpath(empty_bag_xpath));

		} catch (NoSuchElementException e) {

			return;

		}

		add_to_bag();

	}

	public void add_to_bag() throws InterruptedException {

		driver.get(
				"https://www.myntra.com/mobile-accessories/dressberry/dressberry-lavender-textured-structured-mobile-pouch/15322776/buy");

		driver.findElement(By.xpath(add_to_bag_xpath)).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(bag_xpath)).click();

		Thread.sleep(5000);

	}

	public String getActualText() {

		return driver.findElement(By.xpath(selected_xpath)).getText();

	}

	public String getExpectedText() {

		return "1/1 ITEMS SELECTED";

	}

	public void searchProduct() {
		// TODO Auto-generated method stub

		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")).sendKeys("samsung a53");
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/a/span")).click();
		// driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[1]/a/div[1]/div/div/div/picture/img")).click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

	}

	public void addProductInCart() {
		// TODO Auto-generated method stub
		String expected = "Samsung A50 - Buy Samsung A50 online in India";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		driver.findElement(
				By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[1]/a/div[1]/div/div/div/picture/img"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]"))
				.click();

		driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/a/span[1]"))
				.click();
		// driver.findElement(By.xpath("//*[@id='desktop-header-cnt']/div[2]/div[2]/a[2]/span[3]")).click();

	}

}
