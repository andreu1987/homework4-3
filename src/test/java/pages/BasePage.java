package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.WaitTools;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait; //драйвер ожидания

    protected WaitTools waitTools;

    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitTools = new WaitTools(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    // метод = ждем когда появится элемент
    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }


    public void isElementDisplayed (By elementBy){
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    //Проверка элемента
    public void waitTools (By elementBy){
        Assertions.assertTrue(waitTools.waitForCondition(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(String.valueOf(elementBy)))));
        System.out.println("The element was not found");
    }



}
