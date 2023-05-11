package com.banking.app.service;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class RuleParser {
    public static void main(String[] args) {
        RuleData ruleData = new RuleData();
        ruleData.setIncome(50000);
        ruleData.setAge(25);

        String ruleString = "Income > 0 && Age > 17";

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(ruleString);

        StandardEvaluationContext context = new StandardEvaluationContext(ruleData);

        boolean result = expression.getValue(context, Boolean.class);
        System.out.println("Rule evaluation result: " + result);
    }

    public static class RuleData {
        private int income;
        private int age;

        public int getIncome() {
            return income;
        }

        public void setIncome(int income) {
            this.income = income;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

