package com.banking.app.rule;

import lombok.Getter;
import lombok.Setter;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Map;

@Getter
@Setter
public class Rule {

    private String condition;
    private String action;

    // getters and setters

    public boolean evaluateCondition(Map<String, Object> data) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(condition);
        return expression.getValue(data, Boolean.class);
    }

    public void performAction() {
        // Perform the action based on the rule
        System.out.println("Performing action: " + action);
    }
}
