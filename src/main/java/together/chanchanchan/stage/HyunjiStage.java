package together.chanchanchan.stage;

import together.chanchanchan.player.Player;

import java.util.Scanner;

public class HyunjiStage extends GameController implements Game {
    public static final String name = "현지";
    public final int age = 24;
    public final String likeStyle = "체크남방";
    public final String feature = "토마토 세계관에 갇히 귀여운 토마토마토마토걸 ~ ";
    public boolean isCleared;

    @Override
    public void play() {
        gameInfo();
        Scanner sc = new Scanner(System.in);
        boolean checkStyle = checkStyle(likeStyle);
        gameStart(name);

        String[] RPC = {"가위", "바위", "보"};
        int playCount = 0;
        int winCount = 0;

        do {
            int ranRps = (int)(Math.random() * 3 + 0);

            if(playCount == 0 && checkStyle) {
                System.out.println(name + ": 나는 '" + RPC[ranRps] + "' 낼 거야! 이번만 봐준다~");
            }

            System.out.println("====== 가위바위보 ======");
            System.out.println("1. 가위");
            System.out.println("2. 바위");
            System.out.println("3. 보");
            System.out.println("=====================");
            System.out.print("내실 번호를 입력해주세요 : ");

            int input = sc.nextInt();

            System.out.println(name + "가 낸 것 : '" + RPC[ranRps] +"'");

            switch (input) {
                case 1 :
                    if(ranRps == 2) {
                        winCount++;
                        System.out.println("야호! 이겼다!");
                    } else {
                        System.out.println("아잇, 아쉽다..!");
                    }
                    System.out.println("이긴 횟수 : " + winCount);
                    playCount++;
                    break;
                case 2 :
                    if (ranRps == 0) {
                        winCount++;
                        System.out.println("역시, 남자는 주먹이지!");
                    } else {
                        System.out.println("하... 언제 이길 수 있지?");
                    }
                    System.out.println("이긴 횟수 : " + winCount);
                    playCount++;
                    break;
                case 3 :
                    if (ranRps == 1) {
                        winCount++;
                        System.out.println("아싸! 내가 이겼군~");
                    } else {
                        System.out.println("다음 판에는 꼭 이겨야지... 휴");
                    }
                    System.out.println("이긴 횟수 : " + winCount);
                    playCount++;
                    break;
                default :
                    System.out.println("1에서 3사이의 숫자를 입력해주세요 :)");
                    break;
            }
        } while(playCount < 5 || winCount < 3);

        if (winCount < 3) {
            isCleared = false;
        } else if (winCount == 3) {
            isCleared = true;
        }
        gameEnd(name, isCleared);
    }

    @Override
    public void printGirlInfo() {
        System.out.println("printGirlInfo method 호출...");
        // 아직 구현 중
    }

    @Override
    public void gameInfo() {
        System.out.println("gameInfo method 호출...");
        // 아직 구현 중
    }
}
