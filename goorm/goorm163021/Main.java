package goorm.goorm163021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //1.n명의 친구, m개의 관계
	//2.1번부터 시작해서 연결된 모든 관계의 개수를 출력
	//3.영역 개수 세기 및 연결 요소 개수 구하기
	//3-1.dfs 호출 시마다 1씩 증가하는 count 활용

	static int count=0;
	//현재 노드 방문 처리 후, 연결된 노드 재귀함수
	public static void dfs(int node, List<List<Integer>> list, boolean[] visit){
		visit[node]=true;
		count++;
		//연결된 노드 순회
		for(int next:list.get(node)){
			if(!visit[next])
				dfs(next,list,visit);
		}
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		// 인접 리스트와 방문 배열 초기화
		List<List<Integer>> list = new ArrayList<>();
		boolean[] visit = new boolean[n+1];

		for(int i=0;i<=n;i++){
			list.add(new ArrayList<>());
		}

		//양방향 관계 입력
		for(int i=0;i<m;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}

		dfs(1,list,visit);//1번 노드부터 시작

		System.out.print("소문을 듣게 되는 친구의 수 : " + count);
    }
}
