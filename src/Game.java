import java.util.Scanner;

public class Game {
    Player player;
    static Location location=new Location() {
        @Override
        public boolean getLocation() {  // static canlı kalması ıcın tek deger
            return false;
        }
    };

    Scanner scan=new Scanner(System.in);

    public void giris() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Şimdi Oyun Zamanı..!");
        System.out.print("İsminizi giriniz :  ");
        String playerIsim = scan.nextLine();
        player = new Player(playerIsim);
        player.karakterSec();
        start();

    }
        public void start () {
            while (true) {
                System.out.println("--------------------");
                System.out.println("Paranız : " + player.getPara() +  " Hasar : " + player.getHasar());
                System.out.println("1. Güvenli Ana Evi -->  Güveli Mekan burda düşman yok ! ");
                System.out.println("2. Mağara --> Dikkat Zombi çıkabilüüür ! ");
                System.out.println("3. Orman --> Dikkat Vampir çıkıp sizi yiyebilüüür ! ");
                System.out.println("4. Nehir --> Dikkat Timsah ısırabilüüür !");
                System.out.println("5. Mağaza --> Burdan gerekli levazımatı tedarik edebilirsüün !");
                System.out.println("6. Çıkış  --> Hayatta kaldığın için şanslısın ! ");
                System.out.println("Gitmek istediğiniz yer : ");
                int sec = scan.nextInt();
                while (sec < 0 || sec > 6) {
                    System.out.println("Geçerli bir sayı giriniz");
                    sec = scan.nextInt();

                }
                switch (sec) {
                    case 1:
                        location = new Evim(player);
                        break;
                    case 2:
                        location = new Magara(player);
                        break;
                    case 3:
                        location = new Orman(player);
                        break;
                    case 4:
                        location = new Nehir(player);
                        break;
                    case 5:
                        location = new Magaza(player);
                        break;
                    case 6:
                        System.out.println("TSCHüß.... Seninle savaşmak bir keyifti..");
                        location=new Location() {
                            @Override
                            public boolean getLocation() {
                                return false;
                            }
                        };
                      break;
        //               default:
        //                break;
                }

               if (!location.getLocation() || sec==6 ) {
                   System.out.println("Yeni maceralarda görüşmek üzere !!");
                   break;
               }

            }
    }
        }
