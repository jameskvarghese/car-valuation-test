package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.*;
import org.apache.commons.csv.*;

public class InputReader {

    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    public static List<String> extractRegistrationNumbers(String filePath) {
        List<String> regNumbers = new ArrayList<>();
        String pattern = "\\b[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}\\b";
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            Matcher matcher = Pattern.compile(pattern)
                    .matcher(content);
            while (matcher.find()) {
                regNumbers.add(matcher.group().replaceAll("\\s", ""));
            }
        } catch (IOException e) {
            LOGGER.severe("Failed to read input file: " + e.getMessage());
        }
        return regNumbers;
    }

    public static Map<String, Map<String, String>> loadExpectedOutput(String filePath) {
        Map<String, Map<String, String>> data = new HashMap<>();
        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);

            for (CSVRecord record : records) {
                String reg = record.get("VARIANT_REG").replaceAll("\\s", "");
                Map<String, String> carDetails = new HashMap<>();
                carDetails.put("MAKE", record.get("MAKE"));
                carDetails.put("MODEL", record.get("MODEL"));
                carDetails.put("YEAR", record.get("YEAR"));
                data.put(reg, carDetails);
            }
        } catch (IOException e) {
            LOGGER.severe("Failed to read CSV file: " + e.getMessage());
        }
        return data;
    }
}