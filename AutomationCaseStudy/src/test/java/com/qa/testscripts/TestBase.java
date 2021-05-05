package com.qa.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.qa.pages.AlibabaPages;


public class TestBase {

WebDriver driver;

AlibabaPages alibabapage;
Actions act;
JavascriptExecutor js;
@Parameters({"Browser","Url"})

@BeforeClass
public void setUp(String Browser, String Url) {



if(Browser.equalsIgnoreCase("chrome")) {
System.setProperty("webdriver.chrome.driver",
"C:\\Users\\DELL\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

driver = new ChromeDriver();
}
else if(Browser.equalsIgnoreCase("edge"))
{
System.setProperty("webdriver.chrome.driver",
"C:\\Users\\DELL\\Downloads\\Driver_Notes\\Edgedriver.exe");

driver = new EdgeDriver();
}
driver.manage().window().maximize();

alibabapage = new AlibabaPages(driver);
act = new Actions(driver);
js = (JavascriptExecutor)driver;
driver.get(Url);

}
@AfterClass
public void tearDown() {
driver.close();
}

}
