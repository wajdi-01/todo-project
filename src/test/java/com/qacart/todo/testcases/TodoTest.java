package com.qacart.todo.testcases;


import com.qacart.todo.base.BaseTest;

import com.qacart.todo.models.User;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TodoTest extends BaseTest {
    @Test(description = "should Be Able To Add Todo")
    public void shouldBeAbleToAddTodo() {

        User user = new User();

        RegisterPage.getInstance().load(driver.get());
        //RegisterPage.getInstance().register(driver, user);
        RegisterPage.getInstance().registerUsingApi(driver.get(), user); // using Api
        TodoPage.getInstance().clickOnPlusButton(driver.get());
        NewTodoPage.getInstance().addTodo(driver.get(), "Learn Selenium");
        String text = TodoPage.getInstance().getTodoText(driver.get());
        Assert.assertEquals(text, "Learn Selenium");



    }
    @Test(description = "should Be Able To Delete A Todo")
        public void shouldBeAbleToDeleteATodo() {

        User user = new User();

        RegisterPage.getInstance().load(driver.get()); // .get: test parallel
        //RegisterPage.getInstance().register(driver, user);
        RegisterPage.getInstance().registerUsingApi(driver.get(), user); //using Api
        TodoPage.getInstance().clickOnPlusButton(driver.get()); // to test with access token api
        NewTodoPage.getInstance().addTodo(driver.get(), "Learn Selenium");
        //NewTodoPage.getInstance().addTodoUsingApi(user, "Learn Selenium");
        //RegisterPage.getInstance().load(driver); // to test with access token api
        //RegisterPage.getInstance().load(driver); // to test with access token api refresh page
        TodoPage.getInstance().deleteTodo(driver.get());
        boolean isNotTodosDisplayed = TodoPage.getInstance().isNotTodosDisplayed(driver.get());
        Assert.assertTrue(isNotTodosDisplayed);

        }
/////
}
