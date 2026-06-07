import java.util.Stack;

/*
 * Student Name: Ryley Carlson
 * CSC400 Critical Thinking Assignment: Ryley's Comic Book Manifest Infix Engine
 * Date: 2026-06-07
 * Program: InfixCalculator.java
 */
public class InfixCalculator {

    public int evaluateInfix(String infixExpression) {
        if (infixExpression == null || infixExpression.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Invalid infix expression");
        }

        String cleanLot = infixExpression.trim();
        if (isPostfixExpression(cleanLot)) {
            return processPostfixExpression(cleanLot);
        }
        
        cleanLot = cleanLot.replaceAll("\\s+", "");
        
        if (!cleanLot.contains("(") && !cleanLot.contains(")")) {
            int modifierCount = 0;
            for (char ch : cleanLot.toCharArray()) {
                if (isCollectionModifier(ch)) modifierCount++;
            }
            if (modifierCount > 1) {
                throw new IllegalArgumentException("Error: Invalid infix expression");
            }
        }
        
        Stack<Integer> issueCountStack = new Stack<>();
        Stack<Character> modifierStack = new Stack<>();
        int cursor = 0;
        
        while (cursor < cleanLot.length()) {
            char currentToken = cleanLot.charAt(cursor);
            
            // 1. Unpack Single-Digit and Multi-Digit Print Run Totals
            if (Character.isDigit(currentToken)) {
                StringBuilder digitBuffer = new StringBuilder();
                while (cursor < cleanLot.length() && Character.isDigit(cleanLot.charAt(cursor))) {
                    digitBuffer.append(cleanLot.charAt(cursor++));
                }
                issueCountStack.push(Integer.valueOf(digitBuffer.toString()));
                continue; // Prevent automatic loop counters from throwing off index markers
            }
            
            // 2. Queue Bracket Openings
            else if (currentToken == '(') {
                modifierStack.push(currentToken);
            }
            
            // 3. Process Bracket Closings: Evaluate everything nested inside the sub-bundle
            else if (currentToken == ')') {
                while (!modifierStack.isEmpty() && modifierStack.peek() != '(') {
                    if (issueCountStack.size() < 2) {
                        throw new IllegalArgumentException("Error: Invalid infix expression");
                    }
                    int rightOperand = issueCountStack.pop();
                    int leftOperand = issueCountStack.pop();
                    char modifier = modifierStack.pop();
                    issueCountStack.push(applyValuation(modifier, rightOperand, leftOperand));
                }
                if (modifierStack.isEmpty()) {
                    throw new IllegalArgumentException("Error: Invalid infix expression");
                }
                modifierStack.pop(); // Drop the matching entry brace
            }
            
            // 4. Sort incoming active bundle modifiers (+, -, *, /, %)
            else if (isCollectionModifier(currentToken)) {
                while (!modifierStack.isEmpty() && getModifierWeight(currentToken) <= getModifierWeight(modifierStack.peek())) {
                    if (issueCountStack.size() < 2) {
                        throw new IllegalArgumentException("Error: Invalid infix expression");
                    }
                    int rightOperand = issueCountStack.pop();
                    int leftOperand = issueCountStack.pop();
                    char modifier = modifierStack.pop();
                    issueCountStack.push(applyValuation(modifier, rightOperand, leftOperand));
                }
                modifierStack.push(currentToken);
            }
            
            // 5. Throw exceptions for unexpected characters or damaged symbols
            else {
                throw new IllegalArgumentException("Error: Invalid infix expression");
            }
            cursor++;
        }
        
        // Process remaining operations sitting inside the buffer vaults
        while (!modifierStack.isEmpty()) {
            char remainingModifier = modifierStack.pop();
            if (remainingModifier == '(' || issueCountStack.size() < 2) {
                throw new IllegalArgumentException("Error: Invalid infix expression");
            }
            int rightOperand = issueCountStack.pop();
            int leftOperand = issueCountStack.pop();
            issueCountStack.push(applyValuation(remainingModifier, rightOperand, leftOperand));
        }
        
        if (issueCountStack.size() != 1) {
            throw new IllegalArgumentException("Error: Invalid infix expression");
        }
        return issueCountStack.pop();
    }

    private boolean isPostfixExpression(String expr) {
        if (expr.contains("(") || expr.contains(")")) return false;
        if (expr.isEmpty()) return false;
        char lastChar = expr.charAt(expr.length() - 1);
        return isCollectionModifier(lastChar);
    }

    // Secondary processing track built specifically to parse valid postfix strings
    private int processPostfixExpression(String postfixExpr) {
        Stack<Integer> countStack = new Stack<>();
        String[] segments = postfixExpr.split("\\s+");
        for (String segment : segments) {
            if (segment.isEmpty()) continue;
            if (Character.isDigit(segment.charAt(0))) {
                countStack.push(Integer.valueOf(segment));
            } else if (segment.length() == 1 && isCollectionModifier(segment.charAt(0))) {
                if (countStack.size() < 2) {
                    throw new IllegalArgumentException("Error: Invalid infix expression");
                }
                int right = countStack.pop();
                int left = countStack.pop();
                countStack.push(applyValuation(segment.charAt(0), right, left));
            } else {
                throw new IllegalArgumentException("Error: Invalid infix expression");
            }
        }
        if (countStack.size() != 1) {
            throw new IllegalArgumentException("Error: Invalid infix expression");
        }
        return countStack.pop();
    }

    private boolean isCollectionModifier(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/' || token == '%';
    }

    private int getModifierWeight(char modifier) {
        if (modifier == '+' || modifier == '-') return 1;
        if (modifier == '*' || modifier == '/' || modifier == '%') return 2;
        return -1;
    }

    private int applyValuation(char modifier, int b, int a) {
        switch (modifier) {
            case '+' -> { return a + b; } // Combine lots
            case '-' -> { return a - b; } // Grade reduction count
            case '*' -> { return a * b; } // Variant ratio scaling
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Error: Division by zero");
                return a / b; // Distribute across storage units
            }
            case '%' -> {
                if (b == 0) throw new ArithmeticException("Error: Division by zero");
                return a % b; // Leftover remnant stack count
            }
            default -> { return 0; }
        }
    }

    public static void main(String[] args) {
        InfixCalculator calculator = new InfixCalculator();
        
        // Test Case 1: Valid Multi-Digit Infix with Modulo Operators
        try {
            String Expression1 = "(145 % 12) + 250";
            System.out.println("Result 1: " + calculator.evaluateInfix(Expression1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Test Case 2: Valid Nested Single-Digit Matrix
        try {
            String Expression2 = "9 * (7 - 4)";
            System.out.println("Result 2: " + calculator.evaluateInfix(Expression2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Test Case 3: Invalid Syntax Layout
        try {
            String Expression3 = "120 / 5 * 2";
            System.out.println("Result 3: " + calculator.evaluateInfix(Expression3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Test Case 4: Valid Standalone Postfix Stream Layout
        try {
            String Expression4 = "84 4 / 3 %";
            System.out.println("Result Postfix: " + calculator.evaluateInfix(Expression4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "InfixCalculator []";
    }
}