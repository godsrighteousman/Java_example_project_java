package com.example.maceraoyunu;

import java.lang.management.PlatformLoggingMXBean;
import java.util.Scanner;

public class Game {
    private final Scanner input =  new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz: ");
        System.out.println("-------------------------");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName=input.nextLine();
     //   input.close();

         Player player= new Player(playerName);
//     Player player= new Player("Faruk");
        System.out.println("Sayın "+player.getName()+" adaya hoşgeldin ");
        System.out.println("-------------------------");
        System.out.println("Yaşananlardan sadece sen sorumlusun ");
        System.out.println("-------------------------");
        System.out.println("Lütfen bir karakter seçin");
        player.selectChar();
        //player.selectLoc();
        Location location=null;
        while (true){
            player.printInfo();



            System.out.println("Bölgeler !");
            System.out.println("1- Güvenli ev ");
            System.out.println("2- Mağaza !");
            System.out.println("3- Mağara !--> Ödül <Yemek> mağaraya gir, dikkatli ol zombi çıkabilir ");
            System.out.println("-------------------------");
            System.out.println("4- Orman !-->  Ödül <Odun> ormana gir, dikkatli ol ayı çıkabilir" );
            System.out.println("-------------------------");
            System.out.println("5- Nehir !-->  Ödül <Su> Nehire gir, dikkatli ol Vampir çıkabilir " );
            System.out.println("-------------------------");
            System.out.println("0- çıkış yap !");
            System.out.println("-------------------------");
            System.out.println("Lütfen gitmek istdiğiniz bölgeyi seçin !");
            int selectLoc = input.nextInt();
            switch (selectLoc){

                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:

                    location=new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new Cave(player);
                    break;
                //location=new SafeHouse(player);
                default:
            }
            if (!location.onLocation())
            {
                System.out.println("GAME OVER");
                break;
            }


    }
    }
}
