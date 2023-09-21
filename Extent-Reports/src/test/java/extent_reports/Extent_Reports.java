package extent_reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//script to generate extent reports 
public class Extent_Reports {
	public static WebDriver driver;

	public static void main(String[] args) {

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReport.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test = extent.createTest("My Test Case", "This is a description of my test case");

		driver = new ChromeDriver();
		driver.get("https://google.com");
		test.pass("Navigated to the website");

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		test.pass("Navigated to the OrangeHRM home page");

		extent.flush();

		driver.close();

	}

}
