/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.hieutrung.selenium.go.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author PC
 */
public class Selenium2Go {

    //Test case này phải để bên TestRail
    //Test case 1: Open GG search engine
    //Steps:
    //s1: open certain browser
    //s2:Type url google.com
    //s3:type SOS et o et in search box
    //s5: hit enter to see the result
    //expected result: 
    //-multiple websites with the keywords et o et includes
    public static void testGoogleSearchEngine(){
	String driverPath = "chromedriver.exe";
	
	//chỉ đường dẫn vs file driver
	
	//Báo máy ảo Java biết có toll phụ trợ sẽ tương tác với trình duyê
	//báo JVM biết có plugins ở trên để gọi khi cần
	System.setProperty("webdriver.chrome.driver", driverPath);
	//tương đương lệnh Class.forName(để tải sqlsever driver)
	
	WebDriver myBrowser;	//xài Selenium
				//OOP thì cái gì cũng là Object
				//trình duyệt xuất hiện trong code cũng là object
	
				
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--incognito");
	opt.addArguments("--lang-vi");
	myBrowser = new ChromeDriver(opt);	
	//khai báo như cha new con() và trình duyệt sẽhieenjnj ra 1/2 màn hình
	
	//bung to man hinh
	myBrowser.manage().window().maximize();
	
	//duyet web
	myBrowser.get("https://google.com");
	
	//ta di tim cai o search, name la "q"
	//moi thanh phan, tag cua trang web deu duoc xem la Object
	//Goi ten chung la webElement
	
	WebElement searchBox = myBrowser.findElement(By.name("q"));
	
	//neu thanh cong thi da thanh cong dinh vi duoc o nhap
	searchBox.sendKeys("ét ô ét");
	searchBox.submit();
	
				
    }
    
    
    //Test case này phải để bên TestRail
    //Test case 2 Check Guru99 login
    //Steps:
    //s1: open certain browser
    //s2:Type url https://demo.guru99.com/V4/index.php
    //s3:type username/password mngr392606/ymEnYpY
    //s4: hit login
    //s5:
    //expected result: 
    //-The dashboard/main menu page appear with the salutation: Hi,mngr392606
    public static void testGuru99() throws InterruptedException{
	String driverPath = "chromedriver.exe";
	
	//chỉ đường dẫn vs file driver
	
	//Báo máy ảo Java biết có toll phụ trợ sẽ tương tác với trình duyê
	//báo JVM biết có plugins ở trên để gọi khi cần
	System.setProperty("webdriver.chrome.driver", driverPath);
	//tương đương lệnh Class.forName(để tải sqlsever driver)
	
	WebDriver myBrowser;	//xài Selenium
				//OOP thì cái gì cũng là Object
				//trình duyệt xuất hiện trong code cũng là object
	
	myBrowser = new ChromeDriver();	
	//khai báo như cha new con() và trình duyệt sẽhieenjnj ra 1/2 màn hình
	
	//bung to man hinh
	myBrowser.manage().window().maximize();
	
	//duyet web
	myBrowser.get("https://demo.guru99.com/V4/index.php");
	
	//tim o nhap username/password: dung chuoi dinh vi xPath
	//nho tool selector hub giup
	
	WebElement username = myBrowser.findElement(By.xpath("//input[@name='uid']"));
	username.sendKeys("mngr392606");
	
	WebElement password = myBrowser.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys("ymEnYpY");
	
	WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
	btnLogin.click();
	//neu thanh cong thi da thanh cong dinh vi duoc o nhap
	
	//khi login thi se chuyen trang
	//can 1 do tre de trang duoc load ve local
	//khong can cho trang tai ve. ERROR vi ko tim thay tag, chua skip render
	//TIPS: wait/sleep doan code java 1 chut
	//vi day la 2 thread, tien trinh khac nhau: code java va trinh duyet
	
	Thread.sleep(3000);
	
	//kiem tra da chao dung chua. Manager : username
	WebElement helloMessage = myBrowser.findElement(By.xpath("//td[normalize-space()='Manger Id : mngr392606']"));
	System.out.println("Hello Message " + helloMessage.getText());
	//in duoc nghia la login thanh cong, dung mau sac
	
	
				
    }
    
    public static void main(String[] args) throws InterruptedException {
//        testGoogleSearchEngine();
	testGuru99();
    }
}
