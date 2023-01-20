package org.sam;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbloginPojo extends BaseClass {

	public void Fbloginpojo() {
		PageFactory.initElements(driver, this);
	}

	// private webelement
	@FindBy(id = "email")
	private WebElement email;

	@FindBy(xpath = "// input[@aria-label='Password']")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginBtn;

	// getters to access the webelement outside the class

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
