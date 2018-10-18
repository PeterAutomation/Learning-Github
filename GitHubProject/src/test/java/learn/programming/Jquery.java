package learn.programming;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.CSS;

import org.omg.PortableInterceptor.SUCCESSFUL;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.bytebuddy.description.field.FieldDescription;

public class Jquery {
	
	public WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome browser started ...");
		driver.manage().window().maximize(); // Maximize the browser window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
	}
	@AfterMethod
	 public void brakedown() throws Exception {
		Thread.sleep(10);
		driver.close();
		
	}

	  @Test(priority =1)
	  
	public void jqueryInteractions() throws InterruptedException {
		Actions action = new Actions(driver);

		/// Go to the website
		driver.get("https://jqueryui.com/draggable/");

		// Drag and drop
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		Thread.sleep(1000);
		WebElement draggable = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		action.dragAndDropBy(draggable, 20, 100).build().perform();
		Thread.sleep(1000);
		
		// Droppable
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(1000);

		// Resizable
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		WebElement resizeable = driver.findElement(By.cssSelector("div.ui-resizable-handle:nth-child(4)"));
		action.clickAndHold(resizeable).moveByOffset(-100, -140).release().build().perform();
		Thread.sleep(1000);

		// Selectable
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		Thread.sleep(1000);

		WebElement selectableEle = driver.findElement(By.id("selectable"));

		List<WebElement> li = selectableEle.findElements(By.tagName("li"));
		WebElement eachLiEle = li.get(2);
		action.clickAndHold(eachLiEle).moveByOffset(0, 160).release().build().perform();
		Thread.sleep(500);

		/*List<WebElement> li = selectableEle.findElements(By.tagName("li"));
		for (WebElement eachLiEle : li) {
			eachLiEle.click();
		}*/

		// Sortable
		driver.get("https://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		Thread.sleep(1000);

		WebElement sortable = driver.findElement(By.id("sortable"));
		List<WebElement> lis = sortable.findElements(By.tagName("li"));
		WebElement itemMove = lis.get(0);

		action.clickAndHold(itemMove).moveByOffset(0, 210).release().build().perform();
		Thread.sleep(5000);

	}
	  @Test(priority=2)
	  
	  public void JqueryWidgets() throws Exception {
		  Actions action = new Actions(driver);
		  //Accordion
		  driver.get("https://jqueryui.com/accordion/");
		  driver.switchTo().frame(0);
		  Thread.sleep(1000);
		  
		  WebElement accodion = driver.findElement(By.id("accordion"));
		  
		  List<WebElement> h3s= accodion.findElements(By.tagName("h3"));
		  
		   for(WebElement eachH3s:h3s) {
			  String eachH3sP = eachH3s.getText();
			 // System.out.println(eachH3sP); 
		   }
		   WebElement clickSections =h3s.get(3);
		   clickSections.click();
		   Thread.sleep(5000);
		  
		   //Autocomplete
		   driver.get("https://jqueryui.com/autocomplete/");
		   driver.switchTo().frame(0);
		   Thread.sleep(1000);
		   WebElement tag = driver.findElement(By.id("tags"));
		   tag.click();
		   tag.sendKeys("ja");
		   Thread.sleep(2000);
		   List<WebElement> dropdownSuggest= driver.findElements(By.id("ui-id-1"));
		   dropdownSuggest.get(0).click();
		   Thread.sleep(3000);
		   
//		   WebElement tags = driver.findElement(By.className("ui-helper-hidden-accessible"));
//		   List<WebElement> listOfTags= tags.findElements(By.tagName("div"));
//		   
//		   for(WebElement allTags:listOfTags) {
//			   String allTagsName=allTags.getText();
//			   System.out.println(allTagsName);
//		   }
		               
			//Button
		    driver.get("https://jqueryui.com/button/");
		    driver.switchTo().frame(0);
		    Thread.sleep(1000);
		    
		    WebElement body=driver.findElement(By.tagName("body"));
		    WebElement div=body.findElement(By.tagName("div"));
		    WebElement AButtonEle=div.findElement(By.tagName("button"));
		    AButtonEle.click();
		    Thread.sleep(1000);
		    WebElement SubmitButton =div.findElement(By.tagName("input"));
		    SubmitButton.click();
		    Thread.sleep(1000);
		    WebElement Anchor =div.findElement(By.tagName("a"));
		    Anchor.click();
		    Thread.sleep(1000);
		    WebElement CSSbutton=driver.findElement(By.cssSelector("button.ui-button:nth-child(3)"));
		    CSSbutton.click();
		    Thread.sleep(1000);
		    WebElement CSSsumit= driver.findElement(By.cssSelector("input.ui-button:nth-child(4)"));
		    CSSsumit.click();
		    Thread.sleep(1000);
		    WebElement CSSAnchor=driver.findElement(By.cssSelector("a.ui-button:nth-child(5)"));
		    CSSAnchor.click();
		    Thread.sleep(1000);
		    
		    
		    // CheckBoxRadio
		    driver.get("https://jqueryui.com/checkboxradio/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		    WebElement body1= driver.findElement(By.tagName("body"));
		    WebElement div1=body1.findElement(By.tagName("div"));
		    WebElement fieldset=div1.findElement(By.tagName("fieldset"));
		    WebElement label=fieldset.findElement(By.tagName("label"));
		    label.click();
		    Thread.sleep(3000);
		    
		    WebElement star3=driver.findElement(By.cssSelector("body > div > fieldset:nth-child(5) > label:nth-child(4)"));
		    star3.click();
		    Thread.sleep(2000);
		   
//		    Actions rightClick = new Actions(driver);
//		    rightClick.contextClick(star3).build().perform();
//		    Thread.sleep(5000);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,1000)");
		    Thread.sleep(1000);
		    WebElement queen2 = driver.findElement(By.cssSelector("body > div > fieldset:nth-child(7) > label:nth-child(3)"));
		    queen2.click();
		    Thread.sleep(1000);

		 
		  
		   // ControlGroup
		  driver.get("https://jqueryui.com/controlgroup/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		  
		    WebElement carDropDownBtn = driver.findElement(By.cssSelector("#car-type-button"));
		    carDropDownBtn.click();
		    Thread.sleep(1000);
		    
		    WebElement dropDownMenu = driver.findElement(By.cssSelector("#car-type-menu"));
		    List<WebElement> eachCar = dropDownMenu.findElements(By.tagName("div"));
		    for (WebElement everyElem: eachCar ) {
		    	
		    	if (everyElem.getText().contains("SUV")) {
		    		Thread.sleep(1000);
		    		everyElem.click();
		    	}
		    }
		    Thread.sleep(1000);
		  
		   WebElement div2 = driver.findElement(By.cssSelector("body > div.widget > fieldset:nth-child(2) > div"));
		   List<WebElement> eachTrasmission =div2.findElements(By.tagName("label"));
		   for(WebElement eachEle: eachTrasmission) {
			   //System.out.println(eachEle.getText());
			   if(eachEle.getText().contains("Automatic")) {
				   eachEle.click();
				   
			   }
			   
			  
			   Thread.sleep(1000);
		   }
		  
		    WebElement insurance = driver.findElement(By.cssSelector("body > div.widget > fieldset:nth-child(2) > div > label:nth-child(7)"));
		    insurance.click();
		    Thread.sleep(1000);
		    
		    WebElement carNumber = driver.findElement(By.id("horizontal-spinner"));
		    carNumber.clear();
		    carNumber.sendKeys("1");
		    Thread.sleep(1000);
		    
		    WebElement bookComplete=driver.findElement(By.cssSelector(".ui-widget.ui-controlgroup-item.ui-button.ui-corner-right"));
		    bookComplete.click();
		    Thread.sleep(2000);
		    
		 
		  
		    //Datepicker
		    
		    driver.get("https://jqueryui.com/datepicker/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		    
		    WebElement datepicker=driver.findElement(By.id("datepicker"));
		    datepicker.click();
		    Thread.sleep(1000);
		    
		     WebElement date=driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody"));
		     List<WebElement> eachDate = date.findElements(By.tagName("a"));
		     for(WebElement eachDatePick: eachDate) {
		    	  //System.out.println(eachDatePick.getText());
		    	 if (eachDatePick.getText().contains("21")) {
		    		 eachDatePick.click();
		    	 }
		    	 Thread.sleep(1000);
		     }
		     
	
		   
		  //Dialog
		  
		  driver.get("https://jqueryui.com/dialog/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		    
		   WebElement clickX=driver.findElement(By.cssSelector(".ui-button-icon.ui-icon.ui-icon-closethick"));
		   clickX.click();
		   Thread.sleep(1000);
		    
			     
		  // Menu
		  driver.get("https://jqueryui.com/menu/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		    
		    WebElement hoverToMusic = driver.findElement(By.id("ui-id-9"));
		    action.moveToElement(hoverToMusic).build().perform();
		    Thread.sleep(500);
		    
		    WebElement hoverToJazz = driver.findElement(By.id("ui-id-13"));
		    action.moveToElement(hoverToJazz).build().perform();
		    Thread.sleep(500);
		    
		    WebElement bigBang =driver.findElement(By.id("ui-id-15"));
		    bigBang.click();
		    Thread.sleep(1000);
		  
		    
		  //ProgressBar
		  driver.get("https://jqueryui.com/progressbar/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		     
		   String print =driver.findElement(By.cssSelector(".ui-progressbar-value.ui-corner-left.ui-widget-header")).getAttribute("style");
		     System.out.println("Status"+print);
		     
		  
		   // SelectMenu
		  driver.get("https://jqueryui.com/selectmenu/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		    
		    WebElement clickDrop= driver.findElement(By.id("speed-button"));
		    clickDrop.click();
		    
		    WebElement ulSpeed=driver.findElement(By.id("speed-menu"));
		    List<WebElement> eachLi =ulSpeed.findElements(By.tagName("li"));
		    for(WebElement eachLiEle:eachLi) {
		    	//System.out.println(eachLiEle.getText());
		    	if(eachLiEle.getText().contains("Medium")) {
		    		eachLiEle.click();
		    	}
		    	Thread.sleep(2000);
		    }
		     
		    WebElement clickFile=driver.findElement(By.id("files-button"));
		    clickFile.click();
		    Thread.sleep(1000);
		    
		    WebElement listFile= driver.findElement(By.id("files-menu"));
		    List<WebElement> li=listFile.findElements(By.tagName("li"));
		    for(WebElement eachLis:li) {
		    	//System.out.println(eachLis.getText());
		       if(eachLis.getText().contains("ui.jQuery.js")) {
		    	   eachLis.click();
		       }
		       Thread.sleep(1000);
		    }
		    
		    
		    WebElement clickNumber = driver.findElement(By.id("number-button"));
		    clickNumber.click();
		    Thread.sleep(1000);
		    
		    WebElement numberMenu=driver.findElement(By.id("number-menu"));
		    List<WebElement> numberMenuLi = numberMenu.findElements(By.tagName("li"));
		     for(WebElement eachNumberLi: numberMenuLi) {
		    	 if(eachNumberLi.getText().contains("5")) {
		    		 eachNumberLi.click();
		    	 }
		    	 Thread.sleep(1000);
		     }
		     
		     WebElement salutationButton = driver.findElement(By.id("salutation-button"));
		     salutationButton.click();
		     WebElement salutationMenu = driver.findElement(By.id("salutation-menu"));
		     List<WebElement> salutationMenuLi= salutationMenu.findElements(By.tagName("li"));
		     for(WebElement eachSalutationLi: salutationMenuLi) {
		    	 if(eachSalutationLi.getText().contains("Mr.")) {
		    		 eachSalutationLi.click();
		    	 }
		    	 Thread.sleep(1000);
		     }
		      
		  
		  //Slider
		  
		  driver.get("https://jqueryui.com/slider/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		    
		    WebElement slider = driver.findElement(By.cssSelector(".ui-slider-handle.ui-corner-all.ui-state-default"));
		    action.dragAndDropBy(slider, 30, 0).build().perform();
		    Thread.sleep(2000);
		  
		
		  
		  //Spinner
		  
		  driver.get("https://jqueryui.com/spinner/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		  
		  WebElement spinner = driver.findElement(By.id("spinner"));
		  spinner.clear();
		  spinner.sendKeys("7");
		  Thread.sleep(500);
		  
		  driver.findElement(By.id("disable")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("destroy")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("getvalue")).click();
		  Thread.sleep(1000);
		  try {
		        WebDriverWait wait = new WebDriverWait(driver, 2);
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        alert.accept();
		    } catch (Exception e) {
		    	System.out.println("Error: " + e.getStackTrace());
		    }
		  
		  driver.findElement(By.id("setvalue")).click();
		  Thread.sleep(1000);
		  
		     
		  // Tabs
		  
		  driver.get("https://jqueryui.com/tabs/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		   
		    WebElement tabs =driver.findElement(By.cssSelector(".ui-tabs-nav.ui-corner-all.ui-helper-reset.ui-helper-clearfix.ui-widget-header"));
		    
		    List<WebElement> tabsList= tabs.findElements(By.tagName("li"));
		    for(WebElement tabsLists:tabsList) {
		    	if(tabsLists.getText().contains("Aenean lacinia")) {
		    		tabsLists.click();
		    	}
		    	else
		    	{
		    		System.out.println("Soryy, could not find the element");
		    	}
		    	Thread.sleep(1000);
		    }
		    
		  
		  //Tooltip
		  
		  driver.get("https://jqueryui.com/tooltip/");
		    driver.switchTo().frame(0);
		    Thread.sleep(2000);
		    
		    WebElement age = driver.findElement(By.id("age"));
		    action.moveToElement(age).build().perform();
		    Thread.sleep(1000);
		}
		  
		  
		  
	  }
	  

