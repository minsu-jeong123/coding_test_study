package programmers12901;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("월 / 일을 입력하세요 : ");
        int month = sc.nextInt();
        int day = sc.nextInt();

        String[] week={"SUN","MON","TUE","WED","THU","FRI","SAT"};
        // String[] week1=new String[7];
        int[] days={31,29,31,30,31,30,31,31,30,31,30,31};
        int count=0;
        
        for(int i=1;i<month;i++){
            count+=days[i-1];
        }
        // System.out.print(week[(count+day)%7]);  FRI
        // System.out.print((count+day)%7);   5

        System.out.print(week[(count+day+4)%7]);
    }
}
