package goorm.goorm347925;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    //1.빈 문자열 s로 시작해서 커맨드로 입력받음
	//2.a 커맨드 : 문자열을 뒤에 더함
	//3.d 커맨드 : 정수만큼 마지막부터 문자를 삭제
	//4.u 커맨드 : 마지막 실행 a인지 d인지 확인 후, 이전으로 되돌림
	//5.r 커맨드 : 마지막 실행 u인지 확인 후, 이전으로 되돌림
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String s = "";
		int q = sc.nextInt();
		sc.nextLine();

		// 이전 상태 저장 (undo용)
		Stack<String> stack = new Stack<>();
		// 되돌린 상태 저장 (redo용)
		Stack<String> redo = new Stack<>();
		
		for(int i=0;i<q;i++){
			String input = sc.nextLine();
			String[] str = input.split(" ");
			if(str[0].equals("a")){
				stack.push(s);//현재 상태 저장
				s+=str[1];//커맨드 적용된 문자 저장
				redo.clear();
			}
			else if(str[0].equals("d")){
				stack.push(s);
				int removeCount = Integer.parseInt(str[1]);
        if(removeCount > s.length()) removeCount = s.length();
				s=s.substring(0,s.length()-removeCount);
				redo.clear();
			}
			else if(str[0].equals("u")){
				if(!stack.isEmpty()){
					redo.push(s);
					s=stack.pop();
				}
			}
			else if(str[0].equals("r")){
				if(!redo.isEmpty()){
					stack.push(s);
					s=redo.pop();
				}
			}
		}
		
		if(s.equals(""))
			System.out.print("출력할 문자열이 없습니다 : -1");
		else
			System.out.print("최종 출력할 문자열 : " + s);
    }
}
