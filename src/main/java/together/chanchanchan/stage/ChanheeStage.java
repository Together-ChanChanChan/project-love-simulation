package together.chanchanchan.stage;

import java.util.Scanner;

public class ChanheeStage extends GameController implements Game {

    public static final String name = "찬희";             //이름
    public final int age = 23;                 //나이
    public final String likeStyle = "후드티";        //선호스타일
    public final String feature = "베이스볼 게임 중독";          //특징, 정보 출력할 때
    public boolean isCleared;       //게임 깼는지
    @Override
    public void play() {
        checkStyle();
        gameStart();
        // 베이스볼 게임 시작
        String answer = "princess";     //정답 단어
        System.out.println("정답 단어는 알파벳 8개야.");
        if(checkStyle()){
            System.out.println("후드티가 마음에 들어서 하는 말은 아닌데, 첫 알파벳은 'p'야.");
        }
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("단어를 입력하세요: ");
            String input = sc.nextLine();
            int strike = 0;
            int ball = 0;

            // 스트라이크, 볼 계산
            for (int i = 0; i < answer.length(); i++) {
                char answerChar = answer.charAt(i);
                for (int j = 0; j < input.length(); j++) {
                    char inputChar = input.charAt(j);
                    if (answerChar == inputChar) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }

            // 메세지 출력
            if (strike == 0 && ball == 0) {
                System.out.println("일치하는 알파벳이 하나도 없어!");
            } else {
                String message = "";
                if (strike > 0) {
                    message += strike + "스트라이크 ";
                }
                if (ball > 0) {
                    message += ball + "볼";
                }
                System.out.println(message);
            }

            // 정답을 맞췄을 경우 게임 종료
            if (strike == answer.length()) {
                System.out.println("홈런! 정답이야.");
                isCleared = true;
                break;
            }
        }
        sc.close();

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
