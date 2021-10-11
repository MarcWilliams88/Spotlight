package Spotlight;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Spotlight {

	WebDriver driver = null;

	@Given("navigate to website")
	public void navigate_to_website() {

		String projectPath = System.getProperty("User.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "DEV/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser is open");

		driver.get("https://ao.com/");
	}

	@And("search washing machine")
	public void search_washing_machine() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Click on Search 
		driver.findElement(By.xpath("//header/div[@id='header-service-container']/div[1]/div[1]/div[2]/div[3]/div[1]/button[1]/i[1]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Input Search Criteria
		driver.findElement(By.xpath("//input[@id='siteSearch-input']")).sendKeys("Washing Machines");
		
	}
	
	@When("select brand and filter")
	public void select_brand_and_filter() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Select Brand
		driver.findElement(By.xpath("//body/div[@id='holder']/div[@id='container']/div[@id='contentholder']/div[@id='nocolumns']/div[@id='categoryPage']/section[@id='category-brands']/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Set Filter
		driver.findElement(By.xpath("//body/div[@id='holder']/div[@id='container']/main[@id='app']/div[2]/div[1]/aside[1]/div[2]/div[2]/div[2]/fieldset[1]/div[1]/a[1]/label[1]/span[1]/span[1]")).click();
		
	}
	
	@Then("validate")
	public void validate() {
				
		String confirmText = driver.findElement(By.xpath("//body/div[@id='holder']/div[@id='container']/main[@id='app']/div[2]/div[1]")).getText();
		Assert.assertTrue("https://ao.com/l/washing_machines-bosch-free_standing/1-6-9/1/", confirmText.contains("Free standing"));
	
	}
}
