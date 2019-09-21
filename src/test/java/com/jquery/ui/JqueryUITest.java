package com.jquery.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JqueryUITest {
	public WebDriver driver;

	@BeforeMethod
	public void eachMethodStart() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 0)
	public void StartChromeBrowser() throws InterruptedException {
		driver.get("https://jqueryui.com/");
		String WebTitle = driver.getTitle();
		System.out.println("This is the Web Title" + WebTitle);
		String WebSource = driver.getCurrentUrl();
		System.out.println("This is WebSourse URL" + WebSource);
		Assert.assertEquals(WebSource, "https://jqueryui.com/");
	}

	@Test(priority = 1)
	public void interactions() {
		try {
		driver.get("https://jqueryui.com/");
		WebElement draggablePage = driver.findElement(By.partialLinkText("Draggable"));
		draggablePage.click();
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		WebElement dragElem = driver.findElement(By.cssSelector("#draggable > p"));
		Thread.sleep(1000);
		// action.moveByOffset(200,200).contextClick().build().perform();//click mouse
		// right click button method.
		action.dragAndDropBy(dragElem, 330, 153).build().perform();

		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		WebElement drogElm = driver.findElement(By.id("draggable"));
		WebElement dropElem = driver.findElement(By.id("droppable"));
		action.dragAndDrop(drogElm, dropElem).build().perform();

		driver.get("http://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		WebElement resizableElem = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		action.clickAndHold(resizableElem).moveByOffset(200, 20).release().build().perform();

		driver.get("http://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		WebElement itemElem1 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[1]"));
		itemElem1.click();
		Thread.sleep(1000);
		WebElement itemElem2 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[2]"));
		itemElem2.click();
		Thread.sleep(1000);
		WebElement itemElem3 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[3]"));
		itemElem3.click();
		Thread.sleep(1000);
		WebElement itemElem4 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[4]"));
		itemElem4.click();
		Thread.sleep(1000);
		WebElement itemElem5 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[5]"));
		itemElem5.click();
		Thread.sleep(1000);
		WebElement itemElem6 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[6]"));
		itemElem6.click();
		Thread.sleep(1000);
		WebElement itemElem7 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[7]"));
		itemElem7.click();

		driver.get("http://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		WebElement sortableElem1 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[1]"));
		WebElement sortableElem2 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[2]"));
		WebElement sortableElem3 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[3]"));
		WebElement sortableElem4 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[4]"));
		WebElement sortableElem5 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[5]"));
		WebElement sortableElem6 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[6]"));
		WebElement sortableElem7 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[7]"));

		Thread.sleep(1000);
		action.clickAndHold().moveToElement(sortableElem1).clickAndHold().moveToElement(sortableElem2).build().perform();
		Thread.sleep(1000);
		action.clickAndHold().moveToElement(sortableElem2).clickAndHold().moveToElement(sortableElem3).build().perform();
		Thread.sleep(1000);
		action.clickAndHold().moveToElement(sortableElem3).clickAndHold().moveToElement(sortableElem4).build().perform();
		Thread.sleep(1000);
		action.clickAndHold().moveToElement(sortableElem4).clickAndHold().moveToElement(sortableElem5).build().perform();
		Thread.sleep(1000);
		action.clickAndHold().moveToElement(sortableElem5).clickAndHold().moveToElement(sortableElem6).build().perform();
		Thread.sleep(1000);
		action.clickAndHold().moveToElement(sortableElem6).clickAndHold().moveToElement(sortableElem7).build().perform();
		Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	@Test(priority = 2)
	public void widgets() throws Exception {

		driver.get("http://jqueryui.com/accordion/");
		driver.switchTo().frame(0);
		WebElement sectionElem1 = driver.findElement(By.cssSelector("#ui-id-1 > span"));
		sectionElem1.click();
		Thread.sleep(1000);
		WebElement sectionElem2 = driver.findElement(By.cssSelector("#ui-id-3 > span"));
		sectionElem2.click();
		Thread.sleep(1000);
		WebElement sectionElem3 = driver.findElement(By.cssSelector("#ui-id-5 > span"));
		sectionElem3.click();
		Thread.sleep(1000);
		WebElement sectionElem4 = driver.findElement(By.cssSelector("#ui-id-7 > span"));
		sectionElem4.click();

		driver.get("http://jqueryui.com/autocomplete/");
		driver.switchTo().frame(0);
		WebElement tagsElem = driver.findElement(By.id("tags"));
		tagsElem.sendKeys("ja");
		Thread.sleep(1000);
		tagsElem.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		tagsElem.sendKeys(Keys.ARROW_DOWN);
		tagsElem.click();

		driver.get("http://jqueryui.com/button/");
		driver.switchTo().frame(0);
		WebElement widgetSubmit = driver.findElement(By.cssSelector("body > div > input"));
		widgetSubmit.click();
		Thread.sleep(2000);
		WebElement widgetAnchor = driver.findElement(By.cssSelector("body > div > a"));
		widgetAnchor.click();
		Thread.sleep(2000);
		WebElement cssBtn = driver.findElement(By.cssSelector("body > button"));
		cssBtn.click();
		Thread.sleep(2000);
		WebElement cssSubmit = driver.findElement(By.cssSelector("body > input"));
		cssSubmit.click();

		driver.get("http://jqueryui.com/checkboxradio/");
		driver.switchTo().frame(0);
		WebElement radioBtn = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[3]/span[1]"));
		radioBtn.click();
		WebElement checkBox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[4]/span[1]"));
		checkBox.click();

		driver.get("http://jqueryui.com/controlgroup/");
		driver.switchTo().frame(0);
		WebElement compactElem = driver.findElement(By.id("car-type-button"));
		compactElem.click();
		compactElem.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		compactElem.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		WebElement luxuryElem = driver.findElement(By.id("ui-id-5"));
		luxuryElem.click();
		WebElement automaticElem = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[2]/span[2]"));
		automaticElem.click();
		WebElement insuranceElem = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[3]/span[1]"));
		insuranceElem.click();
		WebElement bookElem = driver.findElement(By.id("horizontal-spinner"));
		bookElem.sendKeys("2");
		Thread.sleep(3000);
		WebElement compactElem1 = driver.findElement(By.id("ui-id-8-button"));
		compactElem1.click();
		compactElem.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		compactElem1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);

		WebElement standardElem = driver
				.findElement(By.xpath("//span[@id='ui-id-8-button']/span[@class='ui-selectmenu-text']"));
		standardElem.click();
		WebElement automaticElem1 = driver.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/label[2]/span[1]"));
	 	automaticElem1.click();
		WebElement insuranceElem1 = driver.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/label[3]/span[1]"));
		insuranceElem1.click();
		WebElement bookElem1 = driver.findElement(By.id("vertical-spinner"));
		bookElem1.sendKeys("3");
		WebElement bookNowElem = driver.findElement(By.id("book"));
		bookNowElem.click();
		driver.switchTo().defaultContent();
		driver.navigate().back();

		WebElement datePickerElem = driver.findElement(By.partialLinkText("Datepicker"));
		datePickerElem.click();
		driver.switchTo().frame(0);
		WebElement dateElem = driver.findElement(By.id("datepicker"));
		dateElem.click();
		Thread.sleep(1000);
		WebElement nextElem = driver.findElement(By.partialLinkText("Next"));
		nextElem.click();
		Thread.sleep(1000);
		WebElement dateElem1 = driver.findElement(By.partialLinkText("19"));
		dateElem1.click();
		Thread.sleep(1000);

		driver.switchTo().defaultContent();
		driver.navigate().back();

		// Dialog
		driver.get("http://jqueryui.com/dialog/");
		WebElement dialogPage = driver.findElement(By.partialLinkText("Dialog"));
		dialogPage.click();
		driver.switchTo().frame(0);
		Actions act = new Actions(driver);

		WebElement basicDialogElem = driver.findElement(By.className("ui-dialog-title"));
		act.moveToElement(basicDialogElem).dragAndDropBy(basicDialogElem, 252, 109);
		WebElement dialogClose = driver
				.findElement(By.xpath("//span[@class='ui-button-icon ui-icon ui-icon-closethick']"));
		dialogClose.click();
		driver.switchTo().defaultContent();

		// Menu

		WebElement menuPageElem = driver.findElement(By.partialLinkText("Menu"));
		menuPageElem.click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("ui-id-2")).click();
		driver.findElement(By.id("ui-id-3")).click();
		Actions act1 = new Actions(driver);
		Thread.sleep(1000);
		WebElement electronicsElem = driver.findElement(By.id("ui-id-4"));
		WebElement UtilitiesElem = driver.findElement(By.id("ui-id-7"));
		Thread.sleep(2000);
		act1.moveToElement(electronicsElem).build().perform();
		UtilitiesElem.click();
		WebElement moviesElem = driver.findElement(By.id("ui-id-8"));
		moviesElem.click();
		WebElement musicElem = driver.findElement(By.id("ui-id-9"));
		WebElement rockElem = driver.findElement(By.id("ui-id-10"));
		WebElement classicElem = driver.findElement(By.id("ui-id-12"));
		act1.moveToElement(musicElem).build().perform();
		rockElem.click();
		act1.moveToElement(rockElem).build().perform();
		classicElem.click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// Progressbar
		driver.get("http://jqueryui.com/progressbar/#download");
		driver.switchTo().frame(0);
		WebElement startDownloadElem = driver.findElement(By.id("downloadButton"));
		startDownloadElem.click();
		Thread.sleep(7000);
		WebElement closeElem = driver.findElement(By.cssSelector(".ui-dialog-buttonset .ui-corner-all"));
		act1.moveToElement(closeElem).click().build().perform();
		driver.switchTo().defaultContent();
		driver.navigate().back();

		// Selectmenu
		WebElement selectMenuPage = driver.findElement(By.partialLinkText("Selectmenu"));
		selectMenuPage.click();
		driver.switchTo().frame(0);

		WebElement selectBtnElem = driver
				.findElement(By.xpath("//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']"));
		selectBtnElem.click();
		WebElement fastElem = driver.findElement(By.id("ui-id-4"));
		fastElem.click();

		WebElement SelectFileBtn = driver.findElement(By.xpath("//span[@id='files-button']/span[1]"));
		SelectFileBtn.click();
		WebElement uiJQElem = driver.findElement(By.id("ui-id-7"));
		uiJQElem.click();

		WebElement selectNunBtn = driver.findElement(By.xpath("//*[@id=\"number-button\"]/span[1]"));
		selectNunBtn.click();
		WebElement selectNunElem = driver.findElement(By.id("ui-id-13"));
		selectNunElem.click();

		WebElement selectTitleBtn = driver.findElement(By.xpath("//*[@id=\"salutation-button\"]/span[1]"));
		selectTitleBtn.click();
		WebElement selectTitleElem = driver.findElement(By.id("ui-id-31"));
		selectTitleElem.click();
		driver.switchTo().defaultContent();

		// Slider
		WebElement sliderPage = driver.findElement(By.partialLinkText("Slider"));
		sliderPage.click();
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		WebElement sliderElem = driver.findElement(By.id("slider"));
		action.clickAndHold(sliderElem).moveByOffset(30, 0).release(sliderElem).build().perform();
		driver.switchTo().defaultContent();

		// Spinner
		WebElement spinnerPage = driver.findElement(By.partialLinkText("Spinner"));
		spinnerPage.click();
		driver.switchTo().frame(0);

		WebElement selectvalueBtn = driver.findElement(By.id("spinner"));
		selectvalueBtn.sendKeys("4");
		Thread.sleep(1000);

		WebElement toggleElem = driver.findElement(By.id("destroy"));
		toggleElem.click();
		Thread.sleep(1000);

		WebElement setvalueElem = driver.findElement(By.id("setvalue"));
		setvalueElem.click();

		driver.switchTo().defaultContent();

		// Tabs
		WebElement TabsPage = driver.findElement(By.partialLinkText("Tabs"));
		TabsPage.click();
		driver.switchTo().frame(0);

		WebElement ProinElem = driver.findElement(By.id("ui-id-2"));
		ProinElem.click();
		Thread.sleep(1000);

		WebElement AeneanElem = driver.findElement(By.id("ui-id-3"));
		AeneanElem.click();
		Thread.sleep(1000);

		WebElement NuncElem = driver.findElement(By.id("ui-id-1"));
		NuncElem.click();

		driver.switchTo().defaultContent();

		// Tooltip
		WebElement TooltipPage = driver.findElement(By.partialLinkText("Tooltip"));
		TooltipPage.click();
		driver.switchTo().frame(0);
		Actions toolTipAct = new Actions(driver);

		WebElement toolTipsElem = driver.findElement(By.cssSelector("body > p:nth-child(1) > a"));
		toolTipAct.moveToElement(toolTipsElem).release().build().perform();
		Thread.sleep(1000);
		WebElement themeRollerElem = driver.findElement(By.cssSelector("body > p:nth-child(2) > a"));
		toolTipAct.moveToElement(themeRollerElem).release().build().perform();
		Thread.sleep(1000);

		WebElement egeElem = driver.findElement(By.id("age"));
		egeElem.sendKeys("38");

		driver.switchTo().defaultContent();
	}

	@AfterMethod
	public void afterMethod() {
		try {
			Thread.sleep(3000);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
