package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	
	private WebDriver driver;
	private By firstName = By.id("input_10_1");
	private By lastName = By.id("input_10_2");
	private By email = By.id("input_10_5");
	private By message = By.id("input_10_4");
	private By contactNumber = By.id("input_10_6");
	private By cookieNotice = By.xpath("//*[@id='cn-close-notice']");


	private By sendButton = By.xpath("//*[@id=\"gform_submit_button_10\"]");
	private By successMessg = By.id("gform_confirmation_message_10");
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactUsForm(String firstNameText,String lastNameText, String emailText,String contactNumberText,String messageText) {
		//Select select = new Select(driver.findElement(subjectHeading));
		//select.selectByVisibleText(heading);
		if(cookieNotice!=null){driver.findElement(cookieNotice).click();}
		driver.findElement(firstName).sendKeys(firstNameText);
		driver.findElement(lastName).sendKeys(lastNameText);
		driver.findElement(email).sendKeys(emailText);
		driver.findElement(contactNumber).sendKeys(contactNumberText);
		driver.findElement(message).sendKeys(messageText);

	}

	public void clickSend() {
		driver.findElement(sendButton).click();
		try {
			// Sleep for 3 seconds
			Thread.sleep(3000); // 10000 milliseconds = 10 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getSuccessMessg() {
		return driver.findElement(successMessg).getText();
	}
	
	
	
	

}
