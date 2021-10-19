package rindus.automationtest.pages.controls;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rindus.automationtest.pages.Page;
import rindus.automationtest.pages.PageFactory;

public class Item {

	private WebElement root;

	public Item(WebElement root) {
		this.setRoot(root);
	}

	public WebElement getRoot() {
		return root;
	}

	public void setRoot(WebElement root) {
		this.root = root;
	}

	public <T extends Page> T open(Class<T> pageClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		System.out.println("before clivk");
		this.root.findElement(By.xpath(".//a[@class='a-link-normal a-text-normal']")).click();
		System.out.println("afte clivk");
		return PageFactory.create(pageClass);
	}
}