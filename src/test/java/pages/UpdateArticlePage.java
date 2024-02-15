package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UpdateArticlePage {
	
	@FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
	WebElement editBtn;
	
	@FindBy(xpath="//input[@placeholder='Article Title']")
	WebElement articleTitle;
	
	
	@FindBy(xpath="//input[@class='form-control ' and @name='description']")
	WebElement articleAbout;
	
	@FindBy(xpath="//textArea[@rows='8']")
	WebElement textArea;
	
	@FindBy(xpath="//input[@placeholder='Enter tags']") 
	WebElement enterTags;
	
	
	@FindBy(xpath="//button[contains(text(),'Update Article')]") 
	WebElement update_btn;
	
	@FindBy(xpath="(//a[@href='#/'])[2]") 
	WebElement home_btn;
	
	@FindBy(xpath="//button[@class='nav-link']") 
	WebElement globalfeed;
	
//	   @FindBy(xpath="//h1[contains(text(),'Articles of Testing')]")
//       WebElement headerCheckBtn;
	
	public UpdateArticlePage(WebDriver driver) { 
		PageFactory.initElements(driver,this); 
		}
	
	public void update(String ATitle,String Aabout) {
		editBtn.click(); 
		articleTitle.clear();
		articleTitle.sendKeys(ATitle);
		articleAbout.clear();
		articleAbout.sendKeys(Aabout); 
		update_btn.click();
		
		//Assert.assertEquals(headerCheckBtn.getText(),"Articles of Testing");
		//home_btn.click();
	}
	
	

}
