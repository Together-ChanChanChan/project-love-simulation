package together.chanchanchan.view;

import together.chanchanchan.player.Player;
import together.chanchanchan.stage.*;

import java.util.Scanner;

public class Menu {
    DaheeStage dahee = new DaheeStage();
    HyunjiStage hyunji = new HyunjiStage();
    HeesueStage heesue = new HeesueStage();
    ChanheeStage chanhee = new ChanheeStage();
    Scanner sc = new Scanner(System.in);
    String setName;
    Player player = new Player();
    private boolean checkGameSet;
    public void mainMenu() {
        int menu;

        do {
            System.out.println("====== 복학생 연애 시뮬레이션 ======");
            System.out.println("1. 게임 설정하기");
            System.out.println("2. 여학생 정보 보기");
            System.out.println("3. 현재 내 캐릭터 상태 보기");
            System.out.println("4. 옷 갈아입기");
            System.out.println("5. 게임 시작하기");
            System.out.println("6. 게임 끝내기");
            System.out.println("==============================");
            System.out.print("메뉴 선택하기 : ");
            menu = sc.nextInt();

            switch (menu) {
                case 1 :
                    gameSet();
                    break;
                case 2 :
                    viewGirlInfoMenu();
                    break;
                case 3 :
                    viewMyInfo();
                    break;
                case 4 :
                    changeClothes();
                    break;
                case 5 :
                    checkStart();
                    break;
                case 6 :
                    checkEnd();
                    break;
                default:
                    System.out.println("일치하지 않는 번호입니다.");
                    break;
            }
        } while(true);
    }

    public void gameSet() {
        if (!checkGameSet){
            sc.nextLine();
            System.out.println("??? : 안녕? 넌 처음보는 얼굴인데, 이름이 뭐니?");
            System.out.print("이름을 입력해주세요 : ");
            setName = sc.nextLine();
            while (setName.length() == 0) {
                System.out.println("이름이 입력되지 않았습니다.");
                System.out.println("설정할 이름을 다시 입력해 주세요 : ");
                setName = sc.nextLine();
            }
            checkGameSet = true;
            System.out.println("??? : 우리 학교는 정말 매력적인 친구들이 많아, 꼭 데이트 성공하길 바래 0_<");
            System.out.println("게임 초기 설정이 완료되었습니다.");
        } else {
            System.out.println(setName + ", 이미 초기 설정이 끝났어!");
        }
    }

    private void viewGirlInfoMenu() {
        if (checkGameSet) {
            do {
                System.out.println("====== 여학생 정보 보기 ======");
                System.out.println("1. 다희의 정보 보기");
                System.out.println("2. 현지의 정보 보기");
                System.out.println("3. 희수의 정보 보기");
                System.out.println("4. 찬희의 정보 보기");
                System.out.println("5. 이전 메뉴로 돌아가기");
                System.out.println("==========================");
                System.out.print("번호를 입력하세요 : ");
                int menu = sc.nextInt();

                switch (menu) {
                    case 1 :
                        dahee.printGirlInfo();
                        break;
                    case 2 :
                        hyunji.printGirlInfo();
                        break;
                    case 3 :
                        heesue.printGirlInfo();
                        break;
                    case 4 :
                        chanhee.printGirlInfo();
                        break;
                    case 5 :
                        return;
                    default:
                        System.out.println("일치하지 않는 번호입니다.");
                        break;
                }
            } while(true);
        } else {
            System.out.println("주의! 게임 설정을 하지 않으면 플레이를 할 수 없습니다!");
        }
    }

    private void viewMyInfo() {
        if(checkGameSet) {
            System.out.println("====== 나의 현재 정보 보기 ======");
            System.out.println("착용한 옷 : " + player.nowStyle);
            System.out.println("여학생 공략 횟수 : " + player.playTime);
        } else {
            System.out.println("주의! 게임 설정을 하지 않으면 플레이를 할 수 없습니다!");
        }
    }

    private void changeClothes() {
        if (checkGameSet) {
            player.changeStyle();
        } else {
            System.out.println("주의! 게임 설정을 하지 않으면 옷을 갈아입을 수 없습니다!");
        }
    }

    private void checkStart() {
        if (checkGameSet && player.playTime < 4) {
            do {
                System.out.println("====== 여학생 선택하기 ======");
                System.out.println("1. 다희");
                System.out.println("2. 현지");
                System.out.println("3. 희수");
                System.out.println("4. 찬희");
                System.out.println("5. 이전 메뉴로 돌아가기");
                System.out.println("==========================");
                System.out.print("번호를 입력하세요 : ");
                int menu = sc.nextInt();

                switch (menu) {
                    case 1 :
                        if(dahee.isTry) {
                            System.out.println("미안," + dahee.NAME + "를 꼬시는 건 한 번밖에 시도할 수 없어");
                        } else {
                            dahee.play(setName, player.nowStyle);
                            // setName : 플레이어가 설정한 이름, player.nowStyle 플레이어가 현재 착용한 옷 상태
                            player.playTime++;
                            // 게임 끝나면 플레이 횟수 증가
                        }
                        break;
                    case 2 :
                        if(hyunji.isTry) {
                            System.out.println(hyunji.NAME + "와 데이트를 더 하고 싶겠지만, 한 번밖에 시도할 수 없어");
                        } else {
                            hyunji.play(setName, player.nowStyle);
                            player.playTime++;
                        }
                        break;
                    case 3 :
                        if(heesue.isTry) {
                            System.out.println(heesue.NAME +"를 또 보고 싶구나? 하지만, 기회는 한 번 뿐이었어");
                        } else {
                            heesue.play(setName, player.nowStyle);
                            player.playTime++;
                        }
                        break;
                    case 4 :
                        if(chanhee.isTry) {
                            System.out.println("숫자 맞추는 게 재미있었지? 그치만, " + chanhee.NAME +"와 게임은 한 번밖에 할 수 없어");
                        } else {
                            chanhee.play(setName, player.nowStyle);
                            player.playTime++;
                        }
                        break;
                    case 5 :
                        return;
                    default:
                        System.out.println("일치하지 않는 번호입니다.");
                        break;
                }
            } while (true);
        } else if (!checkGameSet){
            System.out.println("주의! 게임 설정을 하지 않으면 플레이를 할 수 없습니다!");
        } else if (player.playTime == 4) {
            System.out.println("모든 플레이어와 게임을 진행하였습니다.");
        }
    }

    private void checkEnd() {
        do {
            System.out.print("게임을 종료하시겠습니까? (예 : y / 아니오 : n) : ");
            String check = sc.next();
            sc.nextLine();

            switch (check) {
                case "y" :
                case "Y" :
                    System.out.println("====== 게임을 종료합니다. ======");
                    System.exit(0);
                    break;
                case "n" :
                case "N" :
                    System.out.println("===== 이전 메뉴로 돌아갑니다. ======");
                    return;
                default:
                    System.out.println("일치하지 않는 문자입니다.");
            }
        } while(true);
    }
}
