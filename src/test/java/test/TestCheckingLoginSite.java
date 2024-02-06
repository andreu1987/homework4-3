package test;

import factory.DriveFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainePageDuckduckgo;
import pages.MainePageOtus;
import pages.MainePageOtusHome;
import pages.TaskCheck;

public class TestCheckingLoginSite {

    private WebDriver driver;
    private MainePageDuckduckgo mainePageDuckduckgo;
    private TaskCheck taskOne;
    private MainePageOtusHome mainePageOtusHome;
    private MainePageOtus mainePageOtus;

    @BeforeAll
    public static void beforeALL() {
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new DriveFactory().create();
        mainePageDuckduckgo = PageFactory.initElements(driver, MainePageDuckduckgo.class);
        taskOne = PageFactory.initElements(driver, TaskCheck.class);
        mainePageOtusHome = PageFactory.initElements(driver, MainePageOtusHome.class);
        mainePageOtus = PageFactory.initElements(driver, MainePageOtus.class);
    }


    @org.junit.jupiter.api.Test
    public void test1() {
        mainePageDuckduckgo.goTo() // переход на сайт
                           .setInputText() // ввод слово
                           .clickElement();      // клик на поиск

        taskOne.checkPageIsCorrect(); // проверка элемента

    }

    @org.junit.jupiter.api.Test
    public void test2() {

        mainePageOtusHome.goTo() // переход на сайт
                         .fullscreen() // размер экрана
                         .getSize() // размер экрана
                         .clickElement() // клик по элементу
                         .elementLoadTimeout(); // ожидание элемента

        taskOne.checkPicture(); // проверка элемента


    }

    @org.junit.jupiter.api.Test
    public void test3() {

        mainePageOtus.goTo() // переход на сайт
                     .maximize() // размер экрана
                     .getSize() // размер экрана
                     .thereIsNotPopupElement()//Проверка что PopupElement нету, - "Войдите в свой акаунт"
                     .implicitlyWaitButton() // ожидания элемента кнопка "Войти"
                     .clickElementEnter() // клик по элементу кнопки "Войти"
                     .thereIsPopupElement() //Проверка что PopupElement есть - "Войдите в свой акаунт"
                     .authorizationEmail()  // ввод Email
                     .authorizationPassword()  // ввод Password
                     .clickElementEnterEnter()  // клик по элементу
                     .thereIsNoButton()//Проверка что нет кнопки "Войти"
                     .getCookies(); // вывод в лог куков
    }

    @AfterEach
    public void finish() {
        if (driver != null){
            try {
                driver.quit();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}


