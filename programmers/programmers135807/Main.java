package programmers135807;

import java.util.Scanner;

public class Main {
    //1.먼저  두 배열arrayA, arrayB을 입력받음
    //2.두 배열 각각 최대공약수 gcda, gcdb를 구함
    //3-1.gcda가 1이면 break, 아니면 gcda가 arrayB의 모든 원소와 나머지연산
    //3-2.gcdb가 1이면 break, 아니면 gcdb가 arrayA의 모든 원소와 나머지연산
    //3-3.각 나머지연산이 0이면 break
    //3-4.이 조건들이 맞지 않을경우 0으로 리턴
    //4.각 gcd가 1이 아니면서 각 모든 원소와 0이 아닌 경우, 
    //answer와 비교하면 가장 큰 값을 가져옴
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arrayA의 길이 입력 : ");
        int a_length = sc.nextInt();
        int[] arrayA = new int[a_length];
        System.out.println("arrayA의 원소 입력 : ");
        for(int i=0;i<a_length;i++){
            arrayA[i] = sc.nextInt();
        }

        System.out.print("arrayB의 길이 입력 : ");
        int b_length = sc.nextInt();
        int[] arrayB = new int[b_length];
        System.out.println("arrayB의 원소 입력 : ");
        for(int i=0;i<b_length;i++){
            arrayB[i] = sc.nextInt();
        }

        int answer = 0;
        int gcda = arrayA[0], gcdb = arrayB[0];

        for(int i=1;i<arrayA.length;i++){
            int a=gcda, b=arrayA[i];
            while(b!=0){
                int temp = b;
                b=a%b;
                a=temp;
            }
            gcda=a;
        }

        for(int i=1;i<arrayB.length;i++){
            int a=gcdb, b=arrayB[i];
            while(b!=0){
                int temp = b;
                b=a%b;
                a=temp;
            }
            gcdb=a;
        }
        if(gcda>1){
            boolean b = true;
            for(int i=0;i<arrayB.length;i++){
                if(arrayB[i]%gcda==0){
                    b= false;
                    break;
                }
            }
            if(b){
                answer=Math.max(answer, gcda);
            }
        }
        if(gcdb>1){
            boolean b = true;
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i]%gcdb==0){
                    b= false;
                    break;
                }
            }
            if(b){
                answer=Math.max(answer, gcdb);
            }
        }

        System.out.println("answer : " + answer);
    }
}
