package together.chanchanchan.stage;

public class SampleStage extends GameController implements Game {

    public final String name = "희수";             //이름
    public final int age = 20;                 //나이
    public final String likeStyle = "트레이닝복";        //선호스타일
    public final String feature = "배고프다";          //특징, 정보 출력할 때
    public boolean isCleared;       //게임 깼는지

    @Override
    public void play() {
        checkStyle(likeStyle);
        gameStart(name);
        /*
        게
        임
        구
        현
        */
        gameEnd(name, isCleared);
    }
}
