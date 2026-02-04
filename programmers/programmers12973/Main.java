package programmers12973;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요 : "); // "baabaa"
        String s = sc.nextLine();

        int answer = 0;

        Stack<String> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            // stack.push(s.substring(i,i+1));
            if(!stack.isEmpty()&&stack.peek().equals(s.substring(i,i+1))){
                stack.pop();
            }
            else{
                stack.push(s.substring(i,i+1));
            }
        }
        if(stack.isEmpty())
           answer=1;
        System.out.println(answer);
    }
}
