package programmers92341;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1.fees , 주차장 기본시간 , 기본요금, 단위시간, 단위 요굼
        //2.records , 시각 , 차량번호 , 내역
        //3.차량번호별 누적 시간을 계산 
        //4.누적시간이 기본시간보다 많다면 , 그 값을 뺀만틈 단위시간당 요금을 부여
        //5.적다면 기본요금 부여
        //6.초과한 시간의 단위시간당 나누어 떨어지지 않는다면 올림처리
        //7.입차 후 출차 내역이 없다면 23:59에 출차 계산 -> 23:59 - 입차시간
        //8.Map을 활용하여 해당 차량번호 별 누적 시간을 합산
        //8-1.in : 입차시간 기록용 map , total : 누적시간 기록용 map

        Scanner sc = new Scanner(System.in);
        
        System.out.println("기본시간, 기본요금, 단위시간, 단위요금 입력 : ");
        int[] fees = new int[4];
        for(int i=0;i<4;i++){
            fees[i]=sc.nextInt(); //180 5000 10 600
        }
        sc.nextLine(); // 버퍼 비우기

        System.out.println("주차 기록 입력 : ");
        //05:34 5961 IN,06:00 0000 IN,06:34 0000 OUT,07:59 5961 OUT,07:59 0148 IN,18:59 0000 IN,19:09 0148 OUT,22:59 5961 IN,23:00 5961 OUT
        String[] records = sc.nextLine().split(","); 

        Map<String, Integer> in = new HashMap<>(); // 입차시간 기록용
        Map<String, Integer> total = new HashMap<>(); // 누적시간 기록용

        for(int i=0;i<records.length;i++){
            String[] r = records[i].split(" ");
            
            String[] time = r[0].split(":");
            String car = r[1];
            String inout = r[2];

            int min = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);

            if(inout.equals("IN")){
                in.put(car,min);
            }
            else{
                int duration=min-in.remove(car);
                total.put(car,total.getOrDefault(car,0)+duration);
            }
        }
        //출차 기록이 없는 차량에 대해 23:59에 출차 처리
        for(String car : in.keySet()){
            int duration=(23*60+59)-in.get(car);
            total.put(car,total.getOrDefault(car,0)+duration);
        }
        //차량번호 오름차순 정렬 후 요금 계산
        List<String> keys = new ArrayList<>(total.keySet());
        Collections.sort(keys);

        int[] answer=new int[keys.size()];

        for(int i=0;i<keys.size();i++){
            String car=keys.get(i);
            int time=total.get(car);

            if(time>fees[0]){
                answer[i]=fees[1]+(int)Math.ceil((double)(time-fees[0])/fees[2])*fees[3];
            }
            else{
                answer[i]=fees[1];
            }
        }

        System.out.println("주차 요금 : ");
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }

        //시간 계산 - HH:MM 문자열을 분단위로 통일 시켜 계산
        //Map 사용1 - remove() : 데이터를 지우면서 동시에 그 값을 리턴
        //Map 사용2 - getOrDefault() : 시간 누적 합산 시 기존 값이 있다면 가져오고
        // 없으면 0으러 가져와서 duration 계산한 값을 더해주면서 누적 합
        //데이터 추출 - keySet() : Map에 저장된 모든 차량번호를 한꺼번에 꺼내어
        //반복을 돌리거나 리스트를 만들 때 사용됨
        //수학 연산 - (double) 캐스팅 : Math.ceil() 올림 사용 시 정수끼리 나누면 소수점이
        //없어지므로 반드시 실수형 변환 후 계산 -> Math.ceil(3.1) = 4.0

    }
}
