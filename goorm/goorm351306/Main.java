package goorm.goorm351306;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1.정수 n을 입력
		//2.n만큼 반복하면서 문자영을 입력받음
		//3.add일 경우, 리스트에 name 저장
		//4.find일 경우, 저장된 리스트에서 partial로 시작하는 리스트를 찾아 count++
		//5.partial로 시작하는 리스트-startsWith 사용
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();

		List<String> name = new ArrayList<>();
		
		for(int i=0;i<n;i++){
			String s = sc.nextLine();
			String[] str = s.split(" ");
			if(str[0].equals("add")){
				name.add(str[1]);
			}
			else if(str[0].equals("find")){
				int count=0;
				for(int j=0;j<name.size();j++){
					if(name.get(j).startsWith(str[1])){
						count++;
					}
				}
				System.out.println(str[1]+"로 시작하는 학생들의 이름 개수 : "+count);
			}
		}
    }
}
