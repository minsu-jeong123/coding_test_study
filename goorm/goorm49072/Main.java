package goorm.goorm49072;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1.12와 21의 문자열이 각각 존재 하는지 판단
		//2.있으면 YES
		//3.없다면 NO 출력
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		for(int i=0;i<str.length()-1;i++){
			if(str.substring(i,i+2).equals("12")){
				for(int j=i+3;j<str.length()-1;j++){
					if(str.substring(j,j+2).equals("21")){
						System.out.print("Yes");
						return;
					}
				}
			}
			else if(str.substring(i,i+2).equals("21")){
				for(int j=i+3;j<str.length()-1;j++){
					if(str.substring(j,j+2).equals("12")){
						System.out.print("Yes");
						return;
					}
				}
			}
		}
		System.out.print("No");
    }
}
