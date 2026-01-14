package programmers42883;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        //1.k수만큼 줄어든 숫자 저장 스택선언
        //2.number의 자리수만큼 for문 반복
        //3.스택의 마지막원소와 number의 각 자리수의 숫자 비교
        //3-1.스택의 마지막원소가 작으면 pop하고 k 1감소
        //3-2.k가 0보다 클때까지만 반복 - 자릿수가 k만큼 제거하기위해
        //3-3.스택의 마지막원소가 같거나 크면 push
        //4.k가 0보다 크면 스택에서 k개만큼 pop - 자리수를 맞추기 위해 남은 k개 만큼 제거
        //5.스택이 비워질때까지 pop하면서 answer에 저장
        Scanner sc = new Scanner(System.in);
        System.out.print("number 입력 : ");
        String number = sc.nextLine();
        System.out.print("k 입력 : ");
        int k = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        String answer = "";
        
        for(int i=0;i<number.length();i++){
            int n = Integer.parseInt(number.substring(i,i+1));
            while(!stack.isEmpty()&&k>0&&stack.peek()<n){
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        while(k>0){
            stack.pop();
            k--;
        }

        while(!stack.isEmpty()){
            answer=stack.pop()+answer;
        }

        System.out.println("k개의 수를 제거한 가장 큰 수 : "+answer);
    }    
}
