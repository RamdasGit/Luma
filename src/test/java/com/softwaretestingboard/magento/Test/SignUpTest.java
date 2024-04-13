package com.softwaretestingboard.magento.Test;

import org.testng.annotations.Test;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.Pages.SignUpPage;

public class SignUpTest extends BaseClass {
	
	SignUpPage signup; 
	

	@Test
	public void SignUp() {
		signup = new SignUpPage();
		signup.signUp();
	}
	
	@Test
	public void signUpWithRegEmail() {
		signup = new SignUpPage();
		signup.signUpWithRegisteredEmail();
	}
}