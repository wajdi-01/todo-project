package com.qacart.todo.pages;

import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage {
    private static TodoPage todoPage;

    // Elements
    private final By welcomeMessage = By.cssSelector("[data-testid=\"welcome\"]");
    private final By plusButton =By.cssSelector("[data-testid=\"add\"]");
    private final By todoItem = By.cssSelector("[data-testid=\"todo-item\"]");
    private final By deleteIcone = By.cssSelector("[data-testid=\"delete\"]");
    private final By noTodosMessage = By.cssSelector("[data-testid=\"no-todos\"]");

    // Constructor
    private  TodoPage(){}
    public static TodoPage getInstance(){
        if (todoPage == null) {
            todoPage = new TodoPage();
        }
        return todoPage;

    }
    // Methods, steps

    @Step("Visiting the todo page")
    public void load(WebDriver driver) {driver.get(ConfigUtils.getInstance().getBaseUrl() +"/todo");}

    @Step("Check if the welcome message is displayed")

    public boolean isWelcomeMessageDisplayed(WebDriver driver) {
       return driver.findElement(welcomeMessage).isDisplayed();
    }

    @Step("Click on the plus button")
    public void clickOnPlusButton(WebDriver driver) {
        driver.findElement(plusButton).click();

    }
    @Step("Get the text of the todo")
    public String getTodoText(WebDriver driver) {
        return driver.findElement(todoItem).getText();
    }
    @Step("Click on the delete icon")
    public void deleteTodo(WebDriver driver) {
        driver.findElement(deleteIcone).click();
    }
    @Step("Check if no todos message is displayed ")
    public boolean isNotTodosDisplayed(WebDriver driver) {
        return driver.findElement(noTodosMessage).isDisplayed();
    }
}
