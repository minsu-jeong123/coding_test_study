package programmers154539;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("입력할 숫자의 개수를 입력하세요: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        System.out.println(n + "개의 숫자를 공백으로 구분하여 입력하세요:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=numbers.length-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=numbers[i])
                stack.pop();
            if(stack.isEmpty())
                answer[i]=-1;
            else if(stack.peek()>numbers[i])
                answer[i]=stack.peek();
            stack.push(numbers[i]);
        }
        // for(int i=0;i<numbers.length;i++){
        //     if(i==numbers.length-1){
        //         answer[i]=-1;
        //         return answer;
        //     }
        //     for(int j=i+1;j<numbers.length;j++){
        //         if(numbers[i]<numbers[j]){
        //             answer[i]=numbers[j];
        //             break;
        //         }
        //         else
        //             answer[i]=-1;
        //     }
        // }
        
        // 2. 결과를 터미널에 출력
        System.out.println("결과: " + Arrays.toString(answer));
    }
}
