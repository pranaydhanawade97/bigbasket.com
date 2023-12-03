package Main;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	
		driver.manage().window().maximize();
		//1.visit bigbasket webpage
		driver.get("https://www.bigbasket.com/");
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//2.click on Locate location
		
		
		driver.findElement(By.xpath("(//*[name()='path'])[14]")).click();
		
		//3.Enter the Location
		
		driver.findElement(By.xpath("(//input[@placeholder='Search for area or street name'])[2]")).sendKeys("Dahisar");
		
		//4.click on location
		driver.findElement(By.xpath("//div[@class='grid grid-flow-col gap-x-6 h-9 mt-3.5 mb-2.5']//li[1]")).click();
		
		//5.search on Serach Filed
		
		Thread.sleep(5000);
		 
		 WebElement one = driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]"));
		 one.sendKeys("Cake");
		 
		 Thread.sleep(2000);
		 
		 //6.Click on Add and Increase quantity 1 to 5
		 WebElement quan=driver.findElement(By.xpath("(//button[@class='Button-sc-1dr2sn8-0 QuickSearch___StyledButton-sc-rtz2vl-12 khNcdr kGCFBb'][normalize-space()='Add'])[3]"));
		 quan.click();
		 
		 WebElement plus= driver.findElement(By.xpath("//button[@id='increment']//*[name()='svg']"));
		 
		 for(int i=1;i<=4;i++) {
			 plus.click();
			 
		 }
		 
		 //iteam added into basket pop message should display in output
		 WebElement msg=driver.findElement(By.xpath("//p[@class='mx-4 flex-1']"));
		 
		 String popmessage=msg.getText();
		 
		 System.out.println("Pop-up message: "+ popmessage);
		 
		 //Click On Offers
		 Thread.sleep(2000);
		 
		 JavascriptExecutor yg = (JavascriptExecutor) driver;

		// Replace 100, 100 with the X and Y coordinates you want to click
		 yg.executeScript("document.elementFromPoint(100, 100).click();");

		 
		 Thread.sleep(2000);
		 
		 //click on Offers
		 driver.findElement(By.xpath("(//img[@alt='banners'])[1]")).click();
		 
		 //get output of All offers Header
		 
		
		 List<WebElement> elements1 = driver.findElements(By.xpath("(//h2[normalize-space()='Best Sellers'])[1]"));
		 List<WebElement> elements2 = driver.findElements(By.xpath("(//h2[@class='section-title ng-binding'])[2]"));
		 List<WebElement> elements3 = driver.findElements(By.xpath("(//h2[@class='section-title ng-binding'])[3]"));
		 

		 
		 for (WebElement element : elements1) {
		     String elementText = element.getText();
		     
		     System.out.println("First offer: " + elementText);
		 }

		 
		 for (WebElement element : elements2) {
		     String elementText = element.getText();
		     
		     System.out.println("Secound offer: " + elementText);
		 }
		 
		 for (WebElement element : elements3) {
		     String elementText = element.getText();
		     
		     System.out.println("Third Offer: " + elementText);
		 }
		 
		 //click on logo 
		 driver.findElement(By.xpath("//div[@id='st-trigger-effects']")).click();
		 
//		 Thread.sleep(1000);
		
		 
		 //Scroll WebPage 
		 
//		 JavascriptExecutor test = (JavascriptExecutor) driver;
//
//	        
//		 test.executeScript("window.scrollBy(0, 1500)");
	    
	    //click on add from best sellers 
	    
//		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//div[@class='relative flex flex-col w-full lg:h-8 xl:h-9 overflow-hidden'])[8]")).click();
		
		
		//Click on Category field 
		
		driver.findElement(By.xpath("(//button[@id='headlessui-menu-button-:R5bab6:'])[1]")).click();
		
		//Mouse Hover on Foodgrains & oil and Masala 
		//get the output of all selected Option
		
		Thread.sleep(1000);
		
		WebElement elem = driver.findElement(By.linkText("Foodgrains, Oil & Masala"));
		Actions action = new Actions(driver);
		action.moveToElement(elem).perform();
		
		String first=elem.getText(); 
		System.out.println("Category: "+ first);
		
	/*------------------------------------------------------------------------------------*/	
		WebElement element2 = driver.findElement(By.linkText("Dry Fruits"));
		Actions actiontwo = new Actions(driver);
		actiontwo.moveToElement(element2).perform();
		
		String two=element2.getText();
		System.out.println("Sub Category: "+two);
		
	/*------------------------------------------------------------------------------------*/		
		
		
		WebElement element3=driver.findElement(By.linkText("Almonds"));
		Actions actionthree = new Actions(driver);
		actionthree.moveToElement(element3).perform();
		
		String three=element3.getText();
		System.out.println("Sub Category third: "+three);
		
		
		action.click(element3).perform();
		
		JavascriptExecutor testt = (JavascriptExecutor) driver;
		
		testt.executeScript("window.scrollBy(0, -1500)");
		
		//Click on Relevent & get the All options in outout
		WebElement rel= driver.findElement(By.xpath("//span[@class='Label-sc-15v1nk5-0 ListSorter___StyledLabel-sc-1btacag-1 gJxZPQ hneWsn']"));
		rel.click();
		
		
		WebElement list =driver.findElement(By.xpath("//ul[@role='listbox']"));
		
		String relevent=list.getText();
		
		System.out.println(relevent);
		
		//Click on % Off - High to Low
		
		Thread.sleep(5000);
		
		WebElement li=driver.findElement(By.xpath("//span[normalize-space()='% Off - High to Low']"));
		li.click();
		
		Thread.sleep(5000);
		
		//filter Scrolling 
		WebElement table =driver.findElement(By.xpath("//div[4]//div[2]//span[5]"));

		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@id='i-Rs201toRs500']")).click();
		
		Thread.sleep(4000);
		
		
		
		//show India from Filter
		WebElement country=driver.findElement(By.xpath("//label[@for='i-India']"));
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", country);
		
		String cou=country.getText();
		System.out.println("Country :"+ cou);
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#i-India")).click();
		
		
		
		Thread.sleep(4000);
	
		WebElement pro1=driver.findElement(By.xpath("//img[@title='ProV Select California Almonds - Whole, Natural, Independence 500 g']"));
		pro1.click();
		
		String winhandlebefore=  driver.getWindowHandle();
		
		for(String winhandle: driver.getWindowHandles()) {
				
			driver.switchTo().window(winhandle);
		}
		
		//redirect to product page 
		
		WebElement text=driver.findElement(By.xpath("//h1[@class='Description___StyledH-sc-82a36a-2 bofYPK']"));
		String name=text.getText();
		System.out.println("Product Name: "+name);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0, 1500)");
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//button[@color='silverSurfer'])[12]")).click();
		
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0, 2000)");
		//click on add button
		Thread.sleep(3000);		
			
		
		//show Popular categories in output
		WebElement text2=driver.findElement(By.xpath("//div[@class='flex pb-1 mb-6 overflow-hidden max-h-40']//div[1]"));
		String list2=text2.getText();
		System.out.println("Popular categories: "+list2);
		
		//click on become a seller
		JavascriptExecutor SS = (JavascriptExecutor) driver;
		SS.executeScript("window.scrollBy(0,-1300)");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[normalize-space()='Become a Seller'])[1]")).click();
		
	}

}
