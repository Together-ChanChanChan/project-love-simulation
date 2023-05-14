package together.chanchanchan.player;

import java.util.Scanner;

public class Player {
    public String[] style = {"맨 몸", "트레이닝복", "체크남방", "후드티", "정장"};
    public String name;
    public String nowStyle = style[0];
    public int playTime = 0;

    public Player (String name){
        this.name = name;
    }
    public void changeStyle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("====== 옷 갈아입기 ======");
        System.out.println("1. 맨몸");
        System.out.println("2. 츄리닝");
        System.out.println("3. 체크남방");
        System.out.println("4. 후드티");
        System.out.println("5. 정장");
        System.out.println("=======================");
        System.out.println("번호를 입력하세요 : ");
        int selectedStyle = sc.nextInt();
        
        while (true){
            if(selectedStyle >=1 && selectedStyle <6){
                this.nowStyle = this.style[selectedStyle];
            } else {
                System.out.println("1~6 범위의 숫자를 입력하세요. ");
                break;
            }
        }
    } // 옷 갈아 입기
}
