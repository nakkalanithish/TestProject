package com.qa.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.text.Element;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.utility.ExcelUtility;

public class Alibaba extends TestBase{

DataFormatter formatter = new DataFormatter();
@Test(dataProvider = "drivertest", priority = 1)
public void searchItem(String input)
{

WebElement search = alibabapage.getsearchbar();

alibabapage.getsearchbar().clear();
search.sendKeys(input);

alibabapage.getsearchbutton().click();


List<WebElement> prices = alibabapage.getprices();
for(WebElement ele:prices)
{
Reporter.log("The prices of" + " " + input + ele.getText(),true);

}

driver.navigate().to("https://alibaba.com/");


}

@Test(priority =  2, dataProvider = "logintest")
public void login(String username, String password)
{

 
WebElement login = alibabapage.getsignin();


login.click();

alibabapage.getusername().sendKeys(username);
alibabapage.getpassword().sendKeys(password);

alibabapage.getlogin().click();
String tittle = driver.getTitle();

assertEquals("signin", "sucessfull");

if(tittle.contains("Account"))
{
Reporter.log("signin sucess" , true);
}



}
@DataProvider(name = "drivertest")
public Object[][] fetchData() throws IOException
{
 String xlPath="C:\\Users\\DELL\\eclipse-workspace\\AutomationCaseStudy\\src\\test\\java\\com\\qa\\utility\\ExcelUtility.xlsx";
 String xlSheet="Sheet1";
 int rowcount=ExcelUtility.getRowCount(xlPath, xlSheet);
 int cellcount=ExcelUtility.getCellCount(xlPath, xlSheet, rowcount);
 String [][] data=new String[rowcount][cellcount];
 for(int i=1;i<=rowcount;i++)
 {
  for(int j=0;j<cellcount;j++)
  {
   data[i-1][j]=ExcelUtility.getCellData(xlPath, xlSheet, i, j);
  }
 }
 
 return data;
}

@DataProvider(name = "logintest")
public Object[][] getData() throws IOException
{
 String xlPath="C:\\Users\\DELL\\eclipse-workspace\\AutomationCaseStudy\\src\\test\\java\\com\\qa\\utility\\ExcelUtility.xlsx";
 String xlSheet="Sheet2";
 int rowcount=ExcelUtility.getRowCount(xlPath, xlSheet);
 int cellcount=ExcelUtility.getCellCount(xlPath, xlSheet, rowcount);
 String [][] data=new String[rowcount][cellcount];
 for(int i=1;i<=rowcount;i++)
 {
  for(int j=0;j<cellcount;j++)
  {
   data[i-1][j]=ExcelUtility.getCellData(xlPath, xlSheet, i, j);
  }
 }
 
 return data;
}
}