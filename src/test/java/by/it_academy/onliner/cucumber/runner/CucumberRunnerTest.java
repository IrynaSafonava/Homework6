package by.it_academy.onliner.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "by.it_academy.onliner.cucumber.steps",
        features = "C:\\Users\\Iryna\\IdeaProjects\\Homework6\\src\\test\\resources\\features"
)

public class CucumberRunnerTest {
    }
