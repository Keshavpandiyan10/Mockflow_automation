package mockflow;

import static util.ConfigReader.getEmail;
import static util.ConfigReader.getPassword;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreatePage {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://mockflow.com/");
		driver.manage().window().maximize();
		
		//Scroll to bottom and back to top       		
		WebElement BottomElement = driver.findElement(By.xpath("//div[contains(@class, 'mf_type--mini mr-3 d-lg-inline mf_copyright_link')]"));	
		js.executeScript("arguments[0].scrollIntoView();", BottomElement);      
		System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'mf_type--mini mr-3 d-lg-inline mf_copyright_link')]")).getText());        
		Thread.sleep(3000);
		WebElement TopElement = driver.findElement(By.xpath("//div[@id='MockflowNavBar']"));
		js.executeScript("arguments[0].scrollIntoView();", TopElement);
		System.out.println(driver.findElement(By.xpath("//div[@id='MockflowNavBar']")).getText());
		Thread.sleep(3000);

		//Login to account
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='logusername']")).sendKeys(getEmail());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='logpassword']")).sendKeys(getPassword());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Create New'])[1]")));

		//Create a DarkMode UI
		driver.findElement(By.xpath("(//span[text()='Create New'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-id='webapp']")).click();
		Thread.sleep(3000);
		WebElement DarkUI = driver.findElement(By.xpath("//div[@data-name='Darkmode UI']"));  
		js.executeScript("arguments[0].scrollIntoView();", DarkUI);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-name='Darkmode UI']")).click();
		Thread.sleep(3000);       
		driver.findElement(By.xpath("//input[@id='mfUnityCreateProjectTitle']")).sendKeys("Wireframe - For automation purpose");       
		driver.findElement(By.xpath("//button[@id='mfNewProjectModalBtn']")).click();        
		Thread.sleep(5000); 
		//drag and drop
		WebElement From=driver.findElement(By.xpath("(//div[@class='mfCategoryItemsWrapper']/div)[1]"));	    
		WebElement To=driver.findElement(By.xpath("//div[@class='ui-droppable']"));					
		Actions act=new Actions(driver);					
		act.dragAndDrop(From, To).build().perform();	
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='mfNavPagesBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='mfPageAddBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='mfPageAddFolderBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='mfPageDupBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='mfPageEditBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='mfAddPageTitle']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='mfAddPageTitle']")).sendKeys("Page dup");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='mfAddPageModalBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='mfPageDelBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary bootbox-accept']")).click();
	}

}

