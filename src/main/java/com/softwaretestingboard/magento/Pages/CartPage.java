package com.softwaretestingboard.magento.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.utils.utils;

public class CartPage extends BaseClass{
	
	
	public CartPage(){
		PageFactory.initElements(driver, this);;
	}
	
	WomenPage wp;
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[1]")
	private WebElement editInCart;
	
	@FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[2]")
	private WebElement removeFromCart;
	
	@FindBy(id="qty")
	private WebElement quantity;
	
	@FindBy(id="product-updatecart-button")
	private WebElement updateBtn;
	
	@FindBy(xpath="//input[@id='qty']")
	private WebElement OliviaQuantity;
	
	@FindBy(id="option-label-size-143-item-166")
	private WebElement size;
	
	@FindBy(id ="option-label-color-93-item-49")
	private WebElement color;
	
	@FindBy(xpath = "//*[text()='Olivia 1/4 Zip Light Jacket was updated in your shopping cart.']")
	private WebElement updatedtxtmsgincart;
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[2]")
	private WebElement RemoveProdFromCart;
	
	@FindBy(xpath="//p[text()='You have no items in your shopping cart.']")
	private WebElement EmptyCartMsg;
	
	
	
	public void EditAddedProductinCart() {
		wp = new WomenPage();
		wp.AddproductTOCartFromWomenDropdown();
		wp.VerifyAddedProdInCart();
		editInCart.click();
		utils.waitForClickableElement(driver, size, Duration.ofSeconds(3));
		size.click();
		utils.waitForClickableElement(driver, color, Duration.ofSeconds(3));
		color.click();
		quantity.clear();
		quantity.sendKeys("4");
		
		updateBtn.click();
		String updatedQuantity  = OliviaQuantity.getAttribute("value");
		Assert.assertEquals(updatedQuantity, "4");
		Assert.assertTrue(updatedtxtmsgincart.isDisplayed());
		
	}
	
	public void RemoveAddedProductFromCart() {
		wp = new WomenPage();
		wp.AddproductTOCartFromWomenDropdown();
		wp.VerifyAddedProdInCart();
		RemoveProdFromCart.click();
		Assert.assertTrue(EmptyCartMsg.isDisplayed());
		
	}
	
}