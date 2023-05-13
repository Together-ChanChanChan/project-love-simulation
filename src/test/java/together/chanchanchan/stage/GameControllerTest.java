package together.chanchanchan.stage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import together.chanchanchan.player.Player;

public class GameControllerTest {

    Player player = new Player("player1");
    GameController gc = new GameController();

    @DisplayName("플레이어가 착용한 옷과 상대의 선호 스타일이 일치하는지 확인")
    @Test
    public void testCheckStyle() {

        String style = "맨 몸";
        boolean result = gc.checkStyle(style);

        style = "트레이닝복";
        result = gc.checkStyle(style);
    }

    @DisplayName("gameStart method 호출 확인")
    @Test
    public void testGameStart() {

        gc.gameStart();
    }

    @DisplayName("gameEnd method 호출 확인")
    @Test
    public void testGameEnd() {

        gc.gameEnd("test", false);

        gc.gameEnd("test", true);
    }
}
