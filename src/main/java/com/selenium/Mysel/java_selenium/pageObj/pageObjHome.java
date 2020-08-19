package com.selenium.Mysel.java_selenium.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class pageObjHome {
	
	private static WebElement element = null;
	 
	public static void login(WebDriver driver) {
		
		WebElement Login = driver.findElement(By.className("login"));
    	Login.click();
    	
    	driver.findElement(By.id("email")).sendKeys("smisra@gmail.com");
    	driver.findElement(By.id("passwd")).sendKeys(pwd);
    	driver.findElement(By.id("SubmitLogin")).click();
	}
	
	

}
