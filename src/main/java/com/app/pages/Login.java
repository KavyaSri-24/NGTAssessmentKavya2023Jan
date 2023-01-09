package com.app.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Login {
	 WebDriver driver;
	 public Login(WebDriver driver){
			this.driver=driver;
	 }
	public void EnterDeatils() throws Exception {
	 String rootFolder=System.getProperty("user.dir");
	 Properties propObj=new Properties();
	 propObj.load(new FileInputStream(rootFolder +"//src//test//resources//Data.properties"));
	 String value1 = propObj.getProperty("Url");

	String value2=propObj.getProperty("EmailId");
	String value3=propObj.getProperty("Password");
	String value5=propObj.getProperty("AppUrl");
	driver.get(value1);
	driver.findElement(By.id("mobileNumberPass")).sendKeys(value2);
	driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(value3);
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	Thread.sleep(35000);
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
}
	
	
	public void verify_login1() throws Exception {
		Thread.sleep(4000);
		driver.get("https://www.myntra.com/my/profile/edit");
		String Actual="Kumar Thoudisheti";

		String Expected=driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div[1]/div[2]")).getText();

		Assert.assertEquals(Actual,Expected,"Name Found");

		 

		}
    /*driver.get("https://www.myntra.com/my/profile/edit");
	String actual=driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div[1]/div[2]")).getText();
	String expected="Kumar Thoudisheti";
    Assert.assertEquals(actual, expected);
	 }*/}
	

