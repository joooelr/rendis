package rindus.automationtest.pages.controls;

import rindus.automationtest.core.DriverSingleton;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu  {
	protected WebDriver driver;
	public Menu() {
		this.driver = DriverSingleton.getInstance().getDriver();
	}
	
	public List<MenuItem> getMenuList(){
		return this.driver.findElements(By.xpath("//*[@id='nav-tools']/a")).stream().map(m -> new MenuItem(m)).collect(Collectors.toList());
	}
}
