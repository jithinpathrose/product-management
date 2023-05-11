package com.banking.app.service;

import com.banking.app.dto.CustomerInfo;
import com.banking.app.rule.Rule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RuleEngineService {

    private List<Rule> rules;

    public RuleEngineService(List<Rule> rules) {
        this.rules = rules;
    }

    public List<String> executeRules(CustomerInfo data) {
        List<String> actions = new ArrayList<>();
        for (Rule rule : rules) {
            if (rule.evaluateCondition(data)) {
                actions.add(rule.performAction());
            }
        }
        return actions;
    }
}
