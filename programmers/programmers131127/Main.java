package programmers131127;

import java.util.*;

public class Main {
    //1.해쉬맵 사용
    //1-1.want, number을 합쳐서 하나의 해쉬맵으로 저장
    //1-2.discount를 또 다른 해쉬맵으로 10개(0~9개)까지 저장- 회원제가 10일간 지속
    //1-3.각 해쉬맵을 비교하여 같으면 answer증가
    //2.슬라이딩윈도우  
    //2-1.10일부터 하나씩 이동해(for문)하며 해쉬맵 업데이트
    //2-2.새로 들어오는 날짜의 제품은 맵에 +1
    //2-3.창문 밖으로 밀려나는 10일 전 날짜의 제품은 맵에서 -1 (수량이 0이 되면 아예 삭제)
    //2-4.비교해서 같으면 answer증가
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //banana apple rice pork pot
        System.out.print("원하는 제품을 입력하세요 : ");
        String[] want = sc.nextLine().split(" ");

        int[] number = new int[want.length];
        System.out.print("각 제품의 수량을 입력하세요 : ");
        for(int i=0;i<want.length;i++){
            //3 2 2 2 1
            number[i]=sc.nextInt();
        }
        sc.nextLine();

        //chicken apple apple banana rice apple pork banana pork rice pot banana apple banana
        System.out.print("할인 제품을 입력하세요 : ");
        String[] discount = sc.nextLine().split(" ");

        int answer=0;

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> sale = new HashMap<>();

        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }

        for(int i=0;i<10;i++){
            sale.put(discount[i],sale.getOrDefault(discount[i],0)+1);
        }

        if(map.equals(sale))
            answer++;

        for(int i=10;i<discount.length;i++){
            //10일이후 새로 들어오는 제품 비교
            sale.put(discount[i],sale.getOrDefault(discount[i],0)+1);
            //첫날부터 올라가면서 제품들 하나씩 -1
            sale.put(discount[i-10],sale.get(discount[i-10])-1);
            if(sale.get(discount[i-10])==0)
                sale.remove(discount[i-10]);

            if(map.equals(sale))
                answer++;
        }

        System.out.println("원하는 제품을 모두 할인 받을 수 있는 회원 등록 날짜의 총 수 : " + answer);

    }
}
