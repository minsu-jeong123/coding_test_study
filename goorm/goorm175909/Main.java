package goorm.goorm175909;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        //1.n종류의 카드를 m장 입력받음
		//2.중복을 허용하지 않으면서 n종류의 카드를 모두 모으면 최소 몇장의 카드를 가져야 하는지
		//3.중복을 허용하지 않기에 hashset 사용
		//4.m개의 카드를 끝까지 사용해도 n종류를 못 모을경우 -1
		Scanner sc = new Scanner(System.in);

		Set<Integer> set = new HashSet<>();

		int max = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();

		for(int i=1;i<=m;i++){
			set.add(sc.nextInt());
			if(set.size()==max){
				System.out.print(i);
				break;
			}
			else if(i==m)
				System.out.print("-1");
		}
    }
}
