package programmers131704;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개의 상자를 실어야 하나요? : "); //5
        int[] order = new int[sc.nextInt()];
        sc.nextLine(); // 개행문자 제거

        System.out.println("택배상자 번호를 입력하세요 : "); // "4, 3, 1, 2, 5"
        for(int i=0;i<order.length;i++){
            order[i] = sc.nextInt();
        }
        sc.nextLine(); // 개행문자 제거

        int answer = 0;     
        int idx=0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1;i<=order.length;i++){
            if(order[idx]==i){
                answer++;
                idx++;
            }
            else{
                stack.push(i);
            }
            while(!stack.isEmpty()&&stack.peek()==order[idx]&&idx<order.length){
                stack.pop();
                answer++;
                idx++;
            }
        }
        System.out.println(answer);
    }
}