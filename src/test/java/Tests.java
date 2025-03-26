import Helpers.FileHelper;
import Helpers.Entities.User;
import Helpers.EntityBuilder;
import Helpers.Pages.ChangePasswordPage;
import Helpers.Util;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Tests {
    public static WebDriver driver;
    public static final User user = EntityBuilder.GetUser();

    public static By checkout = By.id("checkout");
    public static By termsOfService = By.id("termsofservice");
    public static By successOrder = By.xpath("/descendant::div[contains(@class, 'order-completed')]/descendant::a[contains(@href, '/orderdetails/')]");
    public static ChromeOptions options;

    @BeforeAll
    public static void beforeAll() {
        options = new ChromeOptions();
        options.setCapability("browserVersion", "132");
//        options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://demowebshop.tricentis.com/");
        Util.createUser(user, driver);
        driver.quit();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://demowebshop.tricentis.com/");

        if(!FileHelper.filesForTestExist()){
            FileHelper.createFilesForTest();
        }
    }

    @AfterEach
    public void tearDown() {
        Util.logout(driver);
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"data1.txt"})
    public void test1(String filename){
        var startTime = System.nanoTime();

        Util.login(user, driver);
        Util.click(Util.bySection("digital-downloads"), driver);
        var itemsToAdd = FileHelper.getLinesFromFile(filename);

        for(var item : itemsToAdd){
            Util.addItemByNameToCart(item, driver);
        }

        Util.navigateToCart(driver);
        Util.click(termsOfService, driver);
        Util.click(checkout, driver);
        if(Util.isDisplayed(By.xpath("//div[@class = 'section new-billing-address']"), driver))
            Util.fillOutAddress(driver);
        Util.clickContinue("billing", driver);
        Util.clickContinue("payment_method", driver);
        Util.clickContinue("payment_info", driver);
        Util.clickContinue("confirm_order", driver);

        var endTime = System.nanoTime();
        System.out.println("End  " + (endTime - startTime));
    }

    @ParameterizedTest
    @ValueSource(strings = {"data2.txt"})
    public void test2(String filename){
        var startTime = System.nanoTime();

        Util.login(user, driver);
        Util.click(Util.bySection("digital-downloads"), driver);
        var itemsToAdd = FileHelper.getLinesFromFile(filename);

        for(var item : itemsToAdd){
            Util.addItemByNameToCart(item, driver);
        }

        Util.navigateToCart(driver);
        Util.click(termsOfService, driver);
        Util.click(checkout, driver);
        if(Util.isDisplayed(By.xpath("//div[@class = 'section new-billing-address']"), driver))
            Util.fillOutAddress(driver);
        Util.clickContinue("billing", driver);
        Util.clickContinue("payment_method", driver);
        Util.clickContinue("payment_info", driver);
        Util.clickContinue("confirm_order", driver);

        var endTime = System.nanoTime();
        System.out.println("End  " + (endTime - startTime));
    }

    @ParameterizedTest
    @ValueSource(strings = {"newPassword"})
    public void test3(String newPassword){
        var customerInfoBy = By.xpath("//a[@href='/customer/info'][ancestor::div[@class='header-links']]");
        var startTime = System.nanoTime();

        Util.login(user, driver);
        Util.click(customerInfoBy, driver);
        Util.click(By.xpath("//a[@href='/customer/changepassword']"), driver);

        var page = new ChangePasswordPage();
        page.changePassword(user.Password, newPassword, driver);
        Assertions.assertTrue(Util.isDisplayed(By.xpath("//div[@class='result']"), driver));
        Util.logout(driver);

        Util.login(user, driver);
        user.Password = newPassword;
        Util.login(user, driver);
        var endTime = System.nanoTime();
        System.out.println("End  " + (endTime - startTime));
    }

}
