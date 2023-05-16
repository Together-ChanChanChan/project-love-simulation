package together.chanchanchan.stage;



import java.util.HashMap;
import java.util.Scanner;


public class HeesueStage extends GameController implements Game {
    public static final String NAME = "희수";
    public final int AGE = 20;
    public final String LIKESTYLE = "트레이닝복";
    public final String FEATURE = "공감적 대화의 달인, Green Lover Girl~ ";
    public boolean isCleared;
    public boolean isTry;
    @Override
    public void play(String playerName, String nowStyle) {
        Scanner sc = new Scanner(System.in);
        gameInfo();
        boolean checkStyle = checkStyle(nowStyle, LIKESTYLE);
        gameStart(NAME, playerName);

        int score = 0;
        int count = 3;
        String[] selectedGift = new String[3];
        HashMap<String, Integer> giftList = new HashMap<>();
        giftList.put("녹차초콜릿",60);
        giftList.put("숲속무드등",50);
        giftList.put("손톱깎이",45);
        giftList.put("향수", 40);
        giftList.put("곰인형", 35);
        giftList.put("안경", 30);
        giftList.put("마우스", 25);
        giftList.put("편지", 20);
        giftList.put("종이학", 15);
        giftList.put("아이맥스", 10);

        if(checkStyle){
            score += 10;
            System.out.println(NAME + "가 당신의 스타일을 좋아한다고 하네요! (+ 10점 )");
        }

        System.out.println("리스트 목록");
        System.out.print("[");
        for (String s : giftList.keySet()){
            System.out.print(" " + s +",");
        }
        System.out.println("]");


        while(count > 0){
            System.out.println("선물 세 가지를 골라 입력하세요.");
            System.out.println("첫번째 선물 : ");
            selectedGift[0] = sc.nextLine();
            System.out.println("두번째 선물 : ");
            selectedGift[1] = sc.nextLine();
            System.out.println("세번째 선물 : ");
            selectedGift[2] = sc.nextLine();

           if(giftList.containsKey(selectedGift[0]) && giftList.containsKey(selectedGift[1]) && giftList.containsKey(selectedGift[2])){
               score += giftList.get(selectedGift[0]);
               score += giftList.get(selectedGift[1]);
               score += giftList.get(selectedGift[2]);

               if(score >= 100) {
                   isCleared = true;
                   break;
               }else {
                   System.out.println(NAME + ": 센스가 좀..;;");
                   System.out.println(NAME + ": 다시 도전해 보세요");
                   System.out.println("당신의 점수 : " + score);
                   count--;
                   if (count == 0){
                       break;
                   }
               }
           } else {
               System.out.println("목록 내의 선물을 입력해주세요");
           }
        }
        System.out.println("당신의 점수 : " + score);
        gameEnd(NAME, isCleared);
        isTry = true;
    }

    @Override
    public void printGirlInfo() {
        System.out.println("printGirlInfo method 호출...");
        System.out.println("요즘 주변 나무들도 초록초록하고~ 내 초록가디건도 맘에 들고~");
        System.out.println("엇..! 사람이 있었네");
        System.out.println("안녕하세요~ 제 이름은 " + NAME + "입니다! 전 초록색을 좋아해요~");
        System.out.println("개인적으로는 '트레이닝복' 입은 사람한테도 끌리더라고요!");
        System.out.println("아~ 대화가 잘 통해서 저랑 상담을 하고 싶으시구나~");
        System.out.println("저는 사람 심리보다 컴퓨터 로직이 더 재밌어서 이만^^;;");
        System.out.println("=======" + NAME + "의 특징 =======");
        System.out.println(FEATURE);
    }

    @Override
    public void gameInfo() {
        System.out.println("gameInfo method 호출...");
        System.out.println("======" + NAME + "STAGE 게임 소개 ======");
        System.out.println("이번 스테이지는 '선물하기'입니다.");
        System.out.println("미리 " + NAME + "가 작성한 총 10개의 선물 리스트가 주어집니다.");
        System.out.println(NAME + "가 가지고 싶은 선물순으로 높은 점수가 매겨져 있다고 하네요!");
        System.out.println("총 3번의 선택으로 100점을 넘겨야 이 게임에서 이기게 됩니다.");
        System.out.println("만약 " + NAME + "가 선호하는 스타일로 입고 있다면 기본점수 10점이 추가됩니다!");
        System.out.println("최선을 다해 게임을 이겨보세요!");
        System.out.println();
    }
}
