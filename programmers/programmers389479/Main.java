package programmers389479;
import java.util.Scanner;

public class Main {
    //1.0~23시간대의 배열 num이 필요함
    //2.players : 각 시간대별로 게임 이용자 수
    // m : 서버당 최대 이용자 수, k : 서버당 운영 가능한 시간
    //3.각 시간대별로 필요한 서버 수를 구함 - players[i] / m 
    //4.players[i]와 m이 같을경우에도 서버 증가
    //5.생성한 배열을 활용하여 증설된 서버 수만큼 k번 반복문 돌려서 운영가능 시간을 계산
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //0 2 3 3 1 2 0 0 0 0 4 2 0 6 0 4 2 13 3 5 10 0 1 5
        System.out.print("시간대별 게임 이용자의 수 players : ");
        int[] players = new int[24];
        for(int i=0; i<=23; i++){
            players[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.print("서버당 최대 이용자 수 m : ");//3
        int m = sc.nextInt();
        sc.nextLine();
        System.out.print("서버당 운영 가능한 시간 k : ");//5
        int k = sc.nextInt();

        int[] num = new int[24];
        int answer=0;

        for(int i=0;i<players.length;i++){
            if(players[i]>=m&&num[i]==0){
                answer+=(players[i]/m);
                for(int j=i;j<i+k&&j<players.length;j++){
                    num[j]+=players[i]/m;
                }
            }
            else if(players[i]>=m&&num[i]<players[i]/m){
                int count=(players[i]/m)-num[i];
                answer+=count;
                for(int j=i;j<i+k&&j<players.length;j++){
                    num[j]+=count;
                }
            }
            else if(players[i]>=m&&num[i]>=players[i]/m){
                continue;
            }
        }
        System.out.println("증설해야 하는 서버의 최소 개수 : "+answer);
    }
}
