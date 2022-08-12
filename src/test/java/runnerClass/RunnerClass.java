
package runnerClass;  

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(

		//tags= "not @ViewAccount and not @AccountCreation",
		tags= "@ApiTesting",
		features = {"./src/test/resources/featureFiles"}, 
		glue = {"stepDefinition", "hooks"},

		monochrome = true,	dryRun= false)
public class RunnerClass extends AbstractTestNGCucumberTests {


}
