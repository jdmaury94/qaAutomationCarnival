import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","json:target/report.json","de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"},features = "src/test/resources/features/SailsNavigation.feature",
        monochrome = true,junit = "--step-notifications")
public class RunnerClass {

}