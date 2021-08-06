package testeCalculadora;



import java.net.URL;




import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class StepDefinitions {
	
	WebDriver driver;

	@Before
	public void setUpBeforeClass() throws Exception {
		System.out.println("!!!          Inicio Teste       !!!");
		DesiredCapabilities capabilities = new DesiredCapabilities(); 
		capabilities.setCapability("deviceName", "C");	 
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "9");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.findElement(By.id("com.android.calculator2:id/del")).click();

	}

	@After
	public void tearDownAfterClass() throws Exception {
		driver.findElement(By.id("com.android.calculator2:id/clr")).click();
		System.out.println("!!!          Fim Teste       !!!");
		
	}
	
	@Given("somando {int} com {int}")
	public void somando_com(Integer int1, Integer int2) {
		driver.findElement(By.id("com.android.calculator2:id/digit_"+int1)).click();
		driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_"+int2)).click();	
	}

	
	@Given("subtraindo {int} com {int}")
	public void subtraindo_com(Integer int1, Integer int2) {
		driver.findElement(By.id("com.android.calculator2:id/digit_"+int1)).click();
		driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_"+int2)).click();	
	}
	
	@Given("multiplicando {int} com {int}")
	public void multiplicando_com(Integer int1, Integer int2) {
		driver.findElement(By.id("com.android.calculator2:id/digit_"+int1)).click();
		driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_"+int2)).click();	
	}
	
	@Given("dividindo {int} com {int}")
	public void dividindo_com(Integer int1, Integer int2) {
		driver.findElement(By.id("com.android.calculator2:id/digit_"+int1)).click();
		driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_"+int2)).click();	
	}


	@Then("resultado igual a {int}")
	public void resultado_igual_a(int int1) {
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		Assert.assertEquals(int1, Integer.parseInt(result));
	}

	
			
}
