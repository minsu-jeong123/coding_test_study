package programmers142085;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1.보유한 병사 n, 무적권 수 k, 각 라운드 별 병사 소모 수 enemy배열
        //2.각 라운드마다 소모한 병사를 갱신, 0이 되면 무적권 or 끝
        //2-1.무적권이 있으면 병사가 부족하더라도 라운드를 넘길 수 있음
        //2-2.무적권이 없다면 해당 라운드에서 끝
        //3.모든 라운드를 넘길 수 있는지 확인
        //4.모든 라운드를 못넘길 시 최대 라운드 수를 리턴
        //5.가장 큰수일경우에만 무적권을 사용
        //list를 사용하면 매 라운드마다 내림차순 정렬 필수 - 비효율
        //PriorityQueue를 사용하여 최대힙 설정

        int answer = 0;
        // List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Scanner sc = new Scanner(System.in);

        System.out.print("보유한 병사 n : ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.print("무적권 수 k : ");
        int k = sc.nextInt();
        sc.nextLine();

        //4, 2, 4, 5, 3, 3, 1
        System.out.print("각 라운드 별 병사 소모 수 enemy : ");
        String[] str = sc.nextLine().split(", ");
        int[] enemy = new int[str.length];
        for(int i=0;i<str.length;i++){
            enemy[i]=Integer.parseInt(str[i]);
        }

        for(int i=0;i<enemy.length;i++){
            n-=enemy[i];
            // list.add(enemy[i]);
            // Collections.sort(list,Collections.reverseOrder());
            pq.add(enemy[i]);

            if(n<0){
                if(k>0){
                    n+=pq.poll();
                    k--;
                }
                else{
                    break;
                }
            }
            answer++;
        }

        System.out.println("최대 라운드 수 : " + answer);
    }
}