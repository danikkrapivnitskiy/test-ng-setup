import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listener implements IInvokedMethodListener {
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
       if (testResult.getStatus() == ITestResult.FAILURE && RunTestThroughXml.driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) RunTestThroughXml.driver).getScreenshotAs(OutputType.BYTES);
                String screenshotPath = "screenshots";
                File screenshotFile = new File(screenshotPath + "/" + testResult.getName() + ".png");
                FileUtils.writeByteArrayToFile(screenshotFile, screenshot);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}
