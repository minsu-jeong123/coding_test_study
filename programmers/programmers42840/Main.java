package programmers42840;

import java.util.*;

public class Main {
    public static void main(String[] args){
    //1.1,2,3번들의 패턴을 묶음
    //1-1.정답을 또한 묶어서 for문으로 1,2,3번들과 반복비교
    //2.일치한 개수를 각각 구해서 최대로 많이 맞춘 사람을 가져옴

        Scanner sc = new Scanner(System.in);
        System.out.print("정답 answers : ");
        int[] answers = new int[5];
        for(int i=0;i<5;i++)
            answers[i]=sc.nextInt();
        sc.nextLine();

        int[][] math = {{1,2,3,4,5},
                        {2,1,2,3,2,4,2,5},
                        {3,3,1,1,2,2,4,4,5,5}};
        int[] score = new int[3];

        for(int i=0;i<math.length;i++){
            for(int j=0;j<answers.length;j++){
                if(answers[j]==math[i][j%math[i].length])
                    score[i]++;
            }
        }

        int max=Math.max(score[0],score[1]);
        max=Math.max(max,score[2]);

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<score.length;i++){
            if(max==score[i])
                list.add(i+1);
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<list.size();i++)
            answer[i]=list.get(i);

        System.out.println("최다 정답자 번호 : "+Arrays.toString(answer));
    }
}
