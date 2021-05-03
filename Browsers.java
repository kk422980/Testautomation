package com.project.automate;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	public class Browsers {

		static WebDriver driver;

		public static WebDriver setup(String browser, String url) {

			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "E:\\sele\\driver\\chrome\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver", "E:\\sele\\driver\\e\\msedgedriver.exe");
				 driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "E:\\sele\\driver\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				 driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}
	}

