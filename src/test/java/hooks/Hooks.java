package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverFactory;
import utils.ExtentManager;

import com.aventstack.extentreports.*;

public class Hooks {

    static ExtentReports extent = ExtentManager.getInstance();
    static ExtentTest test;

    @Before
    public void setup(io.cucumber.java.Scenario scenario) {
        test = extent.createTest(scenario.getName());
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {

        if (scenario.isFailed()) {
            test.fail("Test Failed: " + scenario.getName());
        } else {
            test.pass("Test Passed: " + scenario.getName());
        }

        DriverFactory.quitDriver();
        extent.flush();
    }
}
// 9f   1c67af66ff4d1f8973cdad20bf6718
// PS C:\Users\91866\Downloads>java- jar selenium-server-4.41.0.jar standalone