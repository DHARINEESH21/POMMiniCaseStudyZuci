package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginValidPage {
	
      @FindBy (xpath="//a[@href='#/login']")
      WebElement login_btn;
      
      
      @FindBy(xpath="//input[@name='email']")
      WebElement email;
      
      @FindBy(xpath="//input[@name='password']")
      WebElement password;
      
      @FindBy(xpath="//button[contains(text(),'Login')]")
      WebElement loginbtn;
      
      @FindBy(xpath="//img[@alt='Username']")
    	WebElement chckName;
      
     public  LoginValidPage (WebDriver driver) { 
    	 
    	 PageFactory.initElements(driver,this);
     
     }
     
     public void validloginTest(String stremail,String strpassword) {
    	login_btn.click(); 	
    	 email.sendKeys(stremail); 	 
    	 password.sendKeys(strpassword); 	
    	 loginbtn.click(); 	
    	 
    	 }
     
     public boolean loginName()
 	{
 		boolean loginName= chckName.isDisplayed();
 		
 		return loginName;
 	}
    }

