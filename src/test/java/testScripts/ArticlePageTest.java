package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DeleteArticlePage;
import pages.LoginValidPage;
import pages.NewArticlePage;
import pages.UpdateArticlePage;

public class ArticlePageTest {
	WebDriver driver;
	LoginValidPage loginPage;
	NewArticlePage newArticlePage;
    UpdateArticlePage updateArticle; 
    DeleteArticlePage deleteArticle;
	
  
  public ArticlePageTest() {
	  TestBase.initDriver();
	  driver = TestBase.getDriver();
	  loginPage = new LoginValidPage (driver) ;		
	  newArticlePage=new NewArticlePage(driver); 		
	 updateArticle=new UpdateArticlePage(driver);
	  deleteArticle=new DeleteArticlePage(driver);
  }
	  
	  
	  @BeforeTest
	 public void setup() {
		 TestBase.openUrl("http://conduit-realworld-example-app.fly.dev/"); 	
		 }
	  
	 @Test(priority=1)
	 public void loginTest() {
		 loginPage.loginTest("Username@gmail.com","Username");
	 }
	 
	 @Test(priority=2)
	 public void newArticle() {
		 newArticlePage.newArticle();
	 
	 }
	 
	 @Test(priority=3)
	 public void updateArticlePage() {
		 updateArticle.update(driver); 	
	 }
	 
	@Test(priority=4)
	public void deleteArticle() {
		deleteArticle.deleteArticle();
	}
  
}










