package com.banking.app.service;

import com.banking.app.rule.Rule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RuleEngineService {

    private List<Rule> rules;

    public RuleEngineService(List<Rule> rules) {
        this.rules = rules;
    }

    public void executeRules(Map<String, Object> data) {
        for (Rule rule : rules) {
            if (rule.evaluateCondition(data)) {
                rule.performAction();
            }
        }
    }
}
