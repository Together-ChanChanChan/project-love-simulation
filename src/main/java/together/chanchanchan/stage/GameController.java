package together.chanchanchan.stage;

import together.chanchanchan.player.Player;

public class GameController {
    //00Stage 항목에서 재사용할 수 있는 것들, 겹치는 것들 구현
    Player player = new Player("player1");

    public boolean checkStyle(String style) {
        //선호하는 스타일과 player가 착용한 옷이 일치하는지 확인
        if(player.nowSytle.equals(style))
            return true;
        else
            return false;
    }

    public void gameStart(String name) {
        System.out.println(player.name + " : 안녕? 내 이름은 " + player.name + "라고 해. 나랑 데이트 해보지 않을래? 지나가면서 봤는데 꽤 마음에 들었거든ㅎ.");
        System.out.println(name + " : 음...그럼 저랑 게임 한 판 하실래요? 이기면 저랑 데이트하는 걸로!");
    }

    public void gameEnd(String name, boolean isCleared) {
        //데이트 기회 획득 여부
        if(isCleared)
            System.out.println(name + " : 이기셨네요? 데이트 한 번 해봐요...! 다음 주에 시간 언제 괜찮으세요?");
        else
            System.out.println(name + " : 데이트는 어려울거 같아요~ 다른 사람 찾아보세요!");

        System.out.println("~ " + name + " 라운드 종료 ~\n메뉴로 돌아갑니다.");
    }
}
