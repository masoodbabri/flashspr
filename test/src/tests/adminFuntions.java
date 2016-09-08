package tests;
import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;
	import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class adminFuntions {
	

	
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
	  public void test4() throws Exception {
	    driver.get(baseUrl + "/users/sign_in");
	    driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys("admin@innotac.com");
	    Thread.sleep(2000);
	    driver.findElement(By.id("user_password")).clear();
	    driver.findElement(By.id("user_password")).sendKeys("Password1!");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.name("commit")).click();
	    
	    driver.findElement(By.xpath("html/body/div[1]/section/a[2]")).click();
	    
	    driver.findElement(By.name("keywords")).sendKeys("Sub");
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Edit/Remove")).click();
	    driver.findElement(By.linkText("Destroy")).click();
	    Thread.sleep(2000);
	    assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
	    driver.findElement(By.name("keywords")).clear();
	    driver.findElement(By.name("keywords")).sendKeys("");
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Edit/Remove")).click();
	    driver.findElement(By.linkText("Destroy")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.name("keywords")).sendKeys("ajay");
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Edit/Remove")).click();
	    driver.findElement(By.linkText("Destroy")).click();
	    Thread.sleep(2000);
	    assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Send/View Kudos")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Update Profile")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Back")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Home")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Logut")).click();
	    Thread.sleep(2000);
	    try {
	      assertEquals(driver.getTitle(), "FlashSPR");
	      
	      System.out.println("Test Passed:");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
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


