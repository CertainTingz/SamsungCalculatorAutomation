package testcases;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest extends BaseTest {
    String extractedSolution;

    @Test
    public void multiplicationTest() {

        System.out.println("Multiplication Test");

        //clicking first number :9
        WebElement digit_9 = driver.findElement(AppiumBy.id(loc.getProperty("digit_9")));
        digit_9.click();

        //clicking first number :6
        WebElement digit_6 = driver.findElement(AppiumBy.id(loc.getProperty("digit_6")));
        digit_6.click();


        //multiplying numbers :-
        WebElement times = driver.findElement(AppiumBy.id(loc.getProperty("multiplication")));
        times.click();


        //clicking first number :7
        WebElement digit_7 = driver.findElement(AppiumBy.id(loc.getProperty("digit_7")));
        digit_7.click();


        //clicking equal number :=
        WebElement equals = driver.findElement(AppiumBy.id(loc.getProperty("equals")));
        equals.click();


        // extracting solution

        WebElement solution = driver.findElement(AppiumBy.id(loc.getProperty("solution")));

        System.out.println("Solution extracted is:  "+ solution.getText().toString());
        extractedSolution = solution.getText().toString().replace(" Calculation result", "");


        //Verifying solution

        Assert.assertEquals(extractedSolution,"672");

        extent.createTest(getClass().getName()).log(Status.INFO, "Multiplying 96 by 7. Actual Solution is 672, calculated solution is "+extractedSolution);








    }




}
