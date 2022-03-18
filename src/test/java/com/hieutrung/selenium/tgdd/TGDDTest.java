/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.hieutrung.selenium.tgdd;

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
public class TGDDTest {
    
    private static WebDriver myBrowser;
    private static String driverPath = "chromedriver.exe";
    
    @BeforeAll
    //khoi dong trinh duyet o day dung chung cho cac nhieu ham test @Test phia duoi
    public static void setUpClass() {
	System.setProperty("webdriver.chrome.driver", driverPath);
	
	myBrowser = new ChromeDriver();	
	
	myBrowser.manage().window().maximize();
	
	myBrowser.get("https://www.thegioididong.com/");
    }
    
    
    //test case: check if the price of 1st phone in the search result
    //				and in the details page are the same.
    //step1: open browser
    //s2;type URL https://www.thegioididong.com/
    //s3: type "Iphone" into the search box
    //s4: Hit enter to see list of phone
    //s5: store the price of 1st phone
    //s6;click to see phone details
    //expected result:
    //The price of phone in the search page and detail page are the same.
    @Test
    public void testCase() throws InterruptedException{
	
	String SearchKw = "Iphone";

	
	WebElement searchBox = myBrowser.findElement(By.xpath("//input[@id='skw']"));
	searchBox.sendKeys(SearchKw);
	searchBox.submit(); //btn thì dùng .click
	
	//đi tìm đt đầu tiên bao bởi thẻ <li>
	//hyperlinl để clik sang xem chi tiết
	WebElement phoneBriefElement = myBrowser.findElement(By.xpath("//body/section[@id='categoryPage']/div[@class='container-productbox']/ul[@class='listproduct']/li[11]"));
	//in toan boj info
	System.out.println("1st phone: " + phoneBriefElement.getText());
	
	//Crawler cao data va in ra
	
	//di tim tag chua gia tien. Tag nay deu xuat hien o mọi điện thoại nên sẽ bị trùng rất nhiều
	//Nên không query từ đầu trang mà sẽ query từ tag của element
	WebElement phonePriceBriefElement = phoneBriefElement.findElement(By.className("price"));
	
	String briefPrice = phonePriceBriefElement.getText() + " *";
	
	System.out.println("Price in brief only : " + briefPrice);
	
	//chuyen qua trang details
	phoneBriefElement.click();
	
	//get price trong trang details
	Thread.sleep(6000);
	WebElement phonePriceElementDetails = myBrowser.findElement(By.xpath("//p[@class='box-price-present']"));
	String detailsPagePrice = phonePriceElementDetails.getText();
	System.out.println("DetailsPage Price :" + detailsPagePrice);
	
	assertEquals(briefPrice, detailsPagePrice);
    }
    
    @AfterAll
    public static void tearDownClass() {
	myBrowser.quit(); // tat trinh duyet sau khi da chay xong
			  //toan bo cac @Test
    }
    
}
