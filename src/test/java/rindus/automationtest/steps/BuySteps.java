package rindus.automationtest.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rindus.automationtest.browser.Browser;
import rindus.automationtest.pages.CartPage;
import rindus.automationtest.pages.HomePage;
import rindus.automationtest.pages.ItemPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuySteps {
	String url = "";
	HomePage page;
	ItemPage itemPage;
	CartPage cartPage;
	String price;
	String qty;
	String total;
	String obtainedPrice;
	String obtainedQty;
	String obtainedTotal;

	@Given("^I have open HomePage$")
	public void i_have_open_homePage() throws Throwable {
		page = Browser.getHomePage("");
		page.open();
	}

	@When("^I search item \"([^\"]*)\"$")
	public void i_search_item_something(String itemToSearch) throws Throwable {
		page.getSearch().sendKeys(itemToSearch);
		page.getSearchButton().click();
	}

	@When("^I open the item \"([^\"]*)\"$")
	public void i_open_the_something_item(int itemNumber) throws Throwable {
		itemPage = page.itemList.getItemList().get(itemNumber-1).open(ItemPage.class);
	}

	@When("^I add \"([^\"]*)\" in quantity$")
	public void i_add_something_in_quantity(String quantity) throws Throwable {
		
		qty = quantity;
		if (itemPage.elementExist()) {
			itemPage.setSizeDropdown("2");
		}
		
		itemPage.setQtyDropdownByIndex(qty);
	}

	@When("^I open the cart$")
	public void i_open_the_cart() throws Throwable {
		itemPage.addToCart();
		cartPage = page.menu.getMenuList().get(3).open(CartPage.class);
		obtainedPrice = cartPage.getPrice();
		obtainedQty = cartPage.getQty();
		obtainedTotal = cartPage.getTotal();
	}

	@When("^I change quantity in cart to \"([^\"]*)\"$")
	public void i_change_quantity_in_cart_to_something(String quantity) throws Throwable {
		qty = quantity;
		cartPage.setQtyDropdownByIndex("2");
		obtainedPrice = cartPage.getPrice();
		obtainedQty = cartPage.getQty();
		obtainedTotal = cartPage.getTotal();
	}

	@Then("^Verify price and quantity$")
	public void verify_price_and_quantity() throws Throwable {

		float calculatedTotal = Float.parseFloat(obtainedPrice) * Float.parseFloat(obtainedQty);
		assertEquals(calculatedTotal, Float.parseFloat(obtainedTotal));
		assertEquals(obtainedQty, qty);
		cartPage.quit();
	}
}