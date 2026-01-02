package programmers49993;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("스킬 트리를 입력하세요 : "); // "CBD"
        String skill = sc.nextLine();
        System.out.println("스킬 트리 배열을 입력하세요 : "); // BACDE CBADF AECB BDA
        String[] skill_trees = sc.nextLine().split(" ");

        int answer = 0;
        
        for(int i=0;i<skill_trees.length;i++){
            //replaceAll의 정규표현식 - "^"은 해당 문자를 제외한 나머지를 뜻함.
            String tree = skill_trees[i].replaceAll("[^"+skill+"]","");
            // System.out.println(tree);
            if(skill.substring(0,tree.length()).equals(tree)){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
