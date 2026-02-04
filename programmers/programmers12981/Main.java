package programmers12981;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("사람 수 n을 입력하세요 : ");
        int n = sc.nextInt();
        sc.nextLine();

        // System.out.println("단어 수 m을 입력하세요 : ");
        // int m = sc.nextInt();
        // sc.nextLine();

        // String[] words = new String[m];
        // System.out.println("단어를 입력하세요 : ");
        // for(int i=0;i<m;i++){
        //     words[i] = sc.nextLine();
        // }
        
        // 두 번째 줄: 단어들을 공백으로 입력받기
        System.out.println("단어를 입력하세요 : ");
        String line = sc.nextLine();
        String[] words = line.split(" ");

        int[] answer = new int[2];
        int count=0;

        List<String> list = new ArrayList<>();
        
        list.add(words[0]);
        
        for(int i=1;i<words.length;i++){
            if(!list.contains(words[i])&&words[i-1].substring(words[i-1].length()-1).equals(words[i].substring(0,1)))
                list.add(words[i]);
            else{
                count=i+1;
                break;
            }
        }
        
        //answer[0]=count%n;
        if(count != 0) {
            if(count%n == 0){
                answer[0]=n;
                answer[1]=count/n;
            }
            else {
                answer[0]=count % n;
                answer[1]=count/n+1;
            }
        } 
        else {
            answer[0] = 0;
            answer[1] = 0;
        }

        System.out.println("탈락한 사람 번호: " + answer[0]);
        System.out.println("탈락한 차례: " + answer[1]);
    }
}