package cn.tju.scs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoTesting {
//	public static void main(String[] args) throws Exception{
//		System.setProperty("webdriver.firefox.bin", "D:\\ProgramFiles\\Mozilla Firefox\\firefox.exe");
//		WebDriver driver = new FirefoxDriver();
//		driver.get("http://www.baidu.com/");
//		driver.manage().window().maximize();
//	}
	
	public static String getAddress(String username, String password){
		System.setProperty("webdriver.firefox.bin", "D:\\ProgramFiles\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://psych.liebes.top/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	    driver.get(baseUrl + "/st");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
	    String info = driver.findElement(By.xpath("/html/body/div/div[2]/a/p")).getText();
		return info;
	}
	
	public static void main(String[] args) throws Exception{
		String string = getAddress("3015218071", "218071");
		System.out.println(string);
	}
}
