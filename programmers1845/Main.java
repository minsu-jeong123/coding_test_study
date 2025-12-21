package programmers1845;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("입력할 폰켓몬 종류를 입력하세요:");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println(n + "개의 폰켓몬 종류를 공백으로 구분하여 입력하세요:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt(); 
        }

        int answer = 0;
        Set<Integer> hash = new HashSet<>();
        
        int number = nums.length/2;
        
        for(int i=0;i<nums.length;i++){
            hash.add(nums[i]);
        }
        
        if(number>hash.size())
            answer=hash.size();
        else
            answer=number;
        
        System.out.println("최대 선택 가능한 폰켓몬 종류 수: " + answer);
    }
}
