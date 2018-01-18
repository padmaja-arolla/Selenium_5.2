package com.atm.modulefive.webdriver.advanced.mandatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.atm.modulefive.webdriver.advanced.utils.ActionUtility;
import com.atm.modulefive.webdriver.advanced.utils.DataUtility;

public class VoloTeaFlightSearch {
	
	@FindBy(xpath = "//input[@name='origin']")
	private WebElement FIELD_ORIGIN;

	@FindBy(xpath = "//input[@name='destination']")
	private WebElement FIELD_DESTINATION;
	
	@FindBy(xpath = "//a[contains(text(),'PRG')]")
	private WebElement LINK_ORIGIN;

	@FindBy(xpath = "//a[contains(text(),'VCE')]")
	private WebElement LINK_DESTINATION;

	@FindBy(xpath = "//div[contains(@class,'group-last')]")
	private WebElement CALENDAR;
	
	@FindBy(xpath = "//div[contains(@class,'group-first')]//table//td[@data-handler='selectDay']/a[text()=30]")
	private WebElement CAL_START_DATES;

	@FindBy(xpath = "//div[contains(@class,'group-last')]//table//td[@data-handler='selectDay']/a[text()=14]")
	private WebElement CAL_RETURN_DATES;

	@FindBy(xpath = "//select[@name='children']")
	private WebElement CHILDREN;
	
	@FindBy(xpath = "//form[@name='vm.searchSubmit']//a")
	private WebElement LINK_FINDFLIGHTS;

	private WebDriver driver;
		

	public VoloTeaFlightSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public VoloTeaFlightSummary addOriginReturnDetails() {
		ActionUtility.waitForPageLoaded(driver);
		ActionUtility.waitForElementClickable(driver, 6, FIELD_ORIGIN);
		System.out.println("Entering Origin Location as PRG");
		FIELD_ORIGIN.click();
		LINK_ORIGIN.click();
		ActionUtility.waitForPageLoaded(driver);
		System.out.println("Entering Origin Location as VCE");
		FIELD_DESTINATION.click();
		LINK_DESTINATION.click();
		ActionUtility.waitForElementClickable(driver, 6, CALENDAR);
		System.out.println("Entering Origin Date as: "+DataUtility.getSelectedstartdate());
		CAL_START_DATES.click();
		ActionUtility.waitForPageLoaded(driver);
		System.out.println("Entering Origin Date as: "+DataUtility.getSelectedreturndate());
		CAL_RETURN_DATES.click();
		return new VoloTeaFlightSummary(driver);				
	}

	public  VoloTeaFlightSummary doFlightSearch(String count) {
		System.out.println("Selecting number of children as: "+DataUtility.getChildrenCount());
		Select childList = new Select(CHILDREN);
		childList.selectByValue(count);
		ActionUtility.waitForElementClickable(driver, 6, LINK_FINDFLIGHTS);
		LINK_FINDFLIGHTS.click();
		System.out.println("Clicked on Find Flights.... Retriving the results for the search query made");
		ActionUtility.waitForPageLoaded(driver);
		return new VoloTeaFlightSummary(driver);
		
	}

}
