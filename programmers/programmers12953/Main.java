package programmers12953;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력받은 n의 개수 : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("n만큼의 원소 : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        int answer=arr[0];

        for(int i=1;i<arr.length;i++){
            // 현재까지의 최소공배수와 현재 원소의 최대공약수 계산
            int gcd = gcd(answer,arr[i]);
            // 최소공배수 갱신
            answer=(answer*arr[i])/gcd;
        }
        System.out.println("최소공배수 : "+answer);
    }

    // public int lcm(int a, int b){
    //     return (a*b)/gcd(a,b);
    // }
    
    // 최대공약수 계산 함수
    public static int gcd(int a, int b){
        int x = Math.max(a,b);
        int y = Math.min(a,b);
        // 나누어 떨어지지 않을 때까지 반복;
        while(x%y!=0){
            int r =x%y;
            x=y;
            y=r;
        }
        return y;
    }
}
