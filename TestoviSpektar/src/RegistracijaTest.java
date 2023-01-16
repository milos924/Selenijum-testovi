

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
public class RegistracijaTest {
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
	
  Logger l = Logger.getLogger(RegistracijaTest.class.getName());
	
  String output = "";
  String testName = "";
  String testDesc = "";
  boolean testPassed = false;
  @Test
  public void RegistracijaTest() throws Exception {
	testName = name.getMethodName();
	testDesc = "Testiranje registracije";
	
	driver.get("https://spektar.rs/");
    driver.manage().window().setSize(new Dimension(1696, 1026));
    Thread.sleep(2000);
    driver.findElement(By.linkText("Prijavi se")).click();
    driver.findElement(By.linkText("Registruj se")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("miloskovacevic8899@gmail.com");
    driver.findElement(By.cssSelector(".button > span")).click();
    assertEquals("Proverite svoj email, i zavr�ite proces registracije.", driver.findElement(By.cssSelector(".alert > p")).getText());;
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