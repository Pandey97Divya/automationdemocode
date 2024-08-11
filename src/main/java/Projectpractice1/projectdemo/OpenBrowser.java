package Projectpractice1.projectdemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import static Projectpractice1.projectdemo.ExcelSheetCode.sheet;

public class OpenBrowser {
	public static void openBrowser() {
		try {
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origin=*");
		WebDriver driver= new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//FIRST TESTCASE
		try {
			 //Test case 1
            HSSFRow row = sheet.createRow((short)1);
            row.createCell(0).setCellValue("TS_001");
            row.createCell(1).setCellValue("Sign IN");
            row.createCell(2).setCellValue("TC_01");
            row.createCell(3).setCellValue("Verify login with valid email and password combination.");
            row.createCell(4).setCellValue(StringFiles.username+" "+StringFiles.password);
            row.createCell(5).setCellValue("Fill Username & password then Click on Submit Button");
            row.createCell(6).setCellValue("Login to Homepage");
            try {
            	//driver.findElement(By.id("user-name")).sendKeys(StringFiles.username);
            	driver.findElement(By.name("user-name")).sendKeys(StringFiles.username);
    			driver.findElement(By.id("password")).sendKeys(StringFiles.password);
    			driver.findElement(By.id("login-button")).click();
    			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    			Thread.sleep(1000);
    	        String url = driver.getCurrentUrl();
                row.createCell(7).setCellValue("");
    	        if(url.equals("https://www.saucedemo.com/inventory.html")) {
    	        	row.createCell(8).setCellValue("Pass");
    	        }
    	        else {
    	        	row.createCell(8).setCellValue("Fail");
    	        }
            }catch(Exception e) {
    			e.printStackTrace();
            }
            Thread.sleep(1000);
            TakeScreenShot.screenshot(driver);
            row.createCell(9).setCellValue("Record "+TakeScreenShot.screenshotFileName);
            Date currentDate = new Date();
            row.createCell(10).setCellValue(currentDate.toString());
            row.createCell(11).setCellValue("");
            row.createCell(12).setCellValue("");
			TakeScreenShot.screenshot(driver);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		Thread.sleep(10000);
		driver.quit();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
