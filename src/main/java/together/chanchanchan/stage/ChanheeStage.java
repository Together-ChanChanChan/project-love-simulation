package together.chanchanchan.stage;

import java.util.Scanner;

public class ChanheeStage extends GameController implements Game {

    public static final String NAME = "찬희";             //이름
    public final int AGE = 21;                           //나이
    public final String LIKESTYLE = "후드티";             //선호스타일
    public final String FEATURE = "보라색 맛 났어!";     //특징, 정보 출력할 때
    public boolean isCleared;                            //게임 깼는지
    public boolean isTry;

    int chance = 8;

    @Override
    public void play(String playerName, String nowStyle) {
        boolean checkStyle = checkStyle(nowStyle, LIKESTYLE);
        gameStart(NAME, playerName);
        gameInfo();
        Scanner sc = new Scanner(System.in);

        // 베이스볼 게임 시작
        String answer = "prince";     //정답 단어
        if(checkStyle){
            System.out.println("후드티가 마음에 들어서 하는 말은 아닌데, 첫 알파벳은 'p'야.");
        }
        while (chance > 0) {
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
                chance--;
            } else {
                String message = "";
                if (strike > 0) {
                    message += strike + "스트라이크";
                    chance--;
                }
                if (ball > 0) {
                    message += ball + "볼";
                    chance--;
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
        gameEnd(NAME, isCleared);
        isTry = true;
    }

    @Override
    public void printGirlInfo() {
        System.out.println("안녕? 나는 " + NAME + "라고 해. 만나서 반가워!");
        System.out.println("나는 "+ AGE + "살이야. 어려 보인다구? ㅎㅎ 너 좀 맘에 든다?");
        System.out.println("나는 " + LIKESTYLE + "를 좋아해. 특히 보라색 " + LIKESTYLE + "가 좋아.");
        System.out.println("보라색은 정말 생각만 해도 기분이 좋아져!");
        System.out.println("게임은 잘 안 하는데, " + FEATURE + "라는 대사가 맘에 들어서 관심이 좀 생겼어.");
        System.out.println("나랑 게임 해서 맞추면 한 번 만나줄게.");
    }

    @Override
    public void gameInfo() {
        System.out.println("======" + NAME + "STAGE 게임 소개 ======");
        System.out.println("베이스볼 게임 들어봤어?");
        System.out.println("8글자의 알파벳 단어를 맞추는 게임이야.");
        System.out.println("네가 8개의 단어를 입력해서 알파벳만 맞추면 볼, 알파벳과 자리를 모두 맞추면 스트라이크로 힌트를 줄게");
        System.out.println("모두 맞추면 홈런, 정답이야. 기회는 총 8번!!\n 그럼 단어를  입력해줘!");
    }
}
