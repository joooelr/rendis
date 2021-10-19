package rindus.automationtest.pages;

import org.openqa.selenium.By;

public class ItemPage extends Page {

	public ItemPage(String url) {
		super(url);
	}
	public ItemPage() {
		super();
	}
		
	public void setSizeDropdown(String value) {
		
		this.driver.findElement(By.xpath("//span[@class='twister-dropdown-highlight transparentTwisterDropdownBorder']")).click();
		this.driver.findElement(By.xpath("//div[@class=\"a-popover-wrapper\"]//li[" + value + "]")).click();
	}
	
	public void setQtyDropdownByIndex(String value) {
		this.driver.findElement(By.xpath("//label[text()='Qty:']/..")).click();
		this.driver.findElement(By.xpath("//div[@class='a-popover-wrapper']//li[" + value + "]")).click();
	}
	
	public Boolean elementExist() {
		
		Boolean exist = true;
		if (this.driver.findElements(By.xpath("//span[@class='twister-dropdown-highlight transparentTwisterDropdownBorder']")).isEmpty()) {
			
			return false; 
		}
		return exist;
	}
	
	public void addToCart() {
		this.driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();
	}
}
