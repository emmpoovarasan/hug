package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Date;
import jxl.*;
import jxl.write.*;
	
public class kalangosSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  WritableWorkbook workbook=null;
  WritableSheet sheet=null;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.1.6/test/kalangossoap.php";
    // call timeout function
    fnTimeOut();
  }

  @Test
  public void testkalangosSelenium(String filePath, String booleanValue, String WSDL, int i) throws Exception {
    //driver.get(baseUrl + "/test/kalangossoap.php");
	String resultOutput=null;
	driver.get(baseUrl);
	
	new Select(driver.findElement(By.name("statusmessage"))).selectByVisibleText(booleanValue);
	
	System.out.println("Selected Boolean value"+booleanValue+"\n");
    
	driver.findElement(By.name("file")).sendKeys(filePath);
    driver.findElement(By.name("wsdl")).clear();
    driver.findElement(By.name("wsdl")).sendKeys(WSDL);
    driver.findElement(By.name("submitWS")).click();
    
    resultOutput= driver.findElement(By.id("poo")).getText();
    System.out.println("======> "+resultOutput+" <===========");
    
    
    fnPassArgsToExcel(i,resultOutput,booleanValue);
    
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
   * Create Workbook & Worksheet
   */
  public void fnCreateExcelWorkBookAndSheet() throws Exception {
	    workbook = Workbook.createWorkbook(new File("output.xls"));
	    sheet = workbook.createSheet("Results", 0);
  }
  
  public void fnPassArgsToExcel(int i, String outputResults, String booleanResult) throws Exception{
	  Label outputResultslable = new Label(0, i, outputResults);
	  Label booleanResultlable = new Label(1, i, booleanResult);
	  if (sheet != null){
		  sheet.addCell(outputResultslable);
		  sheet.addCell(booleanResultlable);
	  }
  }
  public void fnCloseExcel() throws Exception{
	  workbook.write();
	  workbook.close();
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
