package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportWrapper {
	public static ExtentHtmlReporter extentreporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest, extentTestStep;

	public static void invokeReporter() {
		extentreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/Reports.html");
		extent.attachReporter(extentreporter);
	}

	public static void createExtentTest(String testName) {
		extentTest = extent.createTest(testName);
	}

	public static void createExtentTestStep(String testStepName) {
		extentTestStep = extentTest.createNode(testStepName);
	}

	public static void logExtentTestStep(Status status) {
		extentTestStep.log(status, "");
	}

	public static void flush() {
		extent.flush();
	}
}