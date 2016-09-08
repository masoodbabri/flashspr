package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class projectAutomationTest {




  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
 

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://54.159.15.97:3000/";
  
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void test01() throws Exception{
	  driver.get(baseUrl + "/users/sign_in");
	    driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys("admin@innotac.com");
	    Thread.sleep(2000);
	    driver.findElement(By.id("user_password")).clear();
	    driver.findElement(By.id("user_password")).sendKeys("Password1!");
	    Thread.sleep(2000);
	    driver.findElement(By.name("commit")).click();
	    driver.findElement(By.linkText("New Staff")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("staff_first_name")).clear();
	    driver.findElement(By.id("staff_first_name")).sendKeys("Subway");
	    Thread.sleep(2000);
	    driver.findElement(By.id("staff_last_name")).clear();
	    driver.findElement(By.id("staff_last_name")).sendKeys("Tomey");
	    Thread.sleep(2000);
	    driver.findElement(By.id("staff_title")).clear();
	    driver.findElement(By.id("staff_title")).sendKeys("Business Analyst");
	    Thread.sleep(2000);
	    driver.findElement(By.id("staff_email")).clear();
	    driver.findElement(By.id("staff_email")).sendKeys("stomey@gmail.com");
	    Thread.sleep(2000);
	    driver.findElement(By.name("commit")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("New Staff")).click();
	    driver.findElement(By.id("staff_first_name")).clear();
	    driver.findElement(By.id("staff_first_name")).sendKeys("Ajay");
	    Thread.sleep(2000);
	    driver.findElement(By.id("staff_last_name")).clear();
	    driver.findElement(By.id("staff_last_name")).sendKeys("Devanand");
	    Thread.sleep(2000);
	    driver.findElement(By.id("staff_title")).clear();
	    driver.findElement(By.id("staff_title")).sendKeys("Developer");
	    Thread.sleep(5000);
	    driver.findElement(By.id("staff_email")).clear();
	    driver.findElement(By.id("staff_email")).sendKeys("Ajay@gmail.com");
	    Thread.sleep(2000);
	    driver.findElement(By.name("commit")).click();
	    driver.findElement(By.linkText("Home")).click();
	    try {
	      assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Big Boss-man's Kudos");
	      System.out.println("Test Pass");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	      System.out.println("Test Fail");
	    }
	    driver.findElement(By.linkText("Logut")).click(); 
	  
  }


  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
