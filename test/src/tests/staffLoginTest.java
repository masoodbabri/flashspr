package tests;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class staffLoginTest {
	




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
  public void test3() throws Exception {
    driver.get(baseUrl + "/users/sign_in");
    Thread.sleep(2000);
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("admin@innotac.com");
    Thread.sleep(2000);
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("Password1!");
    Thread.sleep(2000);
    driver.findElement(By.name("commit")).click();
    assertTrue(isElementPresent(By.cssSelector("h2")));
    System.out.println("Test Passed: ");
    driver.findElement(By.linkText("Send/View Kudos")).click();
    driver.findElement(By.name("keywords")).clear();
    driver.findElement(By.name("keywords")).sendKeys("Subway");
    Thread.sleep(2000);
    driver.findElement(By.linkText("Send Kudo")).click();
    driver.findElement(By.id("kudo_message")).clear();
    driver.findElement(By.id("kudo_message")).sendKeys("Great job Tomey");
    Thread.sleep(2000);
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("Send/View Kudos")).click();
    
    driver.findElement(By.name("keywords")).clear();
    Thread.sleep(2000);
    driver.findElement(By.name("keywords")).sendKeys("Ajay");
    driver.findElement(By.linkText("Send Kudo")).click();
    driver.findElement(By.id("kudo_message")).clear();
    Thread.sleep(2000);
    driver.findElement(By.id("kudo_message")).sendKeys("Good Work Ajay.");
    driver.findElement(By.name("commit")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Home")).click();
    Thread.sleep(2000);
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



