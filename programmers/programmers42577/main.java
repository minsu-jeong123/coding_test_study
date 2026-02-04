package programmers42577;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("전화번호 목록의 개수를 입력하세요 : "); //3
        int n = sc.nextInt();
        sc.nextLine(); // 개행문자 제거
        String [] phone_book = new String[n];

        System.out.println("문자열 배열을 입력하세요 : "); //["119", "97674223", "1195524421"]
        for(int i=0;i<n;i++){
            phone_book[i] = sc.nextLine();
        }
        
        boolean answer = true;
        
        Arrays.sort(phone_book);
        // System.out.println(Arrays.toString(phone_book));
        
        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                System.out.println(answer);
                return;
            }
        }
        
//         Arrays.sort(phone_book);
        
//         for(int i=0;i<phone_book.length-1;i++){
//             for(int j=i+1;j<phone_book.length;j++){
//                 if(phone_book[j].startsWith(phone_book[i]))
//                     return false;
//             }
//         }
        System.out.println(answer);
    }
}
