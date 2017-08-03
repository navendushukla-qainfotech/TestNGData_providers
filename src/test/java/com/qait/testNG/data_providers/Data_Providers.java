package com.qait.testNG.data_providers;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qait.testNG.data_providers.Excel_data_provider;;

public class Data_Providers {
	Excel_data_provider ex = new Excel_data_provider();
	

	@DataProvider(name = "read_excel", parallel = true)
	public Object[][] read_excel() throws IOException {

		Object[][] obj = ex.excelreader();

		return obj;
	}


	@Test(dataProvider = "read_excel")
	public void getdetails(String email, String subject, String body)
			throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "/home/navendushukla/Downloads/chromedriver");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com");
		driver.findElement(By.id("identifierId")).sendKeys("testnssq");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("9997431884");
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='Mail']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[text()='COMPOSE']")).click();
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(By.className("vO")).sendKeys(email);
		Thread.sleep(500);
		driver.findElement(By.className("aoT")).sendKeys(subject);
		Thread.sleep(500);
		driver.findElement(By.xpath("(.//*[@aria-label='Message Body'])[2]")).sendKeys(body);
		Thread.sleep(500);
		driver.findElement(By.cssSelector("[aria-label='Send ‪(Ctrl-Enter)‬']")).click();
		driver.findElement(By.xpath("//span[@class='gb_7a gbii']")).click();
		driver.findElement(By.xpath(".//a[@id='gb_71']")).click();
		Thread.sleep(2000);
		// driver.close();

		// System.out.println(email);

	}

}
