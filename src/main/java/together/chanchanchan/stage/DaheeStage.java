package together.chanchanchan.stage;

import java.util.Scanner;

public class DaheeStage extends GameController implements Game {

    public static final String name = "다희";             //이름
    public final int age = 25;                 //나이
    public final String likeStyle = "정장";        //선호스타일
    public final String feature = "눈만 마주치면 숫자 맞춰보라고 함";          //특징, 정보 출력할 때
    public boolean isCleared;       //게임 깼는지

    @Override
    public void play() {
        checkStyle();
        gameStart();
        //숫자 맞추기 게임
        int origin_num = (int) (Math.random() * 50) + 1;
        int input_num;
        int count = 1;            // 시도 횟수

        Scanner sc = new Scanner(System.in);

        System.out.println("내가 생각한 숫자를 맞춰봐! 범위는 1~50이고, 기회는 5번이야.");
        System.out.println("큰 수를 입력했을 경우 '다운', 작은 수를 입력했을 경우 '업'으로 힌트를 줄게.");
        while (true) {
            input_num = sc.nextInt();

            if (input_num == origin_num) {
                System.out.println("정답을" + (count) + "번째 시도에 맞췄어!");
                if(checkStyle()){
                    if(count == 6){
                        System.out.println("옷이 내 취향이라 기회를 6번으로 늘려 줄게.");
                        isCleared = true;
                        System.out.println("정담 맞추기에 성공했구나!");
                        System.out.println("나랑.. 영화 보러 갈래?");
                    } else if((count) <= 5){
                        isCleared = true;
                        System.out.println("정답 맞추기에 성공했구나!");
                        System.out.println("나랑.. 영화 보러 갈래?");
                    }
                } else {
                    if(count <= 5){
                        isCleared = true;
                        System.out.println("정답 맞추기에 성공했구나!");
                        System.out.println("나랑.. 영화 보러 갈래?");
                    } else {
                        System.out.println("내 마음도 못 맞추는구나.. 실망이야.");
                        break;
                    }
                }
            }

            if (input_num > origin_num) {
                System.out.println("다운");
            } else {
                System.out.println("업");
            }
            count++;
        }
        gameEnd();
    }

    @Override
    public void printGirlInfo() {
        System.out.println("이름 : " + name);
        System.out.println("나이 : "+ age);
        System.out.println("선호 스타일 : " + likeStyle);
        System.out.println("특징 : " + feature);

    }
}