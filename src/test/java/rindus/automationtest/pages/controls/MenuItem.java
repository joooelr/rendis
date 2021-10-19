package rindus.automationtest.pages.controls;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebElement;

import rindus.automationtest.pages.Page;
import rindus.automationtest.pages.PageFactory;

public class MenuItem {

	private WebElement root;
	public MenuItem(WebElement root) {
		this.setRoot(root);
	}
	public WebElement getRoot() {
		return root;
	}
	public void setRoot(WebElement root) {
		this.root = root;
	}
	
	public  <T extends Page> T open (Class<T> pageClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.root.click();
		T page = PageFactory.create(pageClass);
		return page;
    }
}