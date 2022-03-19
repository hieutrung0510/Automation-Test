/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.hieutrung.selenium.zingnews;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author PC
 */
public class zingnewsTest {
    
    private static WebDriver myBrowser;
    private static String driverPath = "chromedriver.exe";
   
    @BeforeAll
    public static void setUpClass() {
	System.setProperty("webdriver.chrome.driver",driverPath);
	
	myBrowser = new ChromeDriver();
	
	myBrowser.manage().window().maximize();
	
	myBrowser.get("https://zingnews.vn/");
    }
    
    //Case: Compare two title in main page and in details page are same
    //s1:open browser
    //s2:type URL
    //s3:Click in Thoi Su 
    //s3.1: rool down to see the title "Mao danh"
    //s4:Click into the news
    //s5: see the new details
    //expected
    //		2 title in 2 page are the same.
    
    @Test
    public void testCase() throws InterruptedException{
	
	//click in thoi su
	WebElement clickButton = myBrowser.findElement(By.xpath("//div[@class='page-wrapper']//nav[@class='category-menu']//a[@title='Thời sự'][contains(text(),'Thời sự')]"));
	clickButton.click();
	
	//find the new "Mao danh ...."
	WebElement getNews = myBrowser.findElement(By.xpath("//section[@id='news-latest']//article[1]"));
	System.out.println(getNews.getText());
	
	WebElement titleInMain = myBrowser.findElement(By.xpath("//section[@id='news-latest']//article[1]//header[1]//p[1]//a[1]"));
	String title = titleInMain.getText();
	System.out.println("Main Page Title: " + title);
	titleInMain.click();
	
	Thread.sleep(7000);
	
	WebElement titleInDetails = myBrowser.findElement(By.xpath("//h1[@class='the-article-title']"));
	String titledetail = titleInDetails.getText();
	System.out.println("Details Page Title: " + titledetail);
	
	assertEquals(title, titledetail);
    }
    
    @AfterAll
    public static void tearDownClass() {
	myBrowser.quit();
    }
    
}
