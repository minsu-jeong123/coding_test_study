package programmers12936;

import java.util.*;
import java.util.Scanner;

public class Main {
    //1.줄 서는 경우의 수는 n!
    //2.첫번째 자리는 (n-1)!씩 묶음 단위
    //2-1.n=3일 경우[1,2,3] , 첫자리 1은 2가지, 첫자리 2는 2가지, 첫자리 3은 2가지
    //2-2.k가 있는 첫번째 자리 수를 구하기위해 (k-1)/(n-1)!로 구함
    //k가 인덱스 역할이므로 k-1 해줌으로써 0부터 시작하게끔 함
    //2-3.첫번째 자리 이후 k는 k%(n-1)!로 갱신
    //3.두번째, 세번째 자리도 반복해서 진행
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n과 k를 입력하세요: ");
        int n = sc.nextInt();
        long k = sc.nextLong();
        sc.nextLine();

        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        int index=0;

        for(int i=1;i<=n;i++)
            list.add(i);

        long fac=1;
        for(int i=n-1;i>=1;i--){
            fac*=i;
        }

        k--;

        index=(int)(k/fac);
        answer[0]=list.remove(index);

        for(int i=1;i<n;i++){
            fac/=(n-i);
            k%=fac;
            index=(int)(k/fac);
            answer[i]=list.remove(index);
        }

        //배열 출력 Arrays.toString() 사용
        System.out.println("k번째 수열 : "+ Arrays.toString(answer));
    }
}
