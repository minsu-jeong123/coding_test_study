package programmers12900;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 n을 입력하세요 : "); //3
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        
        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }

        System.out.println(dp[n]);
    }
}
