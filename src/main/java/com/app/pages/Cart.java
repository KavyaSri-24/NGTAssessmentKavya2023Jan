package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Cart {
	WebDriver driver;
	static String bag_xpath = "//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/a[2]/span[3]";

	static String add_to_bag_xpath = "//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]";

	static String empty_bag_xpath = "//div[text()=\"There is nothing in your bag. Let's add some items.\"]";

	static String selected_xpath = "//*[@id=\"appContent\"]/div/div/div/div/div[1]/div[5]/div[2]";
	public Cart(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCart() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/a[2]/span[3]")).click();
		try {

			driver.findElement(By.xpath(empty_bag_xpath));

		} catch (NoSuchElementException e) {

			return;

		}

		add_to_bag();

	}

	public void add_to_bag() throws InterruptedException {

		driver.get(" https://www.myntra.com/mobile-accessories/dressberry/dressberry-lavender-textured-structured-mobile-pouch/15322776/buy");

		driver.findElement(By.xpath(add_to_bag_xpath)).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(bag_xpath)).click();

		Thread.sleep(2000);

	}

	public String getActualText() {

		return driver.findElement(By.xpath(selected_xpath)).getText();

	}

	public String getExpectedText() {

		return "1/1 ITEMS SELECTED";

	}
}