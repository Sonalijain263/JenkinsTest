package testpageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PionGlobalTest {
      public WebDriver driver;
      public static Logger logger;
      
      @BeforeMethod
	public void setup()
	{
    	logger= Logger.getLogger("Pion Global"); // Added logger
  		PropertyConfigurator.configure("log4j.properties");
  		
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		 driver = new ChromeDriver();
		 logger.info("Launching chrome browser");
		 
         driver.get("https://www.pionglobal.com/");
         logger.info("Opening URL");
         
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);     
	}
	
      @Test
	public void getTestData() throws InterruptedException {
         WebElement link= driver.findElement(By.linkText("Products"));
         link.click();
         logger.info("Click on PRODUCTS");
         Thread.sleep(1000);
         WebElement link1= driver.findElement(By.linkText("Services"));
         link1.click();
         logger.info("Click on SERVICES");
         Thread.sleep(1000);
         WebElement link2= driver.findElement(By.linkText("Careers"));
         link2.click();
         logger.info("Click on CAREERS");
         Thread.sleep(1000);
         JavascriptExecutor jse= (JavascriptExecutor)driver;
         jse.executeScript("scroll(0,3300)");
         WebElement fullname= driver.findElement(By.xpath("//input[@name='name']"));
         fullname.sendKeys("Sonali jain");
         logger.info("Enter full name");
         Thread.sleep(1000);
         WebElement email= driver.findElement(By.xpath("//input[@name='email']"));
         email.sendKeys("Sonalijain@gmail.com");
         logger.info("Enter email");
         Thread.sleep(1000);
         WebElement phoneno= driver.findElement(By.xpath("//input[@name='phone']"));
         phoneno.sendKeys("1234567890");
         logger.info("Enter phone number ");
         Thread.sleep(1000);
         WebElement organisation= driver.findElement(By.xpath("//input[@name='org']"));
         organisation.sendKeys("Pion Global");
         logger.info("Enter organisation");
         Thread.sleep(1000);
         WebElement designation= driver.findElement(By.xpath("//select[@name='designation']"));
         Select s = new Select(designation);
         s.selectByVisibleText("Testing Head");
         logger.info("Enter designation  ");
         Thread.sleep(1000);
         WebElement domain= driver.findElement(By.xpath("//select[@name='businessDomain']"));
         Select s1 = new Select(domain);
         s1.selectByVisibleText("IT Services");
         logger.info("Enter domain ");
         Thread.sleep(1000);
         WebElement departments= driver.findElement(By.xpath("//select[@name='departments']"));
         Select s2 = new Select(departments);
         s2.selectByVisibleText("TA");
         logger.info("Enter departments " );
         Thread.sleep(1000);
         WebElement subject= driver.findElement(By.xpath("//input[@name='subject']"));
         subject.sendKeys("Automation");
         logger.info("Enter subject ");
         Thread.sleep(1000);
         WebElement message= driver.findElement(By.xpath("//textarea[@name='content']"));
         message.sendKeys("Hello");
         logger.info("Enter message ");
         Thread.sleep(1000);
        WebElement checkbox= driver.findElement(By.xpath("//input[@name='acceptance']"));
        Actions a =new Actions(driver);
        a.moveToElement(checkbox).doubleClick().build().perform();
         System.out.println("Checkbox is selected"+checkbox.isSelected());
         logger.info("Click on checkbox");
        Thread.sleep(2000);
         WebElement send= driver.findElement(By.xpath("//button[text()='Send']"));
         send.click();
         logger.info("Click on Send ");
         
	}
	 
      @AfterMethod
	public void closeDown() {
		
        driver.close();
        logger.info("Driver closed");
         
	}

}
