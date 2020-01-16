package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.openqa.selenium.chrome.ChromeOptions;

import utikity.Helper;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;

	public static String downloadPath = System.getProperty("user.dir") + "\\downloads";

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments( "--incognito", "--start-maximized");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation")); 
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	@BeforeSuite
	@Parameters(("browser"))
	public void startDiver( @Optional ("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driverss/chromedriver.exe");
			driver = new ChromeDriver(chromeOption()); 
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/driverss/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/driverss/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (browserName.equalsIgnoreCase("headless")) 
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir")+"/driverss/phantomjs.exe");
			String [] phantomJsDriver = {"--web-secuirity=no","--igonre-ssl--errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsDriver);
			driver = new PhantomJSDriver(caps);
		}
		else if (browserName.equalsIgnoreCase("chrome-headless"))
		{
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"/driverss/chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();

	}
	@AfterMethod
	public void screenshotOnFaliure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking screenshot..");
			Helper.captureScreenShot(driver, result.getName());
		}
	}
}
