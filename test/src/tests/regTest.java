package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class regTest {
	
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
  public void regression() throws InterruptedException {
	  //Login Page
	  
	  driver.get(baseUrl);
	  
	  driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys("admin@innotac.com");
	    driver.findElement(By.id("user_password")).clear();
	    driver.findElement(By.id("user_password")).sendKeys("Password1!");
	    driver.findElement(By.name("commit")).click();
	  
	    
	    //driver.findElement(By.xpath(".//*[@id='mainnav']/div/div[2]"));
	    String searchingText = "staffs";
	    

		WebElement element = driver.findElement(By.xpath(".//*[@id='mainnav']/div/div[2]"));
		List<WebElement> results = element.findElements(By.tagName("li"));
		int size = results.size();

		System.out.println("The size of the list is: " + size);

		for (int i = 0; i < size; i++) {
			System.out.println(results.get(i).getText());
		}

		Thread.sleep(3000);
		for (WebElement result : results) {
			if (result.getText().equals(searchingText)) {
				result.click();
				System.out.println("Selected: " + result.getText());
				break;
			}
	    	
	    
	    	
	    }
	    
	  
	  
	  
	  
	 
 

}
}