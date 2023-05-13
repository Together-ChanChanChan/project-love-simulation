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

    public void gameStart() {
        System.out.println("내 이름은 " + player.name + ", 복학생이죠.\n세상의 모든 여자를 내 것으로 만들어주겠어...");    //플레이어 소개
    }

    public void gameEnd(String name, boolean isCleared) {
        //데이트 기회 획득 여부
        if(isCleared)
            System.out.println(name + "와의 데이트 기회를 획득하셨습니다!");
        else
            System.out.println(name + "와의 데이트 기회 얻기 실패! 다른 사람을 공략해보세요.");
    }
}
