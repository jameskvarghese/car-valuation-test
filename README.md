# Car Valuation Test Automation Framework
This test automation suite validates UK car registration numbers by:
- Reading them from a plain text input file
- Querying a live car valuation website
- Comparing actual car details with expected output in a CSV file
- Reporting mismatches or missing data clearly

### Requirements for running this repository:

Make sure the following tools are installed:

- Java 17+
- Maven
- Selenium WebDriver
- Cucumber
- IntelliJ IDEA (recommended)

### How to Run Tests
### From Maven (CLI)
```
mvn clean test
```

### From IntelliJ

1. Open the project in IntelliJ IDEA
2. Right-click on TestRunner.java
3. Select Run 'TestRunner'

### Configuration
Edit the site URL or other environment configs in:

src/test/resources/config.properties

### Test Reports
target/cucumber-reports.html

