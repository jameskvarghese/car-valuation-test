package utils;

import pages.CarValuationPage;
import java.util.*;

public class OutputChecker {

    public static void compareResults(Map<String, Map<String, String>> expectedData) {
        StringBuilder errors = new StringBuilder();

        for (String reg : expectedData.keySet()) {
            Map<String, String> actual = CarValuationPage.fetchedCarDetails.get(reg);
            Map<String, String> expected = expectedData.get(reg);

            if (actual == null) {
                errors.append("FAIL -  No data returned from site for: ").append(reg).append("\n");
                continue;
            }

            if (!actual.equals(expected)) {
                errors.append(" FAIL - Mismatch for: ").append(reg)
                        .append("\nExpected: ").append(expected)
                        .append("\nActual:   ").append(actual).append("\n\n");
            } else {
                System.out.println("PASS - Match for: " + reg);
            }
        }
            if (errors.length() > 0) {
                System.out.println("----------- TEST SUMMARY -----------");
                System.out.println(errors);
                throw new AssertionError(errors.toString());
            }

    }

}