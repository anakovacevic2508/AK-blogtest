package cubes.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.category.CategoryAddPage;
import cubes.pages.category.CategoryListPage;
import cubes.pages.tag.TagsAddPage;
import cubes.pages.tag.TagsListPage;

public class CategoryTest {

	private static WebDriver driver;
	String newPostCategoryName = "TEST Post Cat AnaK";
	String editPostCategoryName = "TEST Post Cat AnaK1 ";
	String newPostCategoryDescription = "test case for post category functionality; test case for post category functionality";
	String editPostCategoryDescription = "editDesription of TEST Post Cat AnaK editDesription of TEST Post Cat AnaK editDesription of TEST Post Cat AnaK";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		driver = MyWebDriver.getDriver("chrome");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//fill in all fields and click on Save
		@Test
		public void tc01() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
					
			categoryListPage.clickOnAddNewCategory();
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			assertTrue("Post Categories add page open problem!", categoryAddPage.isOnPage());
			
			categoryAddPage.insertName(newPostCategoryName);
			categoryAddPage.insertDescription(newPostCategoryDescription);
			
			categoryAddPage.clickOnSave();
			
			assertTrue("Post Categories list open page problem.",categoryListPage.isOnPage());
			
			assertTrue("New post category missing!", categoryListPage.isPostCategoryNameElementOnPage(newPostCategoryName));
				
		}
		
		//same Name and click on Save
		@Test
		public void tc02() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
					
			categoryListPage.clickOnAddNewCategory();
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			assertTrue("Post Categories add page open problem!", categoryAddPage.isOnPage());
			
			categoryAddPage.insertName(newPostCategoryName);
			categoryAddPage.insertDescription(newPostCategoryDescription);
			
			categoryAddPage.clickOnSave();
			
			assertTrue("Missing error massage same Name", categoryAddPage.isErrorOnPage("The name has already been taken."));
				
		}
		//leave all fields empty and click Save
		@Test
		public void tc03() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
					
			categoryListPage.clickOnAddNewCategory();
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			assertTrue("Post Categories add page open problem!", categoryAddPage.isOnPage());
			
			categoryAddPage.insertName("");
			categoryAddPage.insertDescription("");
			
			categoryAddPage.clickOnSave();
			
			assertTrue("Missing error massage no Name", categoryAddPage.isEmptyNameErrorOnPage("This field is required."));
							
		}
		
		//leave Description empty and  click Save
		@Test
		public void tc04() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
					
			categoryListPage.clickOnAddNewCategory();
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			assertTrue("Post Categories add page open problem!", categoryAddPage.isOnPage());
			
			categoryAddPage.insertName(newPostCategoryName);
			categoryAddPage.insertDescription("");
			
			categoryAddPage.clickOnSave();
			
			assertTrue("Missing error massage no Name", categoryAddPage.isEmptyDescriptionErrorOnPage("This field is required."));
							
		}
		//leave Name empty and click Save
		@Test
		public void tc05() {
		CategoryListPage categoryListPage = new CategoryListPage(driver);
		
		categoryListPage.clickOnAddNewCategory();
		
		CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
		assertTrue("Post Categories add page open problem!", categoryAddPage.isOnPage());
		
		categoryAddPage.insertName("");
		categoryAddPage.insertDescription(newPostCategoryDescription);
		
		categoryAddPage.clickOnSave();
		
		assertTrue("Missing error massage no Name", categoryAddPage.isEmptyNameErrorOnPage("This field is required."));
		}
		
		//few letter in description
		@Test
		public void tc06() {
		CategoryListPage categoryListPage = new CategoryListPage(driver);
		
		categoryListPage.clickOnAddNewCategory();
		
		CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
		assertTrue("Post Categories add page open problem!", categoryAddPage.isOnPage());
		
		categoryAddPage.insertName("TEST");
		categoryAddPage.insertDescription("ss");
		
		categoryAddPage.clickOnSave();
		
		assertTrue("Missing error massage no Name", categoryAddPage.isErrorOnPage("The description must be at least 50 characters."));
		}
		
		//fill in all fields and click on Cancel
		@Test
		public void tc07() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
					
			categoryListPage.clickOnAddNewCategory();
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			assertTrue("Post Categories add page open problem!", categoryAddPage.isOnPage());
			
			categoryAddPage.insertName(newPostCategoryName);
			categoryAddPage.insertDescription(newPostCategoryDescription);
			
			categoryAddPage.clickOnCancel();
			
			assertTrue("Post Categories list open page problem.",categoryListPage.isOnPage());
			
			}
		
		// leave all fields empty and click Cancel
		@Test
		public void tc08() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
					
			categoryListPage.clickOnAddNewCategory();
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			assertTrue("Post Categories add page open problem!", categoryAddPage.isOnPage());
			
			categoryAddPage.insertName("");
			categoryAddPage.insertDescription("");
			
			categoryAddPage.clickOnCancel();
			
			assertTrue("Post Categories list open page problem.",categoryListPage.isOnPage());
			
			}
		
		//View previously created Post Category
		@Test
		public void tc09() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
			
			WebElement element = driver.findElement(By.xpath("//strong[text()='"+newPostCategoryName+"']"));

			MyWebDriver.scrollToWebElement(driver, element);
			
			categoryListPage.clickOnViewPostCategory(newPostCategoryName);
			
