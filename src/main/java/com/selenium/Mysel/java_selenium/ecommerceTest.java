package com.selenium.Mysel.java_selenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Mysel.java_selenium.DataManager;

//import com.techbeamers.seleniumtestng.datamanager.DataManager;

public class ecommerceTest {

    WebDriver driver = null;
    public static boolean keepAlive = true;
    public static long purgeInterval = 10; // in milliseconds
    public static long implicitlyWait = 10; // in seconds
    public static String driverPath = "C:\\Users\\misra\\Downloads\\";

    // Selenium-TestNG Suite Initialization
    @BeforeSuite
    public void suiteSetup() {
        System.out.println("suiteSetup");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("marionette", true);
        driver = new ChromeDriver();
    }

    // Selenium-TestNG Suite cleanup
    @AfterSuite
    public void suiteTeardown() {
        System.out.println("suiteTeardown");
        //driver.close();
        //driver.quit();
    }

    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        System.out.println("Open Browser");
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        System.out.println("exit from openBrowser()");
    }

    @AfterMethod
    public void afterTest() {
        // Intentionally left blank.
    }
    
    
    @Test(dataProvider = "RegistrationData")
    public void RegandLogin(String Title, String FirstName, String LastName, String pwd, 
    		String DOBDay, String DOBMonth, String DOBYear, 
    		String Address, String City, String State, String ZipCode, String Country, String mob)
    {
    	
    	driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
    	
    	WebElement Login = driver.findElement(By.className("login"));
    	Login.click();
    	
    	driver.findElement(By.id("email")).sendKeys("smisra@gmail.com");
    	driver.findElement(By.id("passwd")).sendKeys(pwd);
    	driver.findElement(By.id("SubmitLogin")).click();
    	
    	
    	
    	
    	
    	/*
    	driver.findElement(By.id("email_create")).sendKeys("smisra@gmail.com");
    	driver.findElement(By.id("SubmitCreate")).click();
    	
    	
    	//driver.findElement(By.id("id_gender1"));
    	//driver.findElement(By.id("id_gender2"));
    	driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys(FirstName);
    	driver.findElement(By.id("customer_lastname")).sendKeys(LastName);
    	//driver.findElement(By.id("email"));
    	driver.findElement(By.id("passwd")).sendKeys(pwd);
    	
    	Select day = new Select(driver.findElement(By.id("days")));
    	Select month = new Select(driver.findElement(By.id("months")));
    	Select year = new Select(driver.findElement(By.id("years")));
    	
		day.selectByVisibleText(DOBDay+"  ");
		month.selectByVisibleText(DOBMonth+" ");
		year.selectByVisibleText(DOBYear+"  ");
		
    	
    	//driver.findElement(By.id("firstname")).sendKeys(FirstName);
    	//driver.findElement(By.id("lastname")).sendKeys(LastName);
    	driver.findElement(By.id("address1")).sendKeys(Address);
    	driver.findElement(By.id("city")).sendKeys(City);
    	
    	Select state = new Select(driver.findElement(By.id("id_state")));
    	state.selectByVisibleText(State);
    	
    	driver.findElement(By.id("postcode")).sendKeys(ZipCode);
    	
    	Select country = new Select(driver.findElement(By.id("id_country")));
    	country.selectByVisibleText(Country);
    	driver.findElement(By.id("phone_mobile")).sendKeys(mob);
    	
    	driver.findElement(By.id("submitAccount")).click(); */
    	
    	
    }
    
    @Test(dataProvider = "ShoppingData")
    public void shopping(String prodid1, String prodname1, String color1, String size1, String qty1, 
    		String prodid2, String prodname2, String color2, String size2, String qty2, 
    		String prodid3, String prodname3, String color3, String size3, String qty3) throws IOException {
    	
    	Actions action = new Actions(driver);
    	
    	driver.findElement(By.id("search_query_top")).clear();
    	driver.findElement(By.id("search_query_top")).sendKeys(prodname3 + Keys.ENTER);
    	
    	WebElement mousehov = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]"));
    	action.moveToElement(mousehov).perform();
    	driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")).click();
    	
    	driver.findElement(By.id("search_query_top")).clear();
    	driver.findElement(By.id("search_query_top")).sendKeys(prodname1 + Keys.ENTER);
    	WebElement mousehov2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
    	action.moveToElement(mousehov2).perform();
    	driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")).click();
    	
    	driver.findElement(By.id("search_query_top")).clear();
    	driver.findElement(By.id("search_query_top")).sendKeys(prodname2 + Keys.ENTER);
    	WebElement mousehov3 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
    	action.moveToElement(mousehov3).perform();
    	driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")).click();
    	
    	
    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
    	
    	ArrayList<ArrayList<String>> itemList = getCartData(driver);
    	DataManager.writeShoppingData(itemList);
    	
    	ArrayList<String> itemTotalData = getCartTotal(driver);
    	DataManager.writeTotalData(itemTotalData);
    	
    }
    
    @DataProvider(name = "RegistrationData")
    public Object[][] datasupplier() throws Exception {
        final String xlsxFile = System.getProperty("user.dir") + "\\DataSheet.xlsx";
        Object[][] arrayObject = DataManager.getExcelData(xlsxFile, "Registration");
        return arrayObject;
    }
    
    @DataProvider(name = "ShoppingData")
    public Object[][] datasupplierprod() throws Exception {
        final String xlsxFile = System.getProperty("user.dir") + "\\DataSheet.xlsx";
        Object[][] arrayObject2 = DataManager.getShoppingData(xlsxFile, "Product");
        return arrayObject2;
    }
    	
    	public static ArrayList<ArrayList<String>> getCartData(WebDriver driver) throws IOException {
    		
    		
    		
    		List<WebElement> prodlist = driver.findElements(By.xpath("//*[@id=\"cart_summary\"]/tbody/tr"));
    		
    		ArrayList<ArrayList<String>> itemList = new ArrayList<ArrayList<String>>();   
    		
    		
    		System.out.println("size of prodlist --> "+prodlist.size());
    		
    		for (int i=1; i<=prodlist.size(); i++) {
    			
    			String tablepath = String.format("//*[@id=\"cart_summary\"]/tbody/tr[%d]", i);
    			
    			String prodname = driver.findElement(By.xpath(tablepath + "/td[2]/p/a")).getText();
    			String sku = driver.findElement(By.xpath(tablepath + "/td[2]/small[1]")).getText().substring(6);
    			String color = driver.findElement(By.xpath(tablepath + "/td[2]/small[2]/a")).getText().substring(8, 13);
    			String size = driver.findElement(By.xpath(tablepath + "/td[2]/small[2]/a")).getText().substring(22);
    			String qty = driver.findElement(By.xpath(tablepath + "/td[5]/input[1]")).getAttribute("value");
    			String totlprice = driver.findElement(By.xpath(tablepath + "/td[6]/span")).getText();
    			
    			
    			ArrayList<String> itemdetails = new ArrayList<String>();
    			
    				itemdetails.add(String.format("%d", i));
        			itemdetails.add(prodname);
        			itemdetails.add(sku);
        			itemdetails.add(color);
        			itemdetails.add(size);
        			itemdetails.add(qty);
        			itemdetails.add(totlprice);
    		
    			
    			itemList.add(i-1, itemdetails);
    			
    			System.out.println(itemList);
    			
    			//DataManager.writeShoppingData(itemList);
    			
    			
    			
    			
    			
    			
    			//check if data is present
    			/*
    			System.out.println(prodname);
    			System.out.println(sku);
    			System.out.println(color);
    			System.out.println(size);
    			System.out.println(qty);
    			System.out.println(totlprice);
    			*/
    			
    			}
    		
    		return itemList;
    		
    		
    	}
    	
    	
    	public static ArrayList<String> getCartTotal(WebDriver driver){
    		
    		
    		ArrayList<String> CartTotalDetails = new ArrayList<String>();
    		
    		String TotalProd = driver.findElement(By.id("total_product")).getText();
    		String ShipCost = driver.findElement(By.id("total_shipping")).getText();
    		String Total = driver.findElement(By.id("total_price_without_tax")).getText();
    		
    		CartTotalDetails.add(TotalProd);
    		CartTotalDetails.add(ShipCost);
    		CartTotalDetails.add(Total);
    		
    		return CartTotalDetails;
    		
    		
    	}
    	
    }


