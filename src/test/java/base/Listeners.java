package base;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenShots;

import java.io.IOException;

public class Listeners extends ScreenShots implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);


        extent.attachReporter(spark);
        try {
            extent.createTest(result.getName()).
                    log(Status.PASS, "This is a logging event for " + result.getName() + " and it passed!").
                    addScreenCaptureFromPath(getScreenshot("Passed_")+ ".png").assignAuthor("Lyndon Takudzwa Simango");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extent.flush();


    }


    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);

        extent.attachReporter(spark);
        try {
            Throwable e = result.getThrowable();
            extent.createTest(result.getName()).
                    log(Status.FAIL, "This is a logging event for " + result.getName() + " and it failed!").
                    addScreenCaptureFromPath(getScreenshot("Failed_") + ".png").assignAuthor("Lyndon Takudzwa Simango").info(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        extent.attachReporter(spark);

        try {
            Throwable e = result.getThrowable();
            extent.createTest(result.getName()).
                    log(Status.SKIP,"This is a logging event for "+result.getName()+" and it was skipped!").
                    addScreenCaptureFromPath(getScreenshot("Skipped_")+ ".png").assignAuthor("Lyndon Takudzwa Simango").info(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        extent.flush();


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);


        extent.attachReporter(spark);
        try {
            Throwable e = result.getThrowable();
            extent.createTest(result.getName()).
                    log(Status.FAIL,"This is a logging event for "+result.getName()+" and it failed!").
                    addScreenCaptureFromPath(getScreenshot("Failed_")+ ".png").assignAuthor("Lyndon Takudzwa Simango").info(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extent.flush();


    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);


    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}

