package rindus.automationtest.pages;

import rindus.automationtest.pages.controls.ItemList;

public class HomePage extends Page {
	public ItemList itemList = new ItemList();
		
	public HomePage(String url) {
		super(url);
	}
	public HomePage() {
		super();
	}
}