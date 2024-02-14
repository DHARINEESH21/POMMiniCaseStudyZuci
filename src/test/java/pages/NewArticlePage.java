package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewArticlePage {
	
   @FindBy(xpath="//a[@href='#/editor']")
	WebElement article_btn;
   
   
   @FindBy(xpath="//input[@placeholder='Article Title']")
   WebElement articleTitle;

   
   @FindBy(xpath="//input[@class='form-control ' and @name='description']")
   WebElement articleAbout; 
   
   @FindBy(xpath="//textArea[@rows='8']")
   WebElement textArea;
   
  @FindBy(xpath="//input[@placeholder='Enter tags']") 
  WebElement enterTags;
 
   @FindBy(xpath="//button[@type='submit']") 	
   WebElement publish_article_btn;
   
   @FindBy(xpath="//h1[contains(text(),'Testing11')]")
   WebElement headerBtn;
 
 public NewArticlePage(WebDriver driver) {
	PageFactory.initElements(driver,this); 
	} 
 
 public void newArticle() {
	 article_btn.click();
	 articleTitle.sendKeys("Testing11");
	 articleAbout.sendKeys("Details of Testing"); 
	 textArea.sendKeys("Software testing can be stated as the process of verifying and validating whether a software or application is bug-free");
	 enterTags.sendKeys("Testing"); 
	 publish_article_btn.click(); 		
	   Assert.assertEquals(headerBtn.getText(),"Testing11");
 }
 
}
