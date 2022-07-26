package com.greatlearning.balancedBrackets;
import java.util.*;

class bracketsCheck {
	public static void main(String[] args) {
		String expr = "([{}])";
		 
        if (areBracketsBalanced(expr))
        	//If Stack is empty then print the brackets are balanced
            System.out.println("The entered string has balanced brackets.");
        else
        	//If Stack is not empty then print the brackets are balanced
            System.out.println("The entered string does not have balanced brackets.");
	}
	
	static boolean areBracketsBalanced(String expr)
    { 
		//Creating a character stack
        Stack<Character> stack = new Stack<Character>();
 
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);//Getting the character at ith index
 
            //If the character is any of the open braces then push it to the stack
            if (x == '(' || x == '[' || x == '{')
            {
                stack.push(x);
                continue;
            }
            
            //If stack is empty return false
            if (stack.isEmpty())
                return false;
            char check;
            
            //If the character is any of the closed braces then follow as the case directs
            switch (x) {
            case ')':
                check = stack.pop();//Store the popped character in a variable
                if (check == '{' || check == '[')//If the popped bracket equal to curly or square bracket then return false
                    return false;
                break;
 
            case '}':
                check = stack.pop();//Store the popped character in a variable
                if (check == '(' || check == '[')//If the popped bracket equal to round or square bracket then return false
                    return false;
                break;
 
            case ']':
                check = stack.pop();//Store the popped character in a variable
                if (check == '(' || check == '{')//If the popped bracket equal to round or curly bracket then return false
                    return false;
                break;
            }
        }
 
        return (stack.isEmpty());//Return if stack is empty or not
    }
}