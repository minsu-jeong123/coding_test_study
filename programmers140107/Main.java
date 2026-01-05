package programmers140107;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 k와 원점과의 거리를 나타내는 정수 d를 입력하세요 : ");
        int k = sc.nextInt();
        int d = sc.nextInt();

        long answer = 0;
        
        //시간초과 발생
        // for(int i=0;i<=d;i+=k){
        //     for(int j=0;j<=d;j+=k){
        //         if(Math.sqrt(Math.pow(i,2)+Math.pow(j,2))<=d)
        //             answer++;
        //     }
        // }
        
        for(int i=0;i<=d;i+=k){
            //b값을 하나씩 구한 뒤
            long b=(long)Math.sqrt(Math.pow(d,2)-Math.pow(i,2));
            // System.out.println(b/k);
            //y축 기준으로 점의 개수는 b값에서 k를 나눠 +1를 해줌(0도 포함해주기 위해 +1)
            answer+=(b/k)+1;
        }

        System.out.println("총 몇개의 점이 찍히는가? : " + answer);
    }    
}
