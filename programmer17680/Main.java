package programmer17680;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("캐시 크기를 입력하세요 : "); //3
        int cacheSize = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        System.out.println("도시 이름을 입력하세요 : "); // "Jeju Pangyo Seoul NewYork LA Jeju Pangyo Seoul NewYork LA"
        String[] cities = sc.nextLine().split(" ");

        int answer = 0;
        Deque<String> deq = new ArrayDeque<>();
        
        for(int i=0;i<cities.length;i++){
            cities[i]=cities[i].toLowerCase();
        }
        if(cacheSize==0){
            System.out.println(cities.length*5);
            return;
        }
        
        for(int i=0;i<cities.length;i++){
            if(deq.size()<cacheSize&&!deq.contains(cities[i])){
                deq.addLast(cities[i]);
                answer+=5;
            }
            else if(deq.size()>=cacheSize&&!deq.contains(cities[i])&&!deq.isEmpty()){
                deq.pollFirst();
                deq.addLast(cities[i]);
                answer+=5;
            }
            else if(deq.contains(cities[i])){
                deq.remove(cities[i]);
                deq.addLast(cities[i]);
                answer+=1;
            }
        } 

        System.out.println(answer);
    }
}
