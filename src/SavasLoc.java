

public abstract class SavasLoc extends Location {
    protected Canavar cav;
    protected String odul;

    SavasLoc(Player player, String name, Canavar cav, String odul) {
        super(player);
        this.name = name;
        this.cav = cav;
        this.odul = odul;

    }

    public boolean getLocation() {
        int canRndm = cav.sayac();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli olun !  Burada " + canRndm + " tane " + cav.getIsim() + " tehlikesiyle karşı karsıyasınız ..!!");
        System.out.println("<T>amam mı <D>evam mı :");
        String secTus = scan.nextLine();
        // secTus=secTus.toUpperCase();
        if (secTus.toUpperCase().equals("D")) {
            if (erMeydani(canRndm)) {
                System.out.println(this.getName() + "Bölge düşmanlardan temizlendi tebrikler !");
                if (this.odul.equals("Yemek")) {
                    System.out.println(" Yemek Kazandınız !");
                    player.getInv().setYiyecek(true);
                } else if (this.odul.equals("Su")) {
                    System.out.println(" Su Kazandınız !");
                    player.getInv().setSu(true);

                } else if (this.odul.equals("Odun")) {
                    System.out.println(" Odun Kazandınız !");
                    player.getInv().setOdun(true);
                }
                return true;
            }
            if (player.getSaglik() <= 0) {
                System.out.println("Öldünüz... Allah rahmet eylesin !");
            }
        }
        return true;
    }

    public boolean erMeydani(int canRndm) {

        for (int i = 0; i < canRndm; i++) {
            int sonCevSaglik= cav.getSaglik();
            playerDurumu();
            canavarDurumu();

            while (player.getSaglik() > 0 && cav.getSaglik() > 0) {
                System.out.println("<S>aldır veya <T>opukla :");
                String secDurum = scan.nextLine();

                if (secDurum.toUpperCase().equals("S")) {
                    System.out.println("Siz saldırdınız ! Ooooo  Çok sert girdiniz !");
                    cav.setSaglik(cav.getSaglik() - player.getTotalHasar());
                    saldiriSonrasiDurum();

                }

                if (cav.getSaglik() > 0) {
                    System.out.println();
                    System.out.println("Canavar size saldırdı ! Ooooo  Çok sert bir darbe aldınız !");
                    player.setSaglik(player.getSaglik() - (cav.getHasar() - player.getInv().getZirh()));

                } else {
                    return false;
                }

                if (cav.getSaglik() < player.getSaglik()) {
                    System.out.println(cav.getIsim() + "  yendiniz, Tebrikler !");
                    player.setPara(player.getPara() + cav.getPara());
                    System.out.println("Güncel Paranız :" + player.getPara());
                    cav.setSaglik(sonCevSaglik);

                } else {
                    return false;
                }
            }
            System.out.println("-------------------------");
        }
        return  true;
    }

    public void playerDurumu (){
        System.out.println("Oyuncunun Son Degerleri\n.........");
        System.out.println("Sağlık :" + player.getSaglik());
        System.out.println("Hasar  :" + player.getHasar());
        System.out.println("Para   :" + player.getPara());
        if (player.getInv().getHasar()>0){
            System.out.println("Silah :" + player.getInv().getSilahAdi());
        }
        if (player.getInv().getZirh()>0){
            System.out.println("Zırh :" + player.getInv().getZirhAdi());
        }

    }
    public void canavarDurumu () {
        System.out.println("\n" +cav.getIsim() + " Son Degerleri\n.........");
        System.out.println("Sağlık :" + cav.getSaglik());
        System.out.println("Hasar  :" + cav.getHasar());
        System.out.println("Para   :" + cav.getPara());


    }

    public void saldiriSonrasiDurum (){
        System.out.println("Oyuncunun Kalan Canı :" + player.getSaglik());
        System.out.println(cav.getIsim() + "Canı :" + cav.getSaglik());
        System.out.println();
    }


}



