
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\Users\thisi\OneDrive\Desktop\Java Selenium\Uiautomation\src\drivers\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://sathyabama.cognibot.in/login/index.php");
        String expectedTitle = "Sathyabama Learning Management System";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Application URL launched successfully");
        } else {
            System.out.println("Failed to launch the application URL");
        }
        WebElement collegeLogo = driver.findElement(By.xpath("//img[@alt='Sathyabama Institute of Science and Technology']"));
        if (collegeLogo.isDisplayed()) {
            System.out.println("College logo is present on the home page");
        } else {
            System.out.println("College logo is not present on the home page");
        }
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        if (loginLink.isDisplayed()) {
            System.out.println("Login link is available on the home page");
        } else {
            System.out.println("Login link is not available on the home page");
        }
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        usernameField.sendKeys("invalid_username");
        passwordField.sendKeys("invalid_password");
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        if (errorMessage.isDisplayed()) {
            System.out.println("User cannot login with invalid credentials");
        } else {
            System.out.println("Failed to validate invalid credentials");
        }
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("valid_username");
        passwordField.sendKeys("valid_password");
        loginButton.click();
        String expectedLoggedInUser = "Welcome, John"; 
        WebElement loggedInUser = driver.findElement(By.xpath("//span[@class='usertitle']"));
        String actualLoggedInUser = loggedInUser.getText();
        if (actualLoggedInUser.equals(expectedLoggedInUser)) {
            System.out.println("User is able to login with valid credentials");
        } else {
            System.out.println("Failed to login with valid credentials");
        }

        driver.quit();
    }
}