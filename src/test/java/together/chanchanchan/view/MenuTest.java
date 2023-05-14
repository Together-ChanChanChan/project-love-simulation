package together.chanchanchan.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class MenuTest {

    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);

    @DisplayName("게임 초기 설정을 하지 않았을 때 메인 메뉴로 돌아가는지 확인")
    @Test
    public void GirlInfoMenuTest() {

        menu.mainMenu();
    }
}
