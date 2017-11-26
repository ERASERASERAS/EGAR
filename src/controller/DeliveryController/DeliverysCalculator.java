package controller.DeliveryController;

import java.util.Stack;

/**
 * This is class needed for calculate delivery. Calculations are made with RPN-expressions
 */
public class DeliverysCalculator {

    /**
     * This method return RPN-representation of initial expression
     *
     * @param expression Initial expression
     * @return RPN-representation of initial expression
     */
    private static String expressionToPoliz(String expression){
        String poliz ="";
        char [] expressionCharMas = expression.toCharArray();
        Stack<Character> stackForOperators = new Stack<Character>();
        String number = "";
        for(int i = 0; i < expressionCharMas.length; i++){
            if((expressionCharMas[i] >= '0' && expressionCharMas[i] <= '9') || (expressionCharMas[i] == '.')){
                number += expressionCharMas[i];
            } else{
                if(!number.equals((""))){
                    poliz += number + " ";
                    number = "";
                }
                if(stackForOperators.isEmpty()){
                    stackForOperators.push(expressionCharMas[i]);
                }
                else if(expressionCharMas[i] == '(') {
                    stackForOperators.push(expressionCharMas[i]);
                } else if(expressionCharMas[i] == ')'){
                    while(stackForOperators.peek() != '('){
                        poliz += stackForOperators.pop() + " ";
                    }
                    stackForOperators.pop();
                }
                else {
                    if(getPriority(stackForOperators.peek()) >= getPriority(expressionCharMas[i])) {
                        poliz += stackForOperators.pop() + " ";
                        stackForOperators.push(expressionCharMas[i]);
                    } else {
                        stackForOperators.push(expressionCharMas[i]);
                    }
                }
            }

        }
        if(!number.equals("")){
            poliz += number + " ";
        }
        while(!stackForOperators.isEmpty()){
            poliz += stackForOperators.pop() + " ";
        }

        return poliz;
    }

    /**
     * This method gets priority of operators
     *
     * @param operator Some operator
     * @return Priority of operator
     */
    private static int getPriority(char operator){
        int priority = 0;
        switch (operator)
        {
            case '(':
                priority = -1;
                break;
            case '+':
                priority = 1;
                break;
            case '-':
                priority = 1;
                break;
            case '*':
                priority = 2;
                break;
            case '/':
                priority = 2;
                break;
            case '^':
                priority =  3;
                break;
            default:
                break;
        }
        return priority;
    }

    /**
     * This is method calculate RPN-expressions
     * @param expression Expression in RPN
     * @return Result of calculations
     */
    public static double calculate(String expression){
        double result = 0;
        String [] partsOfExpression = expressionToPoliz(expression).split(" ");
        Stack<String> stackForCalculate = new Stack<String>();
        for(int i = 0; i < partsOfExpression.length; i++) {
            switch(partsOfExpression[i]){
                case "+":
                    stackForCalculate.push(new Double(Double.parseDouble(stackForCalculate.pop()) +
                            Double.parseDouble(stackForCalculate.pop())).toString());
                    break;
                case "-":
                    stackForCalculate.push(new Double(-Double.parseDouble(stackForCalculate.pop()) +
                            Double.parseDouble(stackForCalculate.pop())).toString());
                    break;
                case "*":
                    stackForCalculate.push(new Double(Double.parseDouble(stackForCalculate.pop()) *
                            Double.parseDouble(stackForCalculate.pop())).toString());
                    break;
                case "/":
                    stackForCalculate.push(new Double(Double.parseDouble(stackForCalculate.pop()) /
                            Double.parseDouble(stackForCalculate.pop())).toString());
                    break;
                case "^":
                    break;
                default:
                    stackForCalculate.push(partsOfExpression[i]);
                    break;
            }
        }
        result = Double.parseDouble(stackForCalculate.pop());
        return result;
    }

}
