package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxBrowser implements Browser{
		//@Override
		public WebDriver openBrowser(String url) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
	//	WebDriver driver = new FirefoxDriver();
		
		options.setHeadless(true);
	    WebDriver driver = new FirefoxDriver(options);
	    driver.get(url);
	    return driver;
		
	}

}
