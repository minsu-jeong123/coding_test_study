package programmers138476;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1.가장 개수가 많은 종류부터 채워넣으면 종류값을 최소화 가능
        //2.HashMap을 활용하여 각 크기별로 개수를 구함
        //3.내림차순 정렬하여 종류별로 k개수만큼 넣음
        Scanner sc = new Scanner(System.in);

        System.out.print("상자에 담을 k의 개수 : ");
        int k = sc.nextInt();
        sc.nextLine();

        System.out.print("수확한 귤의 크기들 : ");//1 3 2 5 4 5 2 3
        String[] tangerinestr = sc.nextLine().split(" ");
        int[] tangerine = new int[tangerinestr.length];
        for(int i=0;i<tangerinestr.length;i++){
            tangerine[i] = Integer.parseInt(tangerinestr[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int answer = 0;
        for(int i=0;i<list.size();i++){
            k-=list.get(i);
            answer++;
            if(k<=0)
                break;
        }

        System.out.println("최소 종류 수 : "+answer);
    }
}
