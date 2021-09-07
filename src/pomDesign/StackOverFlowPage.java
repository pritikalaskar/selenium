package pomDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StackOverFlowPage {
	public WebDriver driver;
	ArrayList<String> numbers = new ArrayList<String>();

	public StackOverFlowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='ps-relative']")
	WebElement Menu;

	@FindBy(id = "nav-questions")
	WebElement Questions;

	@FindBy(id = "nav-tags")
	WebElement Tag;

	@FindBy(xpath = "//a[@data-value='new']")
	WebElement New;

	@FindBy(xpath = "//div[@class='mt-auto d-flex jc-space-between fs-caption fc-black-400']/div[1]")
	List<WebElement> questioncount;
	List<WebElement> c = questioncount;

	@FindBy(xpath = "//a[@class='post-tag']")
	List<WebElement> Tagname;

	public WebElement menuClick() {
		return Menu;
	}

	public WebElement questionClick() {
		return Questions;
	}

	public WebElement tagClick() {
		return Tag;
	}

	public WebElement newClick() {
		return New;
	}

	public void getMaxQuecount() {
		List<WebElement> c = questioncount;
		for (int i = 0; i < c.size(); i++) {
			String[] value = c.get(i).getText().split("q");
			numbers.addAll(Arrays.asList(value[0]));
		}
		System.out.println(numbers);
		System.out.println("Maximum number of questions=" + Collections.max(numbers));
	}

	public void getTagName() {
		List<WebElement> c = questioncount;
		List<WebElement> t = Tagname;
		for (int j = 0; j < t.size(); j++) {
			if (c.get(j).getText().contains(Collections.max(numbers))) {
				System.out.println("Tagname is = " + t.get(j).getText());
			}
		}
	}

}
