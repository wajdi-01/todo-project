package com.qacart.todo.testcases;


import com.qacart.todo.base.BaseTest;

import com.qacart.todo.models.User;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;



public class UserTest extends BaseTest {
    @Test(description = "should Be Able To Register To The Application") //for the report
    public void shouldBeAbleToRegisterToTheApplication() {

        User user = new User();

        RegisterPage.getInstance().load(driver.get()); // .get: parallel
        RegisterPage.getInstance().register(driver.get(), user);
        boolean isWelcomeDisplayed = TodoPage.getInstance().isWelcomeMessageDisplayed(driver.get());
        Assert.assertTrue(isWelcomeDisplayed);


    }
}
