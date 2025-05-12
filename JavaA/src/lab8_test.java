public class lab8_test {
    public static void main(String[] args) {
        lab8_GameSystem gs = new lab8_GameSystem();
        lab8_Player p1 = new lab8_Player("Zhangsan");
        lab8_Player p2 = new lab8_Player("Lisi");
        lab8_Player p3 = new lab8_Player("Wangwu");
        System.out.println(lab8_Player.getPlayerCnt());

        gs.addPlayer(p1);
        gs.addPlayer(p3);

        System.out.println(gs.checkPlayer(1));
        System.out.println(gs.checkPlayer(2));
        System.out.println(gs.checkPlayer(3));
        System.out.println(gs.getPlayerList());
    }
}
