package together.chanchanchan.stage;

import together.chanchanchan.player.Player;

public class GameController {
    //00Stage 항목에서 재사용할 수 있는 것들, 겹치는 것들 구현
    Player player = new Player();

    public boolean checkStyle(String nowStyle, String style) {
        //선호하는 스타일과 player가 착용한 옷이 일치하는지 확인
        if(nowStyle.equals(style)) return true;
        else return false;
    }

    public void gameStart(String name, String playerName) {
        System.out.println(playerName + " : 안녕? 내 이름은 " + playerName + "라고 해. 나랑 데이트 해보지 않을래? 지나가면서 봤는데 꽤 마음에 들었거든ㅎ.");
        System.out.println(name + " : 음...그럼 저랑 게임 한 판 하실래요? 이기면 저랑 데이트하는 걸로!");
    }

    public void gameEnd(String name, boolean isCleared) {
        //데이트 기회 획득 여부
        if(isCleared){
            System.out.println(name + " : 이기셨네요? 데이트 한 번 해봐요...! 다음 주에 시간 언제 괜찮으세요?");
            System.out.println("  ハ____ハ    ｡ﾟﾟ･｡･ﾟﾟ｡\n" +
                    "꒰   ⬩ ω ⬩  ꒱  ˚｡          ｡˚\n" +
                    " |   つ ~ okay　ﾟ ･｡･ﾟ\n");
        } else {
            System.out.println(name + " : 데이트는 어려울거 같아요~ 다른 사람 찾아보세요!");
            System.out.println("、ヽ｀、ヽ｀｀｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ｀、ヽ｀\n" +
                    "｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ(ノ；Д；)ノ ｀、、ヽ｀ヽ｀、ヽ｀｀、\n" +
                    "｀ヽ｀、ヽ｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽヽ｀、ヽ｀｀、ヽ｀\n");
        }


        System.out.println("~ " + name + " 라운드 종료 ~\n메뉴로 돌아갑니다.");
    }
}