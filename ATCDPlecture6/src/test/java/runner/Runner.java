package runner;

import java.util.ArrayList;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import listeners.Listener;
import logger.BasicLogger;
import logger.HTMLLogger;
import logger.Logger;

public class Runner {

	public static void main(String[] args) {

		TestNG testNG = new TestNG();
		testNG.addListener(new TestListenerAdapter());
		testNG.addListener(new Listener());

		BasicLogger logger = new BasicLogger();
		Logger htmlLogger = new HTMLLogger(new BasicLogger());
		logger.log("Basic Logger log");
		htmlLogger.log("HTML Logging");

		final XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Test suite");
		ArrayList<String> suiteFiles = new ArrayList<String>();
		suiteFiles.add("./src/test/resources/testSuite.xml");
		xmlSuite.setSuiteFiles(suiteFiles);

		ArrayList<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(xmlSuite);
		testNG.setXmlSuites(suites);

		testNG.run();
	}
}
