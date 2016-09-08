package tests;

import org.testng.annotations.Test;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class createAcc {
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
  public void test2() throws Exception {
    driver.get(baseUrl + "/users/sign_in");
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("admin@innotac.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("Password1!");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'New Staff')])[2]")).click();
    driver.findElement(By.id("staff_first_name")).clear();
    driver.findElement(By.id("staff_first_name")).sendKeys("David");
    driver.findElement(By.id("staff_last_name")).clear();
    driver.findElement(By.id("staff_last_name")).sendKeys("Metzner");
    driver.findElement(By.id("staff_title")).clear();
    driver.findElement(By.id("staff_title")).sendKeys("Developer");
    driver.findElement(By.id("staff_email")).clear();
    driver.findElement(By.id("staff_email")).sendKeys("metzner@gmail.com");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'New Staff')])[2]")).click();
    driver.findElement(By.id("staff_first_name")).clear();
    driver.findElement(By.id("staff_first_name")).sendKeys("Mike");
    driver.findElement(By.id("staff_last_name")).clear();
    driver.findElement(By.id("staff_last_name")).sendKeys("Chagares");
    driver.findElement(By.id("staff_title")).clear();
    driver.findElement(By.id("staff_title")).sendKeys("Developer");
    driver.findElement(By.id("staff_email")).clear();
    driver.findElement(By.id("staff_email")).sendKeys("chagares@gmail.com");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("Send/View Kudos")).click();
    driver.findElement(By.name("keywords")).clear();
    driver.findElement(By.name("keywords")).sendKeys("chag");
    driver.findElement(By.linkText("Send Kudo")).click();
    driver.findElement(By.id("kudo_message")).clear();
    driver.findElement(By.id("kudo_message")).sendKeys("Great Work Mike");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("Kudos Report")).click();
    try {
      assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Kudos by Sender");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.xpath("//h1[2]")).getText(), "Kudos by Receiver");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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


