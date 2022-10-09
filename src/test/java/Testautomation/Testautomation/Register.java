package Testautomation.Testautomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Register {
	WebDriver driver;
  @Test(dataProvider="test_data")
  public void Registeration(String First_Name,String Last_Name,String Phone,String Email,String Address,String City,String State,String Postal_Code,String User_name,String Password,String ConfirmPass) {
	  driver.findElement(By.linkText("REGISTER")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.name("firstName")).sendKeys( First_Name);
	  driver.findElement(By.name("lastName")).sendKeys(Last_Name);
	  driver.findElement(By.name("phone")).sendKeys(Phone);
	  driver.findElement(By.name("userName")).sendKeys(Email);
	  driver.findElement(By.name("address1")).sendKeys(Address);
	  driver.findElement(By.name("city")).sendKeys(City);
	  driver.findElement(By.name("state")).sendKeys(State);
	  driver.findElement(By.name("postalCode")).sendKeys(Postal_Code);
	 WebElement country= driver.findElement(By.name("country"));
	 Select countryvalue =new Select(country);
	 countryvalue.selectByValue("ALGERIA");
	 driver.findElement(By.name("email")).sendKeys(User_name);
	 driver.findElement(By.name("password")).sendKeys(Password);
	 driver.findElement(By.name("confirmPassword")).sendKeys(ConfirmPass);
	
	WebElement submitbutton= driver.findElement(By.name("submit"));
	JavascriptExecutor java=(JavascriptExecutor) driver;
	java.executeScript("scroll(0,250)");
	 submitbutton.click();
	 String wellcome_msg= driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
	  Assert.assertEquals(wellcome_msg, "Note: Your user name is "+User_name+".");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @BeforeMethod
  public void open_browser() {
	  System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("https://demo.guru99.com/selenium/newtours/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void close_browser() {
	  driver.close();
  }
  @DataProvider
  public String[][] test_data() throws Exception, IOException{
	  
	  read_excel obj=new read_excel();
	  return obj.read_sheet();
  }

}
