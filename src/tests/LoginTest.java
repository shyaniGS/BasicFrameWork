package tests;

import org.testng.annotations.Test;

import data.DataXLS;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest 
{
		LoginPage lp = new LoginPage();
		DataXLS d = new DataXLS();
		
		
	@Test (priority = 1)
	public void loginWithWrongEmailPasswordTest() throws InterruptedException 
	{
		lp.login(d.wrongEmail,d.wrongPassword);
		Assert.assertEquals(lp.readGlobalErr(), d.globalErr);
	}
  @Test (priority = 2)
  public void loginWithEmptyEmailTest() throws InterruptedException 
  {
	  	lp.login("",d.wrongPassword);
		Assert.assertEquals(lp.readErr(), d.emptyEmailErr);
  } 
  @Test (priority = 3)
  public void loginWithEmptyPasswordTest() throws InterruptedException 
  {
	  	lp.login(d.wrongEmail,"");
		Assert.assertEquals(lp.readErr(), d.emptyPassErr);
  }
  @Test (priority = 4)
  public void loginWithSpecialCharEmailTest() throws InterruptedException 
  {
	  	lp.login(d.emailWithSpecialChar,d.wrongPassword);
		Assert.assertEquals(lp.readErr(), d.emailWithSpecialCharErr);
  }
  @BeforeMethod
  public void beforeMethod() throws IOException 
  {
	  lp.openBrowser();
	  lp.openLoginPage();
  }
  @AfterMethod
  public void afterMethod() throws InterruptedException 
  {
	  lp.closeBrowser();
  }
}