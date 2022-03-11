package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	//shyani gaurav after branch code added
	
	/*
	 * WebElement email = driver.findElement(By.id("usernameInput-input"));;
	 * WebElement password = driver.findElement(By.name("password")); WebElement
	 * loginButton = driver.findElement(By.id("signIn")); WebElement globalError =
	 * driver.findElement(By.id("globalError")); WebElement error =
	 * driver.findElement(By.className("Error__text"));
	 */
	
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement loginButton;
	
	@FindBy(id = "globalError")
    public WebElement globalError;
	
	@FindBy(className = "Error__text")
    public WebElement error;
	
	public void openBrowser() throws IOException
	{
		FileInputStream f = new FileInputStream("/Users/shyanigaurav/Desktop/QA Projects New/Testing/Files/prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/shyanigaurav/Desktop/QA Projects New/SeleniumJars/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "/Users/shyanigaurav/Desktop/QA Projects New/SeleniumJars/chromedriver");
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.safari.driver", "/Users/shyanigaurav/Desktop/QA Projects New/SeleniumJars/safaridriver");
			driver = new SafariDriver();	
		}
		
		PageFactory.initElements(driver, this);
		
		driver.manage().window().maximize();
		
	}
	public void openLoginPage()
	{
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=6_e-KQbkE1E&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiNl9lLUtRYmtFMUUiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY0Mjk3MjA3OCwiaWF0IjoxNjQyOTcwODc4LCJqdGkiOiI5YWFhMDAyMy0yNjliLTQ1YTItOWIyNi1iNTc5ZWYwYThhOTQiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.cegx5Sr0zOcA7GRds410TMr41pX17PzIc2xfzQM66rOW3WKxbTRl2FoEG7txswFWpK_v6TMM4X-ZdOLujfaof8GzcPbzjdm1FTjy-6NcbOv4_D9TOCt2Rtq0hDijK1XsVehmRO0491nLUfq51U2fWCHqbl9jgUPdRnyPfM6tlq5MCKJKhIRYRzNaucsfwrBROGe4poW1W6p-cBlkOyRGfAsN1tTNHJ4DR7u6prnbAP88EsKlbckpQH5EytYYPzVaoa5HlhNSWZKBaXAwioWK_cIiGWb6Q7xKKI5Z2Up8Pkp_KU9PLSpmeQ6GzSES51hW7dMh0LOqhN7M27HcasEeCw&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	public void login(String a, String b) throws InterruptedException
	{
		email.sendKeys(a);
		password.sendKeys(b);
		loginButton.click();
		Thread.sleep(2000);
	}
	public String readGlobalErr()
	{
		String actualErrMsg = globalError.getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;
	}
	public String readErr()
	{
		String actualErrMsg = error.getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;
	}	
}