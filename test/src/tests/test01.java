package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test01  {
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
  public void test1() throws Exception {
    driver.get(baseUrl + "/users/sign_in");
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("admin@innotac.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("Password1!");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Send/View Kudos")).click();
    driver.findElement(By.linkText("Kudos Report")).click();
    driver.findElement(By.linkText("Update Profile")).click();
    driver.findElement(By.linkText("Edit Profile")).click();
    driver.findElement(By.linkText("Update Profile")).click();
    driver.findElement(By.linkText("Change Password")).click();
    driver.findElement(By.linkText("Admin")).click();
    driver.findElement(By.linkText("New Staff")).click();
    driver.findElement(By.linkText("Admin")).click();
    driver.findElement(By.linkText("View/Edit/Remove Staff")).click();
    driver.findElement(By.linkText("Logout")).click();
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