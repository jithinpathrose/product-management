package com.banking.app.rule;

import com.banking.app.dto.CustomerInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;

@Getter
@Setter
public class Rule {

    private String condition;
    private String action;

    private String freeText;

    // getters and setters

    public boolean evaluateCondition(CustomerInfo data) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(condition);
        StandardEvaluationContext context = new StandardEvaluationContext(data);
        try {
            return expression.getValue(context, Boolean.class);
        }catch(Exception e){
            throw new RuntimeException("Rule execution failed. Please evaluate the rule : "+ condition);
        }
    }

    public String performAction() {
        // Perform the action based on the rule
        System.out.println("Performing action: " + action);
        return action;
    }
}
