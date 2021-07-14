package final_project;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class lowalert {
	public void get_lowalert(String al){
		System.setProperty("webdriver.chrome.driver","/Users/pryang/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
	    WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cwb.gov.tw/V8/C/P/Warning/W23.html"); 
		WebElement alert =driver.findElement(By.cssSelector("body > div.wrapper > main > div > div > div > div > div > p"));
		
		//System.out.println(alert.getText());
		final_project.lowalert=alert.getText();
		al=alert.getText();
		driver.quit(); //關閉瀏覽器
	}
}
