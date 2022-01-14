package com.akamai.pageObject;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

@SuppressWarnings("deprecation")
public class JobSerachPageObjects {

	WebDriver driver;

	public JobSerachPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[@type='search'])[1]")
	WebElement SerachKeyword;

	@FindBy(xpath = "(//*[@type='search'])[3]")
	WebElement FilterByCountry;

	@FindBy(xpath = "//*[@class='text-muted font-italic mb-2 overflow-hidden']")
	WebElement JobOffer;

	@FindBy(xpath = "//*[@class='ifc-icon ifc-search']")
	WebElement SerachIcon;

	public void waitForElementToBeClickable(long timeoutseconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementsToBeVisible(long timeoutseconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void sendJobKeyword(String string) {

		try {
			waitForElementToBeClickable(20, SerachKeyword);
			SerachKeyword.click();
			SerachKeyword.sendKeys(string);
			SerachKeyword.sendKeys(Keys.ARROW_DOWN);
			SerachKeyword.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println(e);
			e.getMessage();
		}
	}

	public void filterbycountry(String string) throws InterruptedException {

		try {
			FilterByCountry.click();
			FilterByCountry.sendKeys(string);
			waitForElementToBeClickable(20, FilterByCountry);
			FilterByCountry.sendKeys(Keys.ARROW_DOWN);
			waitForElementToBeClickable(20, FilterByCountry);
			FilterByCountry.sendKeys(Keys.ENTER);

		} catch (NoSuchElementException e) {
			System.out.println(e);
			e.getMessage();
		}
	}

	public void jobOffers() throws InterruptedException {

		try {
			Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
			String text = JobOffer.getText();
			System.out.println(text);
			String jobopenings = text.substring(9, 17);
			System.out.println(jobopenings);
			driver.close();
		} catch (NoSuchElementException e) {
			System.out.println(e);
			e.getMessage();
		}
	}

	public void findYourCareer(String string) throws InterruptedException {
		try {
			waitForElementToBeClickable(20, SerachKeyword);
			SerachKeyword.sendKeys(string);
			SerachIcon.click();
		} catch (NoSuchElementException e) {
			System.out.println(e);
			e.getMessage();
		}
	}

	public void noJobOffers(String string) throws InterruptedException {

		try {
			waitForElementsToBeVisible(20, JobOffer);
			String actual = JobOffer.getText().trim();
			assertEquals(actual, string);
			driver.close();
		} catch (NoSuchElementException e) {
			System.out.println(e);
			e.getMessage();
		}
	}

}
