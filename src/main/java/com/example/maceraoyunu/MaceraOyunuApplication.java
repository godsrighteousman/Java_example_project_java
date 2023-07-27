package com.example.maceraoyunu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaceraOyunuApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaceraOyunuApplication.class, args);


       // Samurai s= new Samurai();
        //System.out.println(s.getDamage());

        Game game=new Game();
        game.start();



    }

}
//Bölüm 4 dakika 17.10