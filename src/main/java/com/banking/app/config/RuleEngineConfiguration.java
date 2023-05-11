package com.banking.app.config;

import com.banking.app.rule.Rule;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RuleEngineConfiguration {

    @Bean
    public List<Rule> rules(@Value("${app.rule.path}") String path) throws IOException, ParseException {
      return prepareRules(path);
    }

    private List<Rule> prepareRules(String csvFilePath) throws IOException, ParseException {
        List<Rule> ruleList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> csvData = reader.readAll();

            // Skip the header row if it exists
            boolean skipHeader = true;

            for (String[] row : csvData) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                Rule rule = new Rule();
                rule.setCondition(row[0]); // rule
                rule.setAction(row[1]); // product
                ruleList.add(rule);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return ruleList;
    }
}
