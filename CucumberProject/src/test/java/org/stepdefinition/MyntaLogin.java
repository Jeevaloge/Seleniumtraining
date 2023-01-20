package org.stepdefinition;

import java.io.File;
import java.io.IOException;

import org.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sam.MyntraLoginPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyntaLogin extends BaseClass {

	private static final WebElement product = null;
	private static final WebElement bag = null;
	MyntraLoginPojo m;
	Actions a;
	Select s;
	TakesScreenshot ts;
	File f;

	@Given("To launch the chrome browser and maximize window")
	public void to_launch_the_chrome_browser_and_maximize_window() {
		launchBrowser();
		WindowMaximize();
	}

	@Given("To launch the url of the myntra application")
	public void to_launch_the_url_of_the_myntra_application() {
		launchUrl("https://www.myntra.com/");
	}

	@Given("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field() {
		m = new MyntraLoginPojo();
        passText("Jeevaloge086@gmail.com", m.getMblnumber());

	}

	@Given("To pass invalid password in password field")
	public void to_pass_invalid_password_in_password_field() {
		m = new MyntraLoginPojo();
		passText("Jeevaloge@7", m.getPassword());
	}

	@Given("To click the login button")
	public void to_click_the_login_button() {
		m = new MyntraLoginPojo();
		clickBtn(m.getLoginBtn());

	}

	@Given("To click on search label")
	public void to_click_on_search_label() {
		m = new MyntraLoginPojo();
		a.click();

	}

	@Given("To search T-shirt product")
	public void to_search_T_shirt_product() {
		m = new MyntraLoginPojo();
		a.sendKeys("T-shirt");
	}

	@Given("To select the {int}st product")
	public void to_select_the_st_product(Integer int1) {
		m = new MyntraLoginPojo();
		s.getFirstSelectedOption();

	}

	@Given("To add product to bag")
	public void to_add_product_to_bag() {
		m = new MyntraLoginPojo();
		m.dragDrop(product, bag);
	}

	@Given("To close the current tab")
	public void to_close_the_current_tab() {
		driver.close();
	}

	@When("To click on bag icon")
	public void to_click_on_bag_icon() {
		m = new MyntraLoginPojo();
		a.click().perform();
	}

	@Then("To take the screenshot")
	public void to_take_the_screenshot() throws IOException {
		m = new MyntraLoginPojo();
		ts = (TakesScreenshot) driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		f = new File("C:\\Users\\Admin\\eclipse-workspace\\CucumberProject\\webPageScreenShot\\myntra.jpg");
        FileUtils.copyFile(img, f);
	}

}
