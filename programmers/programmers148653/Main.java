package programmers148653;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 엘리베이터의 위치 storey는 : ");
        int storey = sc.nextInt();

        int answer = 0;
        
        while(storey>0){
            int n=storey%10;//해당 자리수 저장
            
            if(n>5){
                answer+=(10-n);
                storey+=10;
            }
            else if(n<5){
                answer+=n;
            }
            else{//해당 자리수가 5일 경우, 다음 자리수 확인 후, 올림내림 결정
                int next=(storey/10)%10;
                if(next>=5){
                    answer+=(10-n);
                    storey+=10;
                }
                else{
                    answer+=n;
                }
            }
            storey/=10;
        }

        System.out.println("최소 버튼 조작 횟수 : " + answer);
    }
}
