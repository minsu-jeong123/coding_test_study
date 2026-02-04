package programmers154538;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //x+n, x*2, x*3으로 y로 변환하ㄴ는 최소연산 횟수
        System.out.println("자연수 x, y, n을 입력하세요 : ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();

        int answer = 0;
        
        //큐 : 탐색할 상태를 담는다
        //visited: 이미 방문한 상태를 다시 탐색하지 않도록 체크
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.add(new int[]{x, 0});//상태 + 거리(단계)
        visited.add(x);
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int count = cur[1];
            
            if(num==y){
                answer=count;
                break;
            }
            
            int[] next = {num+n, num*2, num*3};
            for(int i=0;i<next.length;i++){
                int j=next[i];
                if(j<=y&&!visited.contains(j)){
                    visited.add(j);
                    q.add(new int[]{j,count+1});
                }
            }
        }
        //도달 못했으면 answer는 여전히 0
        if(answer==0&&x!=y)
            answer=-1;

        System.out.println("최소 연산 횟수 : " + answer);
    }
}
