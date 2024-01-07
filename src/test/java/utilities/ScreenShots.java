package utilities;

import base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;


public class ScreenShots extends BaseTest {

/* TODO
    -work no paths
    -work on emailing function */
    public String getScreenshot(String test_State) throws IOException {
        Date currentDate = new Date();
        String screenshotFileName = currentDate.toString().replace(" ", "_").replace(":", "_");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshotFileName = test_State + screenshotFileName;
        FileUtils.copyFile(screenshotFile, new File(".//src//test//resources//myreports//" + screenshotFileName + ".png"));
        return screenshotFileName;
    }


}
