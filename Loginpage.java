package com.project.automate;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

	WebDriver driver;

	public void LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[1]/div/a")
	WebElement Signin;
	
	@FindBy(xpath = "//*[@id=\"id_userLoginId\"]")
	WebElement username;
	
	@FindBy(xpath = "//*[@id=\"id_password\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/form/button")
	WebElement SignButton;

//	@FindBy(xpath = "//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[1]/div/a")
//	WebElement Signout;
	
	
	public void logInToFlipkart(String uid, String pws) {
		
		Signin.click();
		username.sendKeys(uid);
		password.sendKeys(pws);
		SignButton.click();
		//Signout.click();
	}
}
