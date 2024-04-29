package selenide.sitepage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Listeners({ SoftAsserts.class, ScreenshotListener.class})

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = Selenide.screenshot(OutputType.FILE);

        try {
            Allure.addAttachment(result.getMethod().getMethodName(), new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
