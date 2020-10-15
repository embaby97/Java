/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Alaa
 */
import java.io.*; 
import java.util.*; 

public class Stack_check {

     public static boolean balanced(String s) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } 
            else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } 
            else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            }
             else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
public static void main(String []argh)
{
    System.out.println ("Enter brackets to check if balanced ??!");
    Scanner sc = new Scanner(System.in);
		
    while (sc.hasNext()) 
        {
	String input=sc.next();
        //Complete the code
        System.out.println(balanced(input));
	}
		
    }
}

