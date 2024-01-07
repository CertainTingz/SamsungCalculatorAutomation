package testcases;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static freemarker.template.utility.StringUtil.replace;

public class AdditionTest extends BaseTest {
    String extractedSolution;

    @Test
    public void additionTest() {

        //clicking first number :1
        WebElement digit_1 = driver.findElement(AppiumBy.id(loc.getProperty("digit_1")));
        digit_1.click();


        //adding numbers :+
        WebElement plus = driver.findElement(AppiumBy.id(loc.getProperty("addition")));
        plus.click();


        //clicking first number :5
        WebElement digit_5 = driver.findElement(AppiumBy.id(loc.getProperty("digit_5")));
        digit_5.click();

        //adding numbers :+
        plus.click();

        //clicking first number :2
        WebElement digit_2 = driver.findElement(AppiumBy.id(loc.getProperty("digit_2")));
        digit_2.click();

        //clicking equal number :=
        WebElement equals = driver.findElement(AppiumBy.id(loc.getProperty("equals")));
        equals.click();


        // extracting solution
        WebElement solution = driver.findElement(AppiumBy.id(loc.getProperty("solution")));

        //System.out.println("Solution extracted is:  " + solution.getText().toString());
        extractedSolution = solution.getText().toString();
        extractedSolution= extractedSolution.replace(" Calculation result","");

        //Verifying solution
        Assert.assertEquals(extractedSolution, "8");
        extent.createTest(getClass().getName()).log(Status.INFO, "Adding 1+5+2. Actual Solution is 8, calculated solution is " + extractedSolution);

    }

}
