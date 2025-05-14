Feature: Car valuation verification

  Scenario: Validate car registration values from input
    Given I load vehicle registration numbers from "car_input - V6.txt"
    When I fetch details for each registration from car-checking website
    Then I compare the results with expected output from "car_output - V6.txt"