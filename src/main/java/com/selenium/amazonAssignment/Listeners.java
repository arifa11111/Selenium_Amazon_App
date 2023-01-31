package com.selenium.amazonAssignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

//ITestListener interface which implements Testng listeners
    public class Listeners implements ITestListener {


    @Override
        public void onTestStart(ITestResult result) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTestSuccess(ITestResult result) {
            // TODO Auto-generated method stub

            //	System.out.println("I successfully executed Listeners Pass code");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            // TODO Auto-generated method stub
            //screenshot code
            //response if API is failed
            System.out.println("********** "+result.getName()+" failed test for now its skipped. **********");
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStart(ITestContext context) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onFinish(ITestContext context) {
            // TODO Auto-generated method stub

        }

    }

