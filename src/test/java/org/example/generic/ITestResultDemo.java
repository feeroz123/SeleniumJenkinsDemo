package org.example.generic;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ITestResultDemo {

    @Test
    public void test1() {
        Assert.assertEquals(3, 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, 5);
    }

    @AfterMethod
    public void result(ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("FAILED : " + testResult.getName());
        }

        if (testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("PASSED this time : " + testResult.getName());
        }
    }

}
