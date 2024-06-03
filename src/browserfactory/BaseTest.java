package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/*
Project-1 com-nopcommerce-sw-3
baseUrl: https://demo.nopcommerce.com/
Requirement:
Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’
inside the ‘browserfactory’ package. And write the browser setup code inside the class ‘Base
Test’.
Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
package. And write the all the utility methods in it’.
 */
public class BaseTest {

    static String browser = "Chrome";
    public static WebDriver driver;
    public void openBrowser(String baseUrl) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
        } else {
            System.out.println("wrong Browser name");
        }
        driver.get(baseUrl);//Open base URL
        driver.manage().window().maximize();//Window maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void closeBrowser(){
        driver.quit();
    }
}
