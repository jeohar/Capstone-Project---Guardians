package tek.sdet.framework.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//select[@id='search']")
	public WebElement search;
	
	@FindBy(id="searchInput")
	public WebElement searchInput;
	
	@FindBy(id="searchBtn")
	public WebElement searchBttn;
	
	@FindBy(xpath="//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement theItem;
	
	@FindBy(xpath="//select[starts-with(@class,'product')]")
	public WebElement itemQty;
	
	@FindBy(id="addToCartBtn")
	public WebElement addToCartBttn;

	@FindBy(xpath="//span[@id='cartQuantity']")
	public WebElement numberOfItemsOnCart;
	
	@FindBy(xpath = "//p[text() ='Cart ']")
	public WebElement cart;
	
	@FindBy(xpath = "//span[text()='Delete']")
	public List<WebElement> emptycart;
	
	@FindBy(xpath="//select[@id='search']")
	public WebElement searchElectronics;
	
	@FindBy(id="searchInput")
	public WebElement searchInputElectronics;
	
	@FindBy(id="searchBtn")
	public WebElement searchBttnElectronics;
	
	@FindBy(xpath="//img[@alt='Apex Legends - 1,000 Apex Coins']")
	public WebElement apexSearchElectronics;
	
	@FindBy(xpath="//select[@class='product__select']")
	public WebElement qtySelectApex;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	public WebElement addToCartBttnApex;
	
	@FindBy(id="cartBtn")
	public WebElement cartBttnApex;
	
	@FindBy(id="proceedBtn")
	public WebElement proceedBttn;
	
	@FindBy(id="placeOrderBtn")
	public WebElement placeOrderBttn;
	
	@FindBy(xpath="//p[text()='Order Placed, Thanks']")
	public WebElement orderPlacedMssg;
	
	@FindBy(id = "orderLink")
	public WebElement orderbttn;
	
	@FindBy(xpath="(//p[text()='Show Details'])[1]")
	public WebElement firstOrder;
	
	@FindBy(id = "cancelBtn")
	public WebElement cancelBtn;
	
		
	@FindBy(id="reasonInput")
	public WebElement cancelReason;
	
	@FindBy(xpath ="//button[@id='orderSubmitBtn']")
	public WebElement cancelBttn;
	
	@FindBy(xpath="//p[text()='Your Order Has Been Cancelled']")
	public WebElement cancelMssg;
	
	@FindBy(id = "orderLink")
	public WebElement returnOrderBttn;
	
	@FindBy(xpath = "(//p[text()='Show Details'])[1]")
	public WebElement returnFirstOrder;
	
	@FindBy(xpath ="(//button[@id='returnBtn'])[1]")
	public WebElement returnBttn;
	
	//@FindBy(xpath = "//select[@id='reasonInput']//child::option[3]")
	@FindBy(id ="reasonInput")
	public WebElement returnReason;
	
	//@FindBy(xpath = "//select[@id='dropOffInput']//child::option[3]")
	//@FindBy(xpath = "//option[text()='FedEx']")
	@FindBy(xpath="//div//div[@class='order__cancel-input-wrapper']//select[@id='dropOffInput']")
	public WebElement fedEx;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement orderSubmitBtn;
	
	@FindBy(linkText="Orders")
	public WebElement ordersReview;
	
	@FindBy(xpath="(//p[text()='Show Details'])[1]")
	public WebElement firstOrderReview;
	
	@FindBy(xpath="//button[text()='Review']")
	public WebElement reviewBttn;
	
	@FindBy(id="headlineInput")
	public WebElement headLineInput;
	
	@FindBy(id="descriptionInput")
	public WebElement descriptionInput;
	
	@FindBy(id="reviewSubmitBtn")
	public WebElement reviewSubmitBttn;
	
	@FindBy(xpath="//div[text()='Your review was added successfully']")
	public WebElement reviewSubmitMssg;
	
	@FindBy(xpath="//img[@alt='Amazon Fire TV ']")
	public WebElement AmazonFireTV;
	}
	
	
	
	


