package programmers17682;

import java.util.Scanner;

public class Main {
    //1.게임이 총 3라운드 진행됨
    //2.각 라운드마다 점수, 보너스, 옵션이 존재함, 옵션은 필수 아님
    //3.점수는 0~10 사이
    //4.보너스 S는 1제곱, D는 2제곱, T는 3제곱
    //5.옵션은 *일때 직전 점수와 현재 점수 2배 적용, #일때 현재 점수 마이너스 적용
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("다트 결과 입력 : ");
        String dartResult = sc.nextLine(); //1S2D*3T, 1D2S#10S, 1D2S0T ...

        int[] score = new int[3];//총 3라운드라서 배열크기 3으로 지정
        int idx=-1;//현재 라운드 표시
        int answer=0;

        char[] c = dartResult.toCharArray();
        for(int i=0;i<c.length;i++){
            if('0'<=c[i]&&c[i]<='9'){
                idx++;
                if(c[i]=='1'&&c[i+1]=='0'&&i+1<c.length){
                    score[idx]=10;
                    i++;
                }
                else
                    score[idx]=c[i]-'0';
            }
            else if(c[i]=='S'||c[i]=='D'||c[i]=='T'){
                if(c[i]=='S')
                    score[idx]=(int)Math.pow(score[idx],1);
                else if(c[i]=='D')
                    score[idx]=(int)Math.pow(score[idx],2);
                else if(c[i]=='T')
                    score[idx]=(int)Math.pow(score[idx],3);
            }
            else if(c[i]=='*'){
                score[idx]*=2;
                if(idx>0)
                    score[idx-1]*=2;
            }
            else if(c[i]=='#')
                score[idx]*=-1;
        }

        answer=score[0]+score[1]+score[2];
        System.out.print("총점 : "+answer);
    }
}