//			this.driver.navigate().to("https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories");
			//ne mogu da zatvorim view window koji se otvara
			
			}
		//ne znam da uradim nijedan jedini edit... jer pozivam metode iz CategoryAddPage a otvara zapravo EditPage,
		//ciji URL ne znam da nadjem jer je dinamican i menja se u zavisnosti od unosa
		//ni posle nekoliko dana nisam uspela da nadjem odgovor
		
		//Edit  - nothing is changed
//		@Test
//		public void tc10() {
//			CategoryListPage categoryListPage = new CategoryListPage(driver);
//			
//			WebElement element = driver.findElement(By.xpath("//strong[text()='"+newPostCategoryName+"']"));
//
//			MyWebDriver.scrollToWebElement(driver, element);
//			
//			categoryListPage.clickOnEditPostCategory(newPostCategoryName);
//			
//			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			
//			categoryAddPage.getCategoryNameWebElement().getText();
//			categoryAddPage.insertDescription(newPostCategoryDescription);
			
//			categoryAddPage.clickOnSave();
//			
//			assertTrue("Post Categories list open page problem.",categoryListPage.isOnPage());
//			
//			assertTrue("Post category name is missing!", categoryListPage.isPostCategoryNameElementOnPage(newPostCategoryName));
//			}
		
		//Edit previously created Post Category - change name and click Save
		@Test
		public void tc11() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
			
			WebElement element = driver.findElement(By.xpath("//strong[text()='"+newPostCategoryName+"']"));

			MyWebDriver.scrollToWebElement(driver, element);
			
			categoryListPage.clickOnEditPostCategory(newPostCategoryName);
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			
			categoryAddPage.insertName(editPostCategoryName);
			categoryAddPage.insertDescription(newPostCategoryDescription);
			
			categoryAddPage.clickOnSave();
			
			assertTrue("Post Categories list open page problem.",categoryListPage.isOnPage());
			
			assertTrue("Post category name is missing!", categoryListPage.isPostCategoryNameElementOnPage(editPostCategoryName));
			}
		
		
		//Delete previously created Post Category - Close button 
				@Test
				public void tc17() {
					CategoryListPage categoryListPage = new CategoryListPage(driver);
					
					WebElement element = driver.findElement(By.xpath("//strong[text()='"+editPostCategoryName+"']"));//ovde ovaj metod ne radi!?!

					MyWebDriver.scrollToWebElement(driver, element);
							
					categoryListPage.clickOnDeletePostCategory(editPostCategoryName);
	
					categoryListPage.clickOnDeleteDialogCloseButton();
					
					assertTrue("Post Categories list open page problem.",categoryListPage.isOnPage());
					
					assertTrue("Post Category is not on page!", categoryListPage.isPostCategoryNameElementOnPage(editPostCategoryName));
						
				}
				
	
		
		

}
