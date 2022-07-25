package com.greatlearning.balancedBrackets;
import java.util.*;

class bracketsCheck {
	public static void main(String[] args) {
		String expr = "([{}])";
		 
        if (areBracketsBalanced(expr))
            System.out.println("The entered string has balanced brackets.");
        else
            System.out.println("The entered string does not have balanced brackets.");
	}
	
	static boolean areBracketsBalanced(String expr)
    {
        Stack<Character> stack = new Stack<Character>();
 
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                stack.push(x);
                continue;
            }
 
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        return (stack.isEmpty());
    }
}