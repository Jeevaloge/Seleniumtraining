package org.poj;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyntraLoginPojo extends BaseClass {

	@FindBy(xpath = "id=mobileNumberPass")
	private WebElement mblnumber;

	@FindBy(xpath = "(//input[@autocomplete='new-password'])[2]")
	private WebElement password;

	@FindBy(xpath = "id=LOGIN")
	private WebElement loginBtn;

	// getters and setters to access the webelement outside the class

	public WebElement getMblnumber() {
		return mblnumber;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
