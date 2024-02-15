package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import base.TestBase;
import commonUtils.Utility;
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
    ExtentReports extentReports;
    ExtentSparkReporter spark;
    ExtentTest extentTest;
  
  public ArticlePageTest() {
	  TestBase.initDriver();
	  driver = TestBase.getDriver();
	  loginPage = new LoginValidPage (driver) ;		
	  newArticlePage=new NewArticlePage(driver); 		
	  updateArticle=new UpdateArticlePage(driver);
	  deleteArticle=new DeleteArticlePage(driver);
  }
	  
	@BeforeTest
	public void setupExtent() {
		extentReports=new ExtentReports();
		spark=new ExtentSparkReporter("test-output/Sparkreport.html")
				   .viewConfigurer()
				   .viewOrder()
				   .as(new ViewName[] {
						 ViewName.DASHBOARD,
						 ViewName.TEST,
						 ViewName.AUTHOR,
						 ViewName.DEVICE,
						 ViewName.LOG
				   }).apply();
	    extentReports.attachReporter(spark);
	}
	
	  @BeforeTest
	 public void setup() {
		 TestBase.openUrl("http://conduit-realworld-example-app.fly.dev/"); 	
		 }
	  
	  
	 @Test(priority=1)
	 public void loginTest() {

		extentTest=extentReports.createTest("Login Test");
		loginPage.loginTest("Username@gmail.com","Username");
		String username=driver.findElement(By.xpath("//div[contains(text(),'Username')]")).getText();
		Assert.assertEquals(username,"Username");
	 }
	 
	 
	 @Test(priority=2)
	 public void newArticle() {

		 extentTest=extentReports.createTest("New Article Test");
         newArticlePage.newArticle("Testing11","Details of Testing","Software testing can be stated as the process of verifying and validating whether a software or application is bug-free","Testing");
	     String headerText=driver.findElement(By.xpath("//h1[contains(text(),'Testing11')]")).getText();
	     System.out.println("New Article Title-"+headerText);
         Assert.assertEquals(headerText,"Testing11");
}


	 
	 
	 
	 @Test(priority=3)
	 public void updateArticlePage() {


		 extentTest=extentReports.createTest("Update Article Test");
	     updateArticle.update("Articles of Testing","Testing Articles written by software developers for software developers.");
	     String nameOfArticle=driver.findElement(By.xpath("//h1[contains(text(),'Articles of Testing')]")).getText();
	   //  System.out.println("Updated Article Title- "+nameOfArticle);
	     Assert.assertEquals(nameOfArticle,"Articles of Testing");

	 }
	 
	 
	@Test(priority=4)
	public void deleteArticle() {
		
		
		extentTest=extentReports.createTest("Delete Article Test");
		deleteArticle.deleteArticle();
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Want to delete the article?");
		alert.accept();

	}
	
	
	@AfterMethod
	  public void teardown(ITestResult result) {
		  extentTest.assignAuthor("AutomationTester1")
		  .assignCategory("Regression Test")
		  .assignDevice(System.getProperty("os.name"))
		  .assignDevice(System.getProperty("os.version"));
		  
		  if(ITestResult.FAILURE==result.getStatus()) {
			  extentTest.log(Status.FAIL,result.getThrowable().getMessage());
			  String strPath=Utility.getSreenshotPath(driver);
			   extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		  }
	}
	@AfterTest
	   public void finishExtent() {
		  extentReports.flush();
	  }
	}
  



