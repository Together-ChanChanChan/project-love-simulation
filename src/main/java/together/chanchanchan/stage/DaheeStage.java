package together.chanchanchan.stage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DaheeStage extends GameController implements Game {

    public static final String NAME = "다희";             //이름
    public final int AGE = 23;                           //나이
    public final String LIKESTYLE = "정장";               //선호스타일
    public final String FEATURE = "영혼의 듀오를 구하고 있음";          //특징, 정보 출력할 때
    public boolean isCleared;                           //게임 깼는지
    public boolean isTry;

    @Override
    public void play(String playerName, String nowStyle) {
        boolean checkStyle = checkStyle(nowStyle, LIKESTYLE);
        gameStart(NAME, playerName);
        gameInfo();
        Scanner sc = new Scanner(System.in);

//        숫자 맞추기 게임
        int origin_num = (int) (Math.random() * 50) + 1;
        int input_num;
        int count = 1;            // 시도 횟수
        int chance = 0;


        if (checkStyle) {
            chance = 6;
        } else if (!checkStyle) {
            chance = 5;
        }

        while (chance > 0) {
            System.out.print("입력: ");
            try {
                input_num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("1~50 사이의 숫자를 입력해줘!");
                sc.nextLine();
                continue;
            }

            if (input_num == origin_num) {
                System.out.println("정답을" + (count) + "번째 시도에 맞췄어!");
                isCleared = true;
                break;
            } else if (input_num > origin_num) {
                System.out.println("다운");
                chance--;
                count++;
            } else if (input_num < origin_num) {
                System.out.println("업");
                chance--;
                count++;
            }
        }
        gameEnd(NAME, isCleared);
        isTry = true;
    }

    @Override
    public void printGirlInfo() {
        System.out.println("아 날씨 좋다~ 협곡으로 놀러 가고 싶네.");
        System.out.println("내가 궁금하니?");
        System.out.println("난 " + NAME + "라고 해. 집에서 게임 하는 걸 좋아하지.");
        System.out.println("나이는" + AGE + "살이야. 아닌 것 같다고? 만 나이로" + AGE + " 이라고!");
        System.out.println("평소엔 후리하게 입어도 가끔 " + LIKESTYLE + "을 입은 모습을 보면 그렇게 멋있더라~");
        System.out.println("나는 항상" + FEATURE + "! 구마유시같은 원딜러 어디 없나.");

    }

    @Override
    public void gameInfo() {
        System.out.println("======" + NAME + "STAGE 게임 소개 ======");
        System.out.println("내가 생각한 숫자를 맞춰봐! 범위는 1~50이고, 기회는 5번이야.");
        System.out.println("큰 수를 입력했을 경우 '다운', 작은 수를 입력했을 경우 '업'으로 힌트를 줄게.");
        System.out.println("내 취향에 맞는 옷을 입고 있으면 기회를 6번 줄게.");


    }

}