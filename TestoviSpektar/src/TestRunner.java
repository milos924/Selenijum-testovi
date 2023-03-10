import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.By;

public class TestRunner {

	public static void main(String[] args) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter("test-report2.txt", true));

		Result result = JUnitCore.runClasses();

		writer.newLine();
		result = JUnitCore.runClasses(RegistracijaTest.class);
		writer.append("SignUpTest - testiranje registracije korisnika - " + result.wasSuccessful());
		writer.newLine();

		result = JUnitCore.runClasses(LogovanjeTest.class);
		writer.append("LoginTest - testiranje logovanja korisnika - " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(ValidnostTest.class);
		writer.append("CheckValidationTest - testiranje korisnickih podataka nakon prijave - " + result.wasSuccessful());
		writer.newLine();

		result = JUnitCore.runClasses(DodavanjeUKorpuTest.class);
		writer.append("AddProductsTest - testiranje dodavanja 3 proizvoda u korpu - "	+ result.wasSuccessful());
		writer.newLine();

		result = JUnitCore.runClasses(JednakostKorpeTest.class);
		writer.append("EqualsValueTest - testiranje provere ukupne cene proizvoda - " + result.wasSuccessful());
		writer.newLine();

		result = JUnitCore.runClasses(PerfomanceTest.class);
		writer.append("PerformanceTest - testiranje performansi web prodavnice - " + result.wasSuccessful());
		writer.newLine();

		result = JUnitCore.runClasses(FilterTest.class);
		writer.append("FilterProductTest - testiranje dobijanje liste proizvoda na osnovu filtera - " + result.wasSuccessful());
		writer.newLine();

		result = JUnitCore.runClasses(PretrazivanjeTest.class);
		writer.append("SearchProductTest - testiranje pretrage proizvoda - " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(SortiranjeTest.class);
		writer.append("SortProductTest - testiranje pretrage proizvoda - " + result.wasSuccessful());
		writer.newLine();
		
		
		if (result.wasSuccessful()) {
			System.out.println("Svi testovi su uspesno prosli!");
		} else {
			System.out.println("Neki od testova nisu prosli!");
		}

		writer.close();
	}
}
	
