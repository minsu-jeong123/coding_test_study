package programmers142086;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("영문자 s을 입력하세요 : "); //banana
        String s = sc.nextLine();

        int[] answer = new int[s.length()];

        List<String> list = new ArrayList<>();
        
//lastIndexOf() 사용하면 조금 더 코드를 간략하게 정리 가능
        // for(int i=0;i<s.length();i++){
        //     if(!list.contains(s.substring(i,i+1))){
        //         list.add(s.substring(i,i+1));
        //         answer[i]=-1;
        //     }
        //     else{
        //         list.add(s.substring(i,i+1));
        //         for(int j=i-1;j>=0;j--){
        //             if(list.get(i).equals(list.get(j))){
        //                 answer[i]=i-j;
        //                 break;
        //             }
        //         }
        //     }
        // }
        
        for(int i=0;i<s.length();i++){
            if(list.lastIndexOf(s.substring(i,i+1))==-1){
                answer[i]=-1;
            }
            else{
                answer[i]=i-list.lastIndexOf(s.substring(i,i+1));
            }
            list.add(s.substring(i,i+1));
        }

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+", ");
        }

    }
}
