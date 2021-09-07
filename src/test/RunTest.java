package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomDesign.StackOverFlowPage;
import resource.Base;

public class RunTest extends Base {

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeBrowser();
		driver.get(seturl);
	}

	@Test
	public void getdata() {

		StackOverFlowPage sof = new StackOverFlowPage(driver);
		sof.menuClick().click();
		sof.questionClick().click();
		sof.tagClick().click();
		sof.newClick().click();
		sof.getMaxQuecount();
		sof.getTagName();

	}

	@AfterMethod
	public void finish() {
		driver.close();
	}

}
