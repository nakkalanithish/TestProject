package com.qa.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlibabaPages {

WebDriver driver;

@FindBy(xpath = "//*[@id=\"J_SC_header\"]/header/div[2]/div[2]/div/div/form/div[2]/input")
static
WebElement searchbar;
public static WebElement getsearchbar()
{
return searchbar;
}

@FindBy(xpath = "//*[@id=\"J_SC_header\"]/header/div[2]/div[2]/div/div/form/input[4]")
static
WebElement searchbutton;
public static WebElement getsearchbutton()
{
return searchbutton;
}

@FindAll(@FindBy(className = "elements-offer-price-normal__price"))
static
List<WebElement> prices;
public static List<WebElement> getprices()
{
return prices;
}

@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div/div[1]/div/div/div/div/div/div[2]/div[2]/div/h4/a/p")
WebElement product;

public WebElement getproduct()
{
return product;
}

@FindBy(linkText = "Sign In")
WebElement signin;
public WebElement getsignin() {
return signin;
}

@FindBy(name = "loginId")
WebElement username;
public WebElement getusername()
{
return username;
}

@FindBy(name = "password")
WebElement password;
public WebElement getpassword()
{
return password;
}

@FindBy(xpath = "//*[@id=\"fm-login-submit\"]")
WebElement login;
public WebElement getlogin()
{
return login;
}
public AlibabaPages(WebDriver driver)
{
this.driver = driver;
PageFactory.initElements(driver, this);
}

}
