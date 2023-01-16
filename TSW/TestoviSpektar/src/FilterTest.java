import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class FilterTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Rule
  public final TestName name = new TestName();
	
  Logger l = Logger.getLogger(FilterTest.class.getName());
	
  String output = "";
  String testName = "";
  String testDesc = "";
  boolean testPassed = false;
  
  @Test
  public void filterTest() throws InterruptedException {
	  
	  testName = name.getMethodName();
	  testDesc = "Testiranje filtera";
    
    driver.get("https://spektar.rs/");
    driver.manage().window().setSize(new Dimension(1696, 1026));
    driver.findElement(By.cssSelector(".hover .categories-submenu__list:nth-child(1) span")).click();
    driver.findElement(By.cssSelector(".filter-value > .hover")).click();
    driver.findElement(By.cssSelector(".hover > .iCheck-helper")).click();
    assertEquals(driver.findElement(By.cssSelector(".product-box:nth-child(4) .product-box__name")).getText(), is("Monitor Samsung LC24F390FHRXEN 24\\\"/VA,zakrivljen/1920x1080/60Hz/VGA,HDMI/Freesync/VESA/crna"));
    assertEquals(driver.findElement(By.cssSelector(".product-box:nth-child(12) .product-box__name")).getText(), is("Monitor SAMSUNG LF22T350FHRXDU 22\\\"/IPS/1920x1080/75Hz/5ms GtG/VGA,HDMI/Freesync/VESA"));
    assertEquals(driver.findElement(By.cssSelector(".product-box:nth-child(14) .product-box__name")).getText(), is("Monitor Samsung LF24T350FHUXEN 24\\\"/IPS/1920x1080/75Hz/5ms GtG/VGA,HDMI/Freesync/VESA"));
    driver.close();
  }
  @After
	public void WriteSingleTest() {
		output += "Testiranje metode " + testName;
		output += "\n\tNaziv testa: " + testName;
		output += "\n\tOpis testa: " + testDesc;
		output += "\n\tTest je uspesno prosao: " + testPassed + "\n";
		output += "\n";
		l.info(output);
		try {
			FileWriter fw = new FileWriter("test-report.txt", true);
			fw.write(output);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}