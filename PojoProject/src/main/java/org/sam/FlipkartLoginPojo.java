package org.sam;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartLoginPojo extends BaseClass {

	public FlipkartLoginPojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@type='text'])[2])")
	private WebElement email;

	@FindBy(xpath = "//input[@type='password]")
	private WebElement password;
	
	
	@FindBy(xpath = "submit")
	private WebElement loginBtn;


	public WebElement getEmail() {
		return email;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
}
