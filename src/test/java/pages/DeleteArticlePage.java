package pages;
 
import java.time.Duration;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
public class DeleteArticlePage {
	WebDriver driver;
	
//	@FindBy(xpath="(//button[text()=' Delete Article'])[2]")
//    WebElement deleteBtn;
	
	
	@FindBy(xpath = "(//button[@class='btn btn-sm'])[1]")
	WebElement deleteBtn;
	
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement chck;

	public DeleteArticlePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void deleteArticle()
	{
		
		deleteBtn.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions:Ele)
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Want to delete the article?");
		alert.accept();

	}
	
	public String deleteCheck()
	{
		return chck.getText();
	}

 
 
}