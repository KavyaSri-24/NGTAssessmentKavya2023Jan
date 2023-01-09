package com.app.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.Cart;
import com.app.pages.Login;



public class AppTests {
	WebDriver driver;
	Login loginPage;
	Cart cartPage;
	@BeforeMethod
	public void setUP() throws Exception{
	 String rootFolder=System.getProperty("user.dir");
	 System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 loginPage= new Login(driver);
	 cartPage = new Cart(driver);

	}
	
	  @Test
	  public void verifyLoginPage() throws Exception {
		 loginPage.EnterDeatils();
		 loginPage.verify_login1();
	
	  }
	  @Test
	  public void verifyCart() throws Exception {
		 loginPage.EnterDeatils();
		 Thread.sleep(4000);
		  cartPage.clickCart();
		  Assert.assertEquals(cartPage.getActualText(), cartPage.getExpectedText());
	  }
	  @AfterClass
	  public void tearDown() {
		  driver.quit();
	  }
}
