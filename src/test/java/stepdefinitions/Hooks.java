package stepdefinitions;

import io.cucumber.java.After;
import utils.Driver;

public class Hooks {

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
