package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTable {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();	
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]")).click();
		int booksInContext = driver.findElements(By.xpath("//div[@class='rt-table']//div[2]//div[@class='rt-tr-group']")).size();
		driver.findElement(By.xpath("//button[@id='login']")).click();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("TyExcel");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@1");
		driver.findElement(By.xpath("//button[@id='login']")).click();
		Cookie cookie= driver.manage().getCookieNamed("JSESSIONID");
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		int booksPerUser = driver.findElements(By.xpath("//div[@class='rt-table']//div[2]//div[@class='rt-tr-group']")).size();
		System.out.println("The number of books stored in the context is "+ booksInContext + " and books displayed in the user's account is " + booksPerUser );
	}

}

