package com.example.tests;

import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;

public class findElementsInSignIn extends TestCase {
private WebDriver driver;
private String baseUrl;
private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
		baseUrl="http://192.168.1.6/easymedmobiledb2.com/";
		waitTimer();
	}

	@Test
	public void testfindElementsInSignIn() throws Exception{
		driver.get(baseUrl);
		System.out.println("Current URL ----> "+driver.getCurrentUrl());
		driver.findElement(By.xpath(".//*[@id='loginForm']/table/tbody/tr[3]/td[2]/input")).sendKeys("poovarsan@easymedmobile.com");
		driver.findElement(By.xpath(".//*[@id='loginForm']/table/tbody/tr[4]/td[2]/input")).sendKeys("bbbbbb");
		driver.findElement(By.xpath(".//*[@id='submitId']")).click();
		waitTimer();
		System.out.println("Product title after logged into application -----> "+driver.getTitle());
		//assertTrue(driver.findElement(By.name(name)));
		System.out.println("Interaction titles ----> "+ driver.findElement(By.className("warningTitle")).getText());
		System.out.println("health-passport titles ----> "+ driver.findElement(By.id("health-passport")).getText());
		System.out.println("phone not verify user-----> "+driver.findElement(By.className("notify-text")).getText());
		System.out.println("Logout text is ----------> "+driver.findElement(By.linkText("Déconnexion")).getText());
		driver.findElement(By.linkText("Déconnexion")).click();
	}
	
	@After
	public void tearDown() throws Exception{
		driver.quit();
		String verifyError = verificationErrors.toString();
		if(!"".equals(verifyError)){
			fail(verifyError);
		}
	}
	private void waitTimer(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}