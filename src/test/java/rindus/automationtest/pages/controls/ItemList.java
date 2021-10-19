package rindus.automationtest.pages.controls;

import rindus.automationtest.core.DriverSingleton;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemList  {
	protected WebDriver driver;
	public ItemList() {
		this.driver = DriverSingleton.getInstance().getDriver();
	}
	
	public List<Item> getItemList(){
		System.out.println("getItemList");
		return this.driver.findElements(By.xpath("//div[contains(@data-cel-widget,'search_result')]//div[@class='sg-col-inner']")).stream().map(m -> new Item(m)).collect(Collectors.toList());
	}
}
