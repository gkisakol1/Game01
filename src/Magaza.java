
public class Magaza extends NormalLoc {


    Magaza(Player player) {
        super(player, "Silah Magazasındasınız..!");
    }




    public boolean getLocation() {
        System.out.println(player.getkIsim() + " Karakterinin  Parası : " + player.getPara());
        System.out.println("1. Silahlar ");
        System.out.println("2. Zırhlar ");
        System.out.println("3. Çıkış ");
        System.out.println("Seçiminiz : ");
        int secim = scan.nextInt();
        int scmSilahID;
        int scmZirhAl;




        switch (secim) {
            case 1:
                scmSilahID = silahMenu();
                silahSatinAl(scmSilahID);
                break;
            case 2:
                scmZirhAl = zirhMenu();
                zirhSatinAl(scmZirhAl);
                break;
            case 3:
                System.out.println(" Demek gidiyorsun seni özlicazz byee");
                break;
        }
        return true;
    }


    public int zirhMenu() {
        System.out.println("1. Hafif \t  Para : 5  - Hasar : 1");
        System.out.println("2. Orta \t  Para : 10 - Hasar : 3");
        System.out.println("3. Ağır \t  Para : 20 - Hasar : 5");
        System.out.println("4. Çıkış..");
        System.out.print("Zırh Seçiniz : ");
        int zirhNo = scan.nextInt();
        return zirhNo;
    }

    public void zirhSatinAl(int malzmNo) {
        int zirh = 0, para = 0;
        String zirhAdi = null;
        switch (malzmNo) {
            case 1:
                zirh = 1;
                zirhAdi = "Hafif Zırh";
                para = 5;
                break;
            case 2:
                zirh = 3;
                zirhAdi = "Orta Zırh";
                para = 10;
                break;
            case 3:
                zirh = 5;
                zirhAdi = "Ağır Zırh";
                para = 20;
                break;
            case 4:
                System.out.println("Çıkış..");
                break;
            default:
                System.out.println("Geçersiz İşlem.. !");
                break;
        }

        if (para > 0) {
            if (player.getPara() >= para) {
                player.getInv().setZirh(zirh);
                player.getInv().setZirhAdi(zirhAdi);
                player.setPara(player.getPara() - para);
                System.out.println(zirhAdi + " satın aldınız...  Engellenen Hasar : " + player.getInv().getZirh());
                System.out.println("Kalan Paranız :" + player.getPara());
            } else {
                System.out.println("Yetersiz Bakiye... !");
            }
        }
    }

    public int silahMenu() {
        System.out.println("1. Tabanca\t    Para :  5 - Hasar : 2");
        System.out.println("2. Kılıç\t    Para :  8 - Hasar : 3");
        System.out.println("3. Tüfek\t    Para : 12 - Hasar : 7");
        System.out.println("4. Çıkış");
        System.out.print("Silah Seçiniz  : ");
        int slhNo = scan.nextInt();
        return slhNo;
    }

    public void silahSatinAl(int malzmNo) {
        int hasar = 0, para = 0;
        String silahAdi = null;

        switch (malzmNo) {
            case 1:
                hasar = 2;
                silahAdi = "Tabanca";
                para = 5;
                break;
            case 2:
                hasar = 3;
                silahAdi = "Kılıç";
                para = 8;
                break;
            case 3:
                hasar = 7;
                silahAdi = "Tüfek";
                para = 12;
                break;
            case 4:
                System.out.println("Çıkış..");
                break;
            default:
                System.out.println("Geçersiz işlem  !");
                break;
        }

        if (para > 0) {
            if (player.getPara() > para) {
                player.getInv().setHasar(hasar);
                player.getInv().setSilahAdi(silahAdi);
                player.setPara(player.getPara() - para);
                System.out.println(silahAdi + " satın aldınız...  Önceki Hasar : " + player.getHasar() + ", Yeni Hasar : "
                        + player.getHasar());
                System.out.println("Kalan Paranız :" + player.getPara());
            } else {
                System.out.println("Yetersiz Bakiye.... !");
            }
        }
    }


}

