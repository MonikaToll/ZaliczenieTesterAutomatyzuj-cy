package zad4;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

public class AddAddress_TEST {


    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/Cucumber/Features/Google/", plugin = {"pretty", "html:out"})

    public class  AddAddress_TEST {
    }

}
