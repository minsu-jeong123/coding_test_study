package programmers42578;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("의상의 개수를 입력하세요 : ");
        int n = sc.nextInt();
        String[][] clothes = new String[n][2];

        //yellow_hat headgear
        // blue_sunglasses eyewear
        // green_turban headgear
        for(int i=0;i<n;i++){
            clothes[i][0] = sc.next(); //의상 이름
            clothes[i][1] = sc.next(); //의상 종류
        }

        int answer = 1;
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            //map.getOrDefault(key, defaultValue) : 키가 없을 때 null 대신 defaultValue를 반환
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        // for(int i:map.values()){
        //     answer*=(i+1);//안입은 경우도 있으니 +1
        // }
        for(int i=0;i<clothes.length;i++){
            answer*=(map.get(clothes[i][1])+1);
            map.put(clothes[i][1],0);//중복방지로, 한번처리한 의상들은 0으로 초기화햐여 방지
        }

        System.out.println("조합의 수 : " + (answer-1));//모두 안입은 경우 제외
    }
}
