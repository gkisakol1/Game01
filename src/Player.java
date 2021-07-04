import java.util.Scanner;

public class Player {
    protected int hasar,saglik,para, can;
    protected String isim,kIsim;
    Inventory inv;
    Scanner scan= new Scanner(System.in);

    public Player(String isim) {
        this.isim = isim;
        this.inv=new Inventory();

    }



    public void karakterSec(){
        switch (karMenu()){
            case 1:
              olstrPlayer("Samuray",5,21,15);break;

            case 2:
               olstrPlayer("Okçu",7,18,20);break;

            case 3:
               olstrPlayer("Şövalye",8,24,5);break;

            default:
                olstrPlayer("Samuray",5,21,15);break;

        }

        System.out.println("Karakter Olusturuldu ! " + "\nİsim : " + getkIsim() + "\t Hasar : " + getHasar() + "\t Saglık : " + getSaglik() + "\t Para : " + getPara() );

    }


    public int karMenu (){
        System.out.println(" Bir karakter seçiniz  ");
        System.out.println(" 1- Samuray \t Hasar : 5 \t Saglik : 21 \t Para : 15 ");
        System.out.println(" 2- Okçu    \t Hasar : 7 \t Saglik : 18 \t Para : 20 ");
        System.out.println(" 3- Şövalye \t Hasar : 8 \t Saglik : 23 \t Para : 5 ");

        System.out.println("Karakter Seçiminiz : ");
        int karID = scan.nextInt();

        while (karID <1 || karID >3 ){

            System.out.println(" Lütfen geçerli bir karakter numarası giriniz.. ");
            karID= scan.nextInt();
        }
         return karID;
    }


    public void olstrPlayer(String kIsim, int hsr, int saglk, int para){
        setkIsim(kIsim);
        setHasar(hsr);
        setSaglik(saglk);
        setPara(para);
        setCan(saglk);
    }



    public int getTotalHasar(){
        return this.getHasar()+this.getInv().getHasar();
    }

    public int getHasar() {
        return hasar;
    }

    public void setHasar(int hasar) {
        this.hasar = hasar;
    }

    public int getSaglik() {
        return saglik;
    }

    public void setSaglik(int saglik) {
        this.saglik = saglik;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getkIsim() {
        return kIsim;
    }

    public void setkIsim(String kIsim) {
        this.kIsim = kIsim;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }
}
