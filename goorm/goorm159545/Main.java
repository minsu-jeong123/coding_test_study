package goorm.goorm159545;
import java.util.*;

public class Main {
    //1.지인 수는 짝수
	//2.0점 없음 , 두 사람의 합이 0이면 짝이 이루어짐 (제외시킴)
	//3.합이 0이 안된 두 사람의 점수를 출력
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = new int[n];
		boolean[] b = new boolean[n];//짝이 이루어진 사람 체크
		int sum=0;//소개팅을 받지 못한 두사람의 합

		for(int i=0;i<n;i++){
			s[i]=sc.nextInt();
		}

		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(s[i]+s[j]==0){
					b[i]=true;
					b[j]=true;
					break;
				}
			}
		}

		for(int i=0;i<n;i++){
			if(b[i]!=true){
				sum+=s[i];
			}
		}

		System.out.print(sum);
    }
}
