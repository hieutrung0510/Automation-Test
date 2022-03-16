/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.hieutrung.selenium.guru99;

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
public class Guru99Test {
    
    private static WebDriver myBrowser;
    private static String driverPath = "chromedriver.exe";
    
    @BeforeAll
    //khoi dong trinh duyet o day dung chung cho cac nhieu ham test @Test phia duoi
    public static void setUpClass() {
	System.setProperty("webdriver.chrome.driver", driverPath);
	
	myBrowser = new ChromeDriver();	
	
	myBrowser.manage().window().maximize();
	
	myBrowser.get("https://demo.guru99.com/V4/index.php");
    }
    
    @Test
    public void testLogin() throws InterruptedException{
	WebElement username = myBrowser.findElement(By.xpath("//input[@name='uid']"));
	username.sendKeys("mngr392606");
	
	WebElement password = myBrowser.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys("ymEnYpY");
	
	WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
	btnLogin.click();
	
	Thread.sleep(3000);
	
	WebElement helloMessage = myBrowser.findElement(By.xpath("//td[normalize-space()='Manger Id : mngr392606']"));
	assertEquals("Manger Id : mngr392606", helloMessage.getText());
    }
    
    @AfterAll
    public static void tearDownClass() {
	myBrowser.quit(); // tat trinh duyet sau khi da chay xong
			  //toan bo cac @Test
    }
    
}
