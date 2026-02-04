package programmers12914;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n을 입력하세요 : ");
        int n = sc.nextInt();
        
        int[] f = new int[n+1];
        
        // f[0]=0;
        // f[1]=1;
        // f[2]=2;
        if(n<=2)
            System.out.println(n);

        else if(n>2){
            f[0]=0;
            f[1]=1;
            f[2]=2;
            for(int i=3;i<=n;i++){
                f[i]=(f[i-1]+f[i-2])%1234567;
            }
            System.out.println(f[n]);
        }
    }
}
