package programmers81301;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자문자열과 영단어을 입력하세요 : ");
        //"one4seveneight" -> 1478

        String s = scanner.nextLine();

        String[] num = {"one","two","three","four","five","six","seven","eight","nine","zero"};
        String[] number = {"1","2","3","4","5","6","7","8","9","0"};
        
        for(int i=0;i<num.length;i++){
            if(s.contains(num[i])){
                s=s.replace(num[i],number[i]);
            }
        }

        System.out.print("올바른 정수 값은 : " + Integer.parseInt(s));
    }
}
