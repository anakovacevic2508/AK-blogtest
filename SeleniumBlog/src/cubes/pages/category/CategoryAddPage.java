package cubes.pages.category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryAddPage {

	private String url;
	private WebDriver driver;
	
	//WebElements
	@FindBy(xpath = "//input[@name='name']")
	private WebElement categoryNameWebElement;
	
	@FindBy(xpath ="//*[contains(@name,'description')]")
	private WebElement categoryDescriptionWebElement;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButtonWebElement;
	
	@FindBy(xpath = "//a[@class='btn btn-outline-secondary']")
	private WebElement cancelButtonWebElement;
	
	
	public CategoryAddPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add";
		this.driver = driver;
		this.driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		this.driver.get(url);
	}
	
	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnSave() {
		saveButtonWebElement.click();
	}
	
	public void clickOnCancel() {
		cancelButtonWebElement.click();
	}
	
	public void insertName(String name) {
		categoryNameWebElement.clear();
		categoryNameWebElement.sendKeys(name);
	}
	
	public void insertDescription(String description) {
		categoryDescriptionWebElement.clear();
		categoryDescriptionWebElement.sendKeys(description);
	}
	
	public boolean isErrorOnPage(String error) {
		WebElement nameErrorWebElement = driver.findElement(By.xpath("//div[@class='invalid-feedback']/div[1]"));
		
		return nameErrorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isEmptyNameErrorOnPage(String error) {
		WebElement nameErrorWebElement = driver.findElement(By.id("name-error"));
		
		return nameErrorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isEmptyDescriptionErrorOnPage(String error) {
		WebElement descriptionErrorWebElement = driver.findElement(By.id("description-error"));

		return descriptionErrorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public String getName() {
		return categoryNameWebElement.getAttribute("value");
	}
	
	public String getDescription() {
		return categoryDescriptionWebElement.getText();
	}
	
	public void createPostCategory(String name, String description) {
		insertName("TEST Post Cat AnaK");;
		insertDescription("test case for post category functionality; test case for post category functionality");
		clickOnSave();
	}

	public WebElement getCategoryNameWebElement() {
		return categoryNameWebElement;
	}

	public void setCategoryNameWebElement(WebElement categoryNameWebElement) {
		this.categoryNameWebElement = categoryNameWebElement;
	}

	public WebElement getCategoryDescriptionWebElement() {
		return categoryDescriptionWebElement;
	}

	public void setCategoryDescriptionWebElement(WebElement categoryDescriptionWebElement) {
		this.categoryDescriptionWebElement = categoryDescriptionWebElement;
	}

	public WebElement getSaveButtonWebElement() {
		return saveButtonWebElement;
	}

	public void setSaveButtonWebElement(WebElement saveButtonWebElement) {
		this.saveButtonWebElement = saveButtonWebElement;
	}

	public WebElement getCancelButtonWebElement() {
		return cancelButtonWebElement;
	}

	public void setCancelButtonWebElement(WebElement cancelButtonWebElement) {
		this.cancelButtonWebElement = cancelButtonWebElement;
	}
	
	
}
