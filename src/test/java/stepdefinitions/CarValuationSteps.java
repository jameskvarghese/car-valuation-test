package stepdefinitions;

import io.cucumber.java.en.*;
import utils.InputReader;
import utils.OutputChecker;
import pages.CarValuationPage;

import java.util.List;
import java.util.Map;


public class CarValuationSteps {

    List<String> regNumbers;
    Map<String, Map<String, String>> expectedData;
    CarValuationPage page;

    @Given("I load vehicle registration numbers from {string}")
    public void i_load_vehicle_registration_numbers(String inputFile) {
        page = new CarValuationPage();
        regNumbers = InputReader.extractRegistrationNumbers("src/test/resources/testdata/" + inputFile);
    }

    @When("I fetch details for each registration from car-checking website")
    public void i_fetch_details_for_each_registration() {
        for (String reg : regNumbers) {
            page.searchCarDetails(reg);
        }
    }

    @Then("I compare the results with expected output from {string}")
    public void i_compare_results_with_expected_output(String outputFile) {
        expectedData = InputReader.loadExpectedOutput("src/test/resources/testdata/" + outputFile);
        OutputChecker.compareResults(expectedData);
    }
}