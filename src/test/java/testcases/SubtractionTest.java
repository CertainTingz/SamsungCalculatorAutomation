package testcases;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtractionTest extends BaseTest {

    String extractedSolution;


    @Test
    public void subtractionTest() {

        System.out.println("Subtraction Test");


        //clicking first number :4
        WebElement digit_4 = driver.findElement(AppiumBy.id(loc.getProperty("digit_4")));
        digit_4.click();


        //subtracting numbers :-
        WebElement minus = driver.findElement(AppiumBy.id(loc.getProperty("subtraction")));
        minus.click();


        //clicking first number :3
        WebElement digit_3 = driver.findElement(AppiumBy.id(loc.getProperty("digit_3")));
        digit_3.click();

        //clicking equal number :=
        WebElement equals = driver.findElement(AppiumBy.id(loc.getProperty("equals")));
        equals.click();


        // extracting solution
        WebElement solution = driver.findElement(AppiumBy.id(loc.getProperty("solution")));

        System.out.println("Solution extracted is:  " + solution.getText());
        extractedSolution = solution.getText().toString().replace(" Calculation result", "");
        System.out.println("This is the extracted text :  " + extractedSolution);



        //Verifying solution
        Assert.assertEquals(extractedSolution, "1");

        extent.createTest(getClass().getName()).log(Status.INFO, "Subtracting 3 from 4. Actual Solution is 1, calculated solution is " + extractedSolution);


    }

}
