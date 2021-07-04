public class Evim extends NormalLoc{
    Evim(Player player) {
        super(player, "Burası kurtarılmış bölge");
    }


    public boolean getLocation(){
        player.setSaglik(player.getCan());
        System.out.println("İyileştiniz turp gibisiniz maşallah !....");
        System.out.println("Güvenli evinizde dinlebilsiniz ama  maceraya devam etmenizi öneririz yatmaya gelmediniz lakin !!....");
        return true;
    }

}
