package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;
/*
Create the package name computer
1. Create class “TestSuite”
Write the following Test:
1.Test name verifyProductArrangeInAlphaBaticalOrder()
1.1 Click on Computer Menu.
1.2 Click on Desktop
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.
2. Test name verifyProductAddedToShoppingCartSuccessFully()
2.1 Click on Computer Menu.
2.2 Click on Desktop
2.3 Select Sort By position "Name: A to Z"
2.4 Click on "Add To Cart"
2.5 Verify the Text "Build your own computer"
2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
2.7.Select "8GB [+$60.00]" using Select class.
2.8 Select HDD radio "400 GB [+$100.00]"
2.9 Select OS radio "Vista Premium [+$60.00]"
2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
[+$5.00]"
2.11 Verify the price "$1,475.00"
2.12 Click on "ADD TO CARD" Button.
2.13 Verify the Message "The product has been added to your shopping cart" on Top
green Bar
After that close the bar clicking on the cross button.
2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
2.15 Verify the message "Shopping cart"
2.16 Change the Qty to "2" and Click on "Update shopping cart"
2.17 Verify the Total"$2,950.00"
2.18 click on checkbox “I agree with the terms of service”
2.19 Click on “CHECKOUT”
2.20 Verify the Text “Welcome, Please Sign In!”
2.21Click on “CHECKOUT AS GUEST” Tab
2.22 Fill the all mandatory field
2.23 Click on “CONTINUE”
2.24 Click on Radio Button “Next Day Air($0.00)”
2.25 Click on “CONTINUE”
2.26 Select Radio Button “Credit Card”
2.27 Select “Master card” From Select credit card dropdown
2.28 Fill all the details
2.29 Click on “CONTINUE”
2.30 Verify “Payment Method” is “Credit Card”
2.32 Verify “Shipping Method” is “Next Day Air”
2.33 Verify Total is “$2,950.00”
2.34 Click on “CONFIRM”
2.35 Verify the Text “Thank You”
2.36 Verify the message “Your order has been successfully processed!”
2.37 Click on “CONTINUE”
2.37 Verify the text “Welcome to our store”
 */

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='block block-category-navigation']/descendant::a[2]"));

        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//option[normalize-space()='Name: Z to A']"));

        //1.4 Verify the Product will arrange in Descending order.
        String exceptedText = "Name: Z to A";
        String actualText = getTextFromElement(By.xpath("//option[normalize-space()='Name: Z to A']"));
        Assert.assertEquals("Name : z to A has not been arrange in descending order.", exceptedText, actualText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // * 2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='block block-category-navigation']/descendant::a[2]"));

        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//option[normalize-space()='Name: A to Z']"));
        Thread.sleep(2000);

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//a[text() = 'Build your own computer']"));

        // 2.5 Verify the Text "Build your own computer"
        String expectedText1 = "Build your own computer";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals(expectedText1, actualText1);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropDown(By.id("product_attribute_1"), "1");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByValueFromDropDown(By.id("product_attribute_2"), "5");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));

        //2.11 Verify the price "$1,475.00"
        String eprice = "$1,475.00";
        String aprice = getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]"));
        Assert.assertEquals(eprice, aprice);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMText2 = "The product has been added to your shopping cart";
        String actualText2 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMText2, actualText2);

        //close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.15 Verify the message "Shopping cart"
        String expectedMessage = "Shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedMessage, actualMessage);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//div[@class='quantity up']"));

        //2.17 Verify the Total"$2,950.00"
        String expectedMessage1 = "$2,950.00";
        String actualMessage1 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals(expectedMessage1, actualMessage1);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage2 = "Welcome, Please Sign In!";
        String actualMessage2 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedMessage2, actualMessage2);

        // 2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Abhishek");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Bachchan");
        sendTextToElement(By.id("BillingNewAddress_Email"), "abhishekbachchan@gmail50.com");
        sendTextToElement(By.id("BillingNewAddress_Company"), "Abhi1234");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "1");
        selectByValueFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "11");
        sendTextToElement(By.id("BillingNewAddress_City"), "Haveli");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "8900 154th Street");
        sendTextToElement(By.id("BillingNewAddress_Address2"), "jalsa,falcon");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "45678");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "900-466-7790");
        sendTextToElement(By.id("BillingNewAddress_FaxNumber"), "1234567");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.name("save"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//label[normalize-space()='Next Day Air ($0.00)']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "MasterCard");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mary John");
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        selectByValueFromDropDown(By.id("ExpireMonth"), "5");
        selectByValueFromDropDown(By.id("ExpireYear"), "2030");
        sendTextToElement(By.id("CardCode"), "5623");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card"
        String expectedText = "Payment Method: Credit Card";
        String actualText = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals(expectedText, actualText);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedText3 = "Shipping Method: Next Day Air";
        String actualText3 = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals(expectedText3, actualText3);

        //2.33 Verify Total is “$2,950.00”
        String expectedText4 = "$2,950.00";
        String actualText4 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals(expectedText4, actualText4);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank you”
        String expectedText5 = "Thank you";
        String actualText5 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedText5, actualText5);

        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedText6 = "Your order has been successfully processed!";
        String actualText6 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedText6, actualText6);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.38 Verify the text “Welcome to our store”
        String expectedText7 = "Welcome to our store";
        String actualText7 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedText7, actualText7);
    }


    @After
    public void tearDown() {

        closeBrowser();
    }
}