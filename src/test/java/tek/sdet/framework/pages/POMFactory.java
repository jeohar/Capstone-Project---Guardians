package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class POMFactory extends BaseSetup{

	private RetailHomePage homePage;
	private SignInPage signInPage;
	private RetailAccountPage retailAccountPage;
	private RetailOrderPage retailOrderPage;
	
	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signInPage = new SignInPage();
		this.retailAccountPage = new RetailAccountPage();
		this.retailOrderPage = new RetailOrderPage();
		
	}
	public RetailHomePage homePage() {
		return this.homePage;
	}
	public SignInPage signInPage() {
		return this.signInPage;
	}
	
	public RetailAccountPage retailAccountPage() {
		return this.retailAccountPage;
	}
	public RetailOrderPage retailOrderPage() {
		return this.retailOrderPage;
	}
	
}

