import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;

    @BeforeMethod // to run before any TC
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gehad\\IdeaProjects\\Framework1\\src\\main\\resources\\chromedriver.exe");

        // this 2 lines solve the problem of the last update of chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://classic.crmpro.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Login First
        WebElement userNameButton = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        userNameButton.sendKeys("gehadkassem9");
        password.sendKeys("Test123");
        loginButton.click();
    }

    @Test (priority = 1)
    public void clickOnContacts() {
        // Click on the Contacts
        driver.switchTo().frame("mainpanel");
        WebElement contactsButton = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
        contactsButton.click();

        // Verify that the Contacts page is displayed
        String actualResult = driver.getTitle();
        String expectedResult = "CRMPRO";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 2)
    public void clickOnDeals() {
        // Click on the Deals button
        driver.switchTo().frame("mainpanel");
        WebElement dealsButton = driver.findElement(By.xpath("//a[@title='Deals']"));
        dealsButton.click();

        // Verify that the Deals page is displayed
        String actualTitle = driver.getTitle();
        String expectedTitle = "CRMPRO";
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test (priority = 3)
    public void clickOnTasks() {
        // Click on the Tasks button
        driver.switchTo().frame("mainpanel");
        WebElement tasksButton = driver.findElement(By.xpath("//a[contains(text(), 'Tasks')]"));
        tasksButton.click();

        // Verify that the Tasks page is displayed
        String actualTitle = driver.getTitle();
        String expectedTitle = "CRMPRO";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}