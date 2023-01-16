import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	RegistracijaTest.class,
	LogovanjeTest.class,
	ValidnostTest.class,
	DodavanjeUKorpuTest.class,
	JednakostKorpeTest.class,
	PerfomanceTest.class,
	FilterTest.class,
	PretrazivanjeTest.class,
	SortiranjeTest.class,
	TestRunner.class
})

public class TestSuite {

}