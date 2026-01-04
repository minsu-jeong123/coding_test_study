package programmers42747;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("총 발표한 논문의 수 n : ");
        int n = sc.nextInt();
        System.out.println("각 논문별 인용된 횟수 배열 citations : ");
        int[] citations = new int[n];
        for(int i=0;i<n;i++){
            citations[i] = sc.nextInt();
        }

        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=0;i<citations.length;i++){
            //citations.length-i = 뒤에 남은 논문 수
            //현재 논문의 인용수가 뒤에 남은 논문 수이상이면 H후보
            if(citations[i]>=citations.length-i){
                int max=citations.length-i;
                if(answer<max)
                    answer=max;
            }
        }

        System.out.println(answer);
    }
}
