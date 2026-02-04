package programmers72410;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //1.모든 대문자를 소문자로 치환
    //2.알파벳 소문자, 숫자, 빼기- , 밑줄_, 마침표. 제외한 모든 문자 제거
    //3.마침표 연속 2번이면 하나의 마침표로
    //4.처음 or 끝에 마침표가 있으면 제거
    //5.빈 문자열이면 "a" 대입
    //6.길이가 16이상이면 15길이까지 저장 후 제거, 제거 후 끝이 마침표면 그것도 제거
    //7.길이가 2이하면 3될때까지 마지막 문자 반복
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요: "); //...!@BaT#*..y.abcdefghijklm
        String new_id = sc.nextLine();
        String answer = "";
        

        //새로운 방식 코드
        String temp = new_id.toLowerCase();
        temp=temp.replaceAll("[^a-z0-9-_.]","");
        //[.]{2,} -> 연속된 .일 경우 하나의 .으로 치환
        temp=temp.replaceAll("[.]{2,}",".");

        if(temp.charAt(0)=='.')
            temp=temp.substring(1);
        if(temp.charAt(temp.length()-1)=='.')
            temp=temp.substring(0,temp.length()-1);

        if(temp.isEmpty())
            temp="a";

        if(temp.length()>=16){
            temp=temp.substring(0,15);
            if(temp.charAt(temp.length()-1)=='.')
                temp=temp.substring(0,temp.length()-1);
        }

        while(temp.length()<3){
            temp+=temp.charAt(temp.length()-1);
        }
        
        answer=temp;

        System.out.println("추천하는 새로운 아이디 : "+ answer);


        //내가 처음에 푼 방식 코드
        // String answer = "";
        // List<String> list = new ArrayList<>();
        
        // for(int i=0;i<new_id.length();i++){
        //     String s = new_id.substring(i,i+1).toLowerCase();
        //     s=s.replaceAll("[^a-z0-9_.-]","");
            
        //     //replaceAll로 "" 변경했으므로, 빈 문자열은 건너뛰기
        //     if(s.isEmpty()) continue; 
            
        //     // 현재 문자가 '.'이고, 직전이 '.'이면 추가하지 않음
        //     if(s.equals(".") && !list.isEmpty() && list.get(list.size()-1).equals(".")) {
        //         continue;
        //     }
        //     list.add(s);
        // }
        
        // if(!list.isEmpty()&&list.get(0).equals("."))
        //     list.remove(0);
        
        // if(!list.isEmpty()&&list.get(list.size()-1).equals("."))
        //     list.remove(list.size()-1);

        // if(list.isEmpty())
        //     list.add("a");
        
        // while(list.size() > 15){
        //     list.remove(list.size()-1);
        // }
        // // while()문 끝나자마자 마지막 글자 "."안자 확인
        // if(!list.isEmpty()&&list.get(list.size()-1).equals("."))
        //     list.remove(list.size()-1);

        // while(list.size()<3){
        //     list.add(list.get(list.size()-1));
        // }
        
        // for(int i=0;i<list.size();i++)
        //     answer+=list.get(i);
        
        // System.out.println("추천하는 새로운 아이디 : "+ answer);
    }
}
