package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PlayAround.HollywoodBet.testing.Base;

public class ExtentReport {
	public static ExtentHtmlReporter htmlReporter;
	private static ExtentReports reports;

	public static void createExtentReports() {
		htmlReporter = new ExtentHtmlReporter(foldername() + getFileName());
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("QA Automation");
		htmlReporter.config().setReportName("Way2Automation");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	}

	public static ExtentTest createTest(String testName) {
		return reports.createTest(testName);
	}

	public static void closeReport() {
		if (reports != null) {
			reports.flush();
		}
	}

	public static String foldername() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Base.foldername = Base.directory + "\\Report\\"
				+ format.format(date).toString().replace(":", "_").replace(" ", "").replace("-", "_");
		try {
			File file = new File(Base.foldername );
			file.mkdir();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return Base.foldername ;
	}

	public static String getFileName() {
		String reportname = "\\Report.html";
		return reportname;
	}

}
