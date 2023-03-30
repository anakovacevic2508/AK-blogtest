package cubes.pages.category;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cubes.helper.MyWebDriver;

public class CategoryListPage {

	private String url;
	private WebDriver driver;
	
	//WebElements
	@FindBy(xpath = "//button[@class='btn btn-outline-secondary']")
	private WebElement changeOrderWebElement;
	
	@FindBy(xpath = "//a[@class='btn btn-success']")
	private WebElement addNewCategoryWebElement;
	
	public CategoryListPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories";
		this.driver = driver;
		this.driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		driver.get(url);
	}
	
	public boolean isOnPage() {
		return driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnChangeOrder() {
		changeOrderWebElement.click();
	}
	
	public void clickOnAddNewCategory() {
		addNewCategoryWebElement.click();
	}
	
	public void clickOnViewPostCategory(String postCategoryName) {
		WebElement viewWebElement = driver.findElement(By.xpath("//strong[text()='"+postCategoryName+"']//ancestor::tr/td[6]/div[1]/a[1]"));
		viewWebElement.click();
	}
	
	public void clickOnEditPostCategory(String postCategoryName) {
		WebElement editWebElement = driver.findElement(By.xpath("//strong[text()='"+postCategoryName+"']//ancestor::tr/td[6]/div[1]/a[2]"));
		editWebElement.click();
	}
	
	public void clickOnDeletePostCategory(String postCategoryName) {
		WebElement deleteWebElement = driver.findElement(By.xpath("//strong[text()='"+postCategoryName+"']//ancestor::tr/td[6]/div[1]/button[1]"));
		deleteWebElement.click();
	}
	
	public void clickOnDeleteDialogCancelButton() {
		WebElement cancelWebElement = driver.findElement(By.xpath("//button[text()='Cancel']"));
		cancelWebElement.click();
	}
	
	public void clickOnDeleteDialogCloseButton() {
		WebElement closeWebElement = driver.findElement(By.xpath("//button[@class='close']"));
		closeWebElement.click();
	}
	
	public void clickOnDeleteDialogDeleteButton() {
		WebElement deleteWebElement = driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteWebElement.click();
	}
	
	public boolean isPostCategoryNameElementOnPage(String postCategoryName) {
		List<WebElement> webElements = driver.findElements(By.xpath("//strong[text()='"+postCategoryName+"']"));
		return webElements.size()>0;
	}
	
	public boolean isPostCategoryDescriptionElementOnPage(String postCategoryDescription) {
		List<WebElement> webElements = driver.findElements(By.xpath("//strong[text()='"+postCategoryDescription+"']"));
		return webElements.size()>0;
	}
	
	
	
}
