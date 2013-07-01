package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
	
public class kalangosSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.1.6/test/kalangossoap.php";
    // call timeout function
    fnTimeOut();
  }

  @Test
  public void testkalangosSelenium(String filePath, String booleanValue, String WSDL) throws Exception {
    //driver.get(baseUrl + "/test/kalangossoap.php");
	driver.get(baseUrl);
	new Select(driver.findElement(By.name("statusmessage"))).selectByVisibleText(booleanValue);
	System.out.println("Selected Boolean value"+booleanValue+"\n");
    driver.findElement(By.name("file")).sendKeys(filePath);
    driver.findElement(By.name("wsdl")).clear();
    driver.findElement(By.name("wsdl")).sendKeys(WSDL);
    driver.findElement(By.name("submitWS")).click();
    System.out.println("======> "+driver.findElement(By.id("poo")).getText()+" <===========");
    driver.findElement(By.linkText("Reset")).click();
    fnTimeOut();
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
  /**
   * This function is used to manage timeout. 
   * @throws Exception
   */
public void fnTimeOut() throws Exception{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
}
