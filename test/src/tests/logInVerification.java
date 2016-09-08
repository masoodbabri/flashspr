package tests;

	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;
	import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	
	
	
	
public class logInVerification {
	

	
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
		
		//Negative Testing.
		//TS_001 Go to url
	    driver.get(baseUrl + "/users/sign_in");
	    driver.manage().window().maximize();
	    
	    
	    //TS_002 Enter User Email
	    
	    
	    driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys("mbabri331@gmail.com");
	    Thread.sleep(2000);
	    
	    //TS_003 Enter Wrong Email Address.
	    
	    
	    driver.findElement(By.id("user_password")).clear();
	    driver.findElement(By.id("user_password")).sendKeys("fjaslkdfjskldjf");
	    Thread.sleep(2000);
	    
	    
	    //TS_004 Press Enter Button
	    
	    
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	    
	    
	   //TS_005 Validation Test
	    String vText;
	    vText = driver.findElement(By.cssSelector("aside.alert.alert-danger")).getText();
	    if (vText.equals("Invalid Email or password.")){
	    System.out.println("Test1 passed: " + vText + " is the message displayed.");
	    }else {
	    	System.out.println("Test1 Failed The actual message show is " + vText);
	    }
//	    
//	    try {
//	      assertEquals(driver.findElement(By.cssSelector("aside.alert.alert-danger")).getText(), "Invalid Email or password.");
//	      System.out.println("Test Passed: Invalid Email or password messsage displays.");
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	      System.out.println("Test Fail:");
//	    }
	    Thread.sleep(2000);
	    
	    //TS006 Click enter again without entering password
	    
	    
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	    String vText1;
//	    vText1 = driver.findElement(By.cssSelector("aside.alert.alert-danger")).getText();
//	    if (vText1.equals("Invalid Email or password.")){
//	    System.out.println("Test2 passed: " + vText1 + " When Entered without Entering a password");
//	    }else {
//	    	System.out.println("Test Failed");
	    
	    
	    try {
	    	assertEquals(driver.findElement(By.cssSelector("aside.alert.alert-danger")).getText(), "Invalid Email or password.");
	    	System.out.println("Test 2 Verification Passed: Invalid Email or password.");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	      System.out.println("Test 2 Failed");
	    }
	    
	    //TS-007 Forgot password check
	    
	    driver.findElement(By.linkText("Forgot your password?")).click();
	    Thread.sleep(2000);
	    
	    
	    //TS-008 Enter email address
	    
	    driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys("mbabri331@gmail.com");
	    Thread.sleep(2000);
	    
	    //TS-009 Click Enter to see if email is send to your email address
	    
	    driver.findElement(By.linkText("Log in")).click();
	    driver.findElement(By.id("user_email")).clear();
	    Thread.sleep(2000);
	    
	    
	    //Positive Testing for Login Page.
	    //TS_010 Enter correct Email address
	    
	    
	    driver.findElement(By.id("user_email")).sendKeys("mbabri331@gmail.com");
	    Thread.sleep(2000);
	    
	    //TS_011 Enter Correct Password
	    
	    
	    driver.findElement(By.id("user_password")).clear();
	    driver.findElement(By.id("user_password")).sendKeys("Lahore123$$");
	    Thread.sleep(2000);
	    
	    
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	    String vKudos;
	    vKudos = driver.findElement(By.cssSelector("h2")).getText();
	    if (vKudos.equals("Masood Babri's Kudos")){
	    	System.out.println("Test3 Passed and the actual output is; " + vKudos);
	    }else
	    {
	    	System.out.println("Test3 Failed adn the actual output is: " + vKudos);
	    }
//	    try {
//	     assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Masood Babri's Kudos");
//	      System.out.println("Test Passed: " + "Masood Babri's Kudos");
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
	    
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


