package programmers12926;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("암호화할 문자열을 입력하세요: ");
        String s = sc.nextLine();
        System.out.println("옮길 거리 n을 입력하세요: ");
        int n = sc.nextInt();

        String answer = "";
        
        String[] str = s.split("");
        
        for(int i=0;i<str.length;i++){
            char c = str[i].charAt(0);
            if(65<=c&&90>=c){
                c=(char)(c+n);
                if(90<c)
                    c=(char)(c-26);
            }
            else if(97<=c&&122>=c){
                c=(char)(c+n);
                if(122<c)
                    c=(char)(c-26);
            }
            else{
                continue;
            }
            str[i]=String.valueOf(c);
        }
        
        for(int i=0;i<str.length;i++){
            answer+=str[i];
        }

        System.out.println("암호화된 문자열: " + answer);
    }
}
