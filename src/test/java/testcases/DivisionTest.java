package testcases;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DivisionTest extends BaseTest {
    String extractedSolution;

    @Test
    public void divisionTest() {

        System.out.println("Division Test");

        //clicking first number :88
        WebElement digit_8 = driver.findElement(AppiumBy.id(loc.getProperty("digit_8")));
        digit_8.click();
        digit_8.click();

        //clicking first number :0
        WebElement digit_0 = driver.findElement(AppiumBy.id(loc.getProperty("digit_0")));
        digit_0.click();


        //Dividing numbers :-
        WebElement divided = driver.findElement(AppiumBy.id(loc.getProperty("division")));
        divided.click();


        //clicking first number :10
        WebElement digit_1 = driver.findElement(AppiumBy.id(loc.getProperty("digit_1")));
        digit_1.click();
        digit_0.click();


        //clicking equal number :=
        WebElement equals = driver.findElement(AppiumBy.id(loc.getProperty("equals")));
        equals.click();


        // extracting solution
        WebElement solution = driver.findElement(AppiumBy.id(loc.getProperty("solution")));

        System.out.println("Solution extracted is:  " + solution.getText().toString());
        extractedSolution = solution.getText().toString().replace(" Calculation result", "");
        extractedSolution.replace(" Calculation result","");


        //Verifying solution
        Assert.assertEquals(extractedSolution, "88");

        extent.createTest(getClass().getName()).log(Status.INFO, "Dividing 880 by 10. Actual Solution is 88, calculated solution is " + extractedSolution);


    }


}
