package programmers86491;

import java.util.*;

public class Main {
    //1.명함의 가로길이 w, 세로길이 h
    //2.각 명담의 최대 w, 최대 h를 구함
    //3.명함을 회전하면서 수납가능
    //3-1.각 배열의 명함의 큰값을 w, 작은값을 h로 갱신하면 반복
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("입력할 명함의 개수 : ");
        int n = sc.nextInt();
        sc.nextLine();

        int[][] sizes = new int[n][2];
        System.out.println("명함의 가로와 세로 길이를 입력하세요: ");
        for(int i=0;i<n;i++){
            sizes[i][0]=sc.nextInt();
            sizes[i][1]=sc.nextInt();
            sc.nextLine();
        }

        int answer=0;
        int maxw=0, maxh=0;

        for(int i=0;i<sizes.length;i++){
            // int w=sizes[i][0];
            // int h=sizes[i][1];
            //각 배열에 큰값을 가로, 작은값을 세로로 정하면서 최대값을 갱신해야됨
            int w=Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min(sizes[i][0],sizes[i][1]);
            maxw=Math.max(maxw,w);
            maxh=Math.max(maxh,h);
        }

        answer=maxw*maxh;
        System.out.println("최소 지갑 크기 : "+answer);
    }    
}
