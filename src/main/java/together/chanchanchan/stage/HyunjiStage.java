package together.chanchanchan.stage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HyunjiStage extends GameController implements Game {
    public static final String NAME = "현지";
    public final int AGE = 22;
    public final String LIKESTYLE = "체크남방";
    public final String FEATURE = "토마토 세계관에 갇히 귀여운 토마토마토마토걸 ~ ";
    public boolean isCleared;
    public boolean isTry;

    @Override

    public void play(String playerName, String nowStyle) {
        gameInfo();
        Scanner sc = new Scanner(System.in);
        boolean checkStyle = checkStyle(nowStyle, LIKESTYLE);
        gameStart(NAME, playerName);


        String[] RPC = {"가위", "바위", "보"};
        int playCount = 0;
        int winCount = 0;

        do {
            int ranRps = (int)(Math.random() * 3 + 0);

            if(playCount == 0 && checkStyle) {
                System.out.println(NAME + ": 나는 '" + RPC[ranRps] + "' 낼 거야! 이번만 봐준다~");
            }

            System.out.println("====== 가위바위보 ======");
            System.out.println("1. 가위");
            System.out.println("2. 바위");
            System.out.println("3. 보");
            System.out.println("=====================");
            String input = sc.nextLine();
            System.out.println(NAME + "가 낸 것 : '" + RPC[ranRps] +"'");

            switch (input) {
                case "1" :
                    if(ranRps == 2) {
                        winCount++;
                        System.out.println("야호! 이겼다!");
                    } else {
                        System.out.println("아잇, 아쉽다..!");
                    }
                    System.out.println("이긴 횟수 : " + winCount);
                    playCount++;
                    break;
                case "2" :
                    if (ranRps == 0) {
                        winCount++;
                        System.out.println("역시, 남자는 주먹이지!");
                    } else {
                        System.out.println("하... 언제 이길 수 있지?");
                    }
                    System.out.println("이긴 횟수 : " + winCount);
                    playCount++;
                    break;
                case "3" :
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
        } while(playCount < 5 && winCount < 3);

        if (winCount < 3) {
            isCleared = false;
        } else if (winCount == 3) {
            isCleared = true;
        }
        gameEnd(NAME, isCleared);
        isTry = true;
    }

    @Override
    public void printGirlInfo() {
        System.out.println("================================");
        System.out.println("안녕! 내 이름은 " + NAME + "야! 나는 토마토를 정말 좋아해... 🍅");
        System.out.println("내 나이가 몇 살이냐고? 숙녀에게 나이를 묻다니... 너무한데? 하지만, 특별히 너한테는 알려 줄게 나는 " + AGE + "살이야.");
        System.out.println("그리고 나는... 이상하게 '체크남방'이 참 좋더라구? 이상하게 매력적이란 말이지 :)");
        System.out.println("내 친구들이 적어준 내 특징이 있는데 볼래? 좋다고? 알았어!");
        System.out.println(NAME + "의 특징 : " + FEATURE);
        System.out.println("이제 내 소개는 끝났어! 안녕! 잘 가!");
    }

    @Override
    public void gameInfo() {
        System.out.println("======" + NAME + "STAGE 게임 소개 ======");
        System.out.println("이번 스테이지는 '가위바위보'입니다.\n총 5번의 기회가 주어지며, 그 중 3번을 이기면 " + NAME + "와의 데이트를 즐길 수 있습니다.");
        System.out.println("가위는 1번, 바위는 2번, 보는 3번을 입력하여 낼 수 있습니다.\n최선을 다해 게임을 이겨보세요!");
    }
}
