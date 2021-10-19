	package rindus.automationtest.pages;
	import rindus.automationtest.core.DriverSingleton;
	import rindus.automationtest.pages.controls.Menu;
	
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	
	public class Page {
	
	    protected WebDriver driver;
	    public WebElement title;
	    public WebElement description;
	    protected String url;
		public Menu menu = new Menu();
	    public WebElement searchButton;
		public WebElement search;
		
	    public Page(String url) {
	        this.driver = DriverSingleton.getInstance().getDriver();
	        this.url = url;
	    }
	    		
	    public Page() {
	        this.driver = DriverSingleton.getInstance().getDriver();
	    }
	    
		public void setSearch() {
			search = this.driver.findElement(By.id("twotabsearchtextbox"));
		}
		
		public WebElement getSearch() {
			return this.driver.findElement(By.id("twotabsearchtextbox"));
		}
		
		public WebElement getSearchButton() {
			return this.driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
		}
	
	    public void open() {
	        this.driver.navigate().to(url);
	        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        this.driver.manage().window().maximize();
	    }
	
	    public void quit() {
	        this.driver.close();
	        this.driver.quit();
	        this.driver = null;
	    }
	
	    public void setUrl(String url) {
	        this.url = url;
	    }
	
	    public WebDriver getDriver() {
	        return this.driver;
	    }
	
	}
