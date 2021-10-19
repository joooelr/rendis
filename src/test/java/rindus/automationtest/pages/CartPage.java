package rindus.automationtest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class CartPage extends Page {
	public CartPage(String url) {
		super(url);
	}
	
	public CartPage() {
		super();
	}
	
	public void setQtyDropdownByIndex(String value) {
		this.driver.findElement(By.xpath("//label[text()='Qty:']/..")).click();
		this.driver.findElement(By.xpath("//div[@class='a-popover-wrapper']//li[" + value + "]")).click();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public String getPrice() {
		return this.driver.findElement(By.xpath("//*[@class='sc-list-item-content']//p/span")).getText().replace("$", "");
	}
	
	public String getQty() {
		return this.driver.findElement(By.xpath("//label[text()='Qty:']/..//*[@class='a-dropdown-prompt']")).getText();
	}
	
	public String getTotal() throws InterruptedException {
		this.driver.manage().timeouts().wait(5);
		return this.driver.findElement(By.xpath("//*[@id='sc-subtotal-amount-activecart']/span")).getText().replace("$", "");
	}
}
