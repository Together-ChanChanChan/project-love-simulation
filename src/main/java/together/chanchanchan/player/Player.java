package together.chanchanchan.player;

public class Player {
    public String[] style = {"맨 몸", "트레이닝복", "체크남방", "후드티", "정장"};
    public String name;
    public String nowSytle = style[0];
    public int playTime = 0;

    public Player (String name){
        this.name = name;
    }
    public void changeStyle(){} // 옷 갈아 입기
}
