import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;

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
public class PerfomanceTest {
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
  public final TestName name = new TestName();

  Logger l = Logger.getLogger(PerfomanceTest.class.getName());
	
  String output = "";
  String testName = "";
  String testDesc = "";
  String testTime = "";
  boolean testPassed = false;
  
  static long vremeMS, prosekMS, vremeS, prosekS;
  
    static long START_TIME;
	static long END_TIME;
	static long TOTAL_TIME1, TOTAL_TIME2, TOTAL_TIME3, TOTAL_TIME4,TOTAL_TIME5;
    
    @Test
    public void Dostava() throws InterruptedException {
    	testName = name.getMethodName();
		testDesc = "Ucitavanje Dostava";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Dostava")).click();
	    assertThat(driver.findElement(By.cssSelector("h4:nth-child(1)")).getText(), is("Mi brinemo da put proizvoda do Vašeg doma bude ugodan, brz I bezbedan."));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME1 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME1 + "ms";

		testPassed = true;
	  }
    
    @Test
	  public void Prodavnice() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Ucitavanje Prodavnice";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    driver.findElement(By.linkText("Posao u Spektru")).click();
	    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Posao u Spektru"));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME2 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME2 + "ms";

		testPassed = true;
	  }
    
    @Test
	  public void OtvoriNalog() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Ucitavanje OtvoriNalog";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Reklamacije")).click();
	    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Reklamacije"));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME3 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME3 + "ms";

		testPassed = true;
	  }
    
    @Test
	  public void Korpa() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Ucitavanje Korpe";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Blog")).click();
	    assertThat(driver.findElement(By.cssSelector(".page")).getText(), is("E-Shop Blog\\\\nsearch\\\\nGorenje Spektar\\\\n21.08.2022.\\\\nfavorite8\\\\nDočekajte zimu spremni uz program na pelet\\\\n29.06.2022.\\\\nfavorite22\\\\nAparati za kafu – Dnevna doza kofeina svakog ljubitelja kafe\\\\nIzaberi svoj klima uređaj\\\\n06.06.2022.\\\\nfavorite25\\\\nProlećno čišćenje\\\\n09.05.2022.\\\\nfavorite10\\\\nMladenci\\\\n21.03.2022.\\\\nfavorite12\\\\nWebOS sistemi\\\\n03.02.2022.\\\\nfavorite18\\\\nOgrebi svoj popust.\\\\n01.07.2021.\\\\nfavorite16\\\\nProlećni vikend tehnike\\\\n20.05.2021.\\\\nfavorite7\\\\nKupovina u par klikova\\\\n16.03.2021.\\\\nfavorite8\\\\n2. rođendan Salona Tehnike - popust na sve\\\\n09.12.2020.\\\\nfavorite2\\\\nOgrebi popust!\\\\n10.07.2020.\\\\nfavorite21\\\\nVikend tehnike donosi popuste\\\\n13.05.2020.\\\\nfavorite8\\\\n1. rođendan Salona tehnike - svi ste pozvani\\\\n10.12.2019.\\\\nfavorite6\\\\nAlfa Plam daruje!\\\\n09.12.2019.\\\\nfavorite3\\\\nBlack Friday!!!\\\\n25.11.2019.\\\\\\\\nfavorite26\\\\\\\\nNoć Gorenje kupovine - popusti, ackije, žurka...\\\\\\\\n17.07.2019.\\\\\\\\nfavorite89\\\\\\\\nVelika julska VOX ponuda\\\\\\\\n15.07.2019.\\\\\\\\nfavorite24\\\\\\\\nG-Force usisivači - Nežni prema vama, nemilosrdni prema prašini\\\\\\\\n01.07.2019.\\\\\\\\nfavorite14\\\\\\\\nPRIKAŽI VIŠE"));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME4 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME4 + "ms";

		testPassed = true;
	  }
    @Test
	  public void Kontakt() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Ucitavanje OtvoriNalog";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Kontakt")).click();
	    assertThat(driver.findElement(By.cssSelector(".contact")).getText(), is("Prodavnice\\\\nIvanjica\\\\nSalon Tehnike Senjak\\\\nŠume bb\\\\ntel: 032 / 652 014\\\\nsenjak@spektar.rs\\\\nIvanjica\\\\nProdavnica br 1\\\\nUl. Boška Petrovića bb\\\\ntel: 032 / 663 647\\\\nmaloprodaja1@spektar.rs\\\\nIvanjica\\\\nProdavnica br 2\\\\nUl. Boška Petrovića 28\\\\ntel: 032 / 663 050\\\\nmaloprodaja2@spektar.rs\\\\nPožega\\\\nProdavnica br 3\\\\nUl. Knjaza Miloša 28\\\\ntel: 031 / 38 25 360\\\\npozega@spektar.rs\\\\nLučani\\\\nProdavnica br 4\\\\nUl. Jugoslovenske armije 6\\\\ntel: 032 / 819 528\\\\nlucani@spektar.rs\\\\nKeyboard shortcuts\\\\nMap data ©2022\\\\nTerms of Use"));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME3 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME5 + "ms";

		testPassed = true;
	  }
    
    @AfterClass
	public static void Kalkulacije() {
		System.out.println();
		long totalTestsTime = TOTAL_TIME1 + TOTAL_TIME2 + TOTAL_TIME3 + TOTAL_TIME4 + TOTAL_TIME5;
		System.out.println("Ukupno vreme otvaranja stranica i browsera [ms]: " + totalTestsTime + "ms");
		System.out.println("Proseèno vreme otvaranja stranica i browsera [ms]: " + totalTestsTime / 5 + "ms");
		System.out.println("Ukupno vreme otvaranja stranica i browsera [s]: " + totalTestsTime / 1000 + "s");
	}
    
    @After
	public void WriteSingleTest() {
 		output += "Testiranje metode " + testName;
		output += "\n\tNaziv testa: " + testName;
		output += "\n\tOpis testa: " + testDesc;
		output += "\n\tTest je uspesno prosao: " + testPassed + "\n";
		output += "\n\t" + testTime + "\n\n";
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
