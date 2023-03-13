import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {

    WebDriver driver;

    @BeforeMethod  // to run before any TC
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\gehad\\IdeaProjects\\Framework1\\src\\main\\resources\\chromedriver.exe");

        // this 2 lines solve the problem of the last update of chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://classic.crmpro.com/index.html");

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

//    @Test
//    public void titleTest() {
//
//        String expectedResults = "Free CRM  - CRM software for customer relationship management, sales, and support.";
//        String actualResult = driver.getTitle();
//        System.out.println(actualResult);
//        Assert.assertEquals(actualResult,expectedResults);
//
//    }
//
//    @Test
//    public void urlCheck() {
//        String expectedResults = "https://classic.freecrm.com/index.html";
//        String actualResult = driver.getCurrentUrl();
//        System.out.println(actualResult);
//        Assert.assertEquals(actualResult,expectedResults);
//    }

    @Test
    public void loginTest() {
        WebElement userNameButton = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        userNameButton.sendKeys("gehadkassem9");
        password.sendKeys("Test123");
        loginButton.click();

        String expectedResults = "CRMPRO";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResults);


    }
}

