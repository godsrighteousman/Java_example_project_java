package com.example.maceraoyunu;

import java.security.PrivateKey;
import java.util.Scanner;

public class Player  {


    private int damage;

    private  int health;
    private int orjHealth;
    private  int money;
    private  String name;
    private String charName;
    //    private final
   private  Scanner input = new Scanner(System.in);

   private Inventory inventory;
   private Armor armor;







    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory();

    }
    public void  selectChar(){

        // Samurai samurai=new Samurai();
        //  Knight knight=new Knight();
        //  Archer archer=new Archer();

        GameChar[] charlist={new Samurai(),new Archer(),new Knight()};
        System.out.println(" Karakterler: ");
        System.out.println(" -------------------------------- ");
        for (GameChar gameChar : charlist)
        {
            System.out.println("ID: "+ gameChar.getId() +
                    " \t\t karekter:  " +gameChar.getName()+
                    " \t\t hasar; " +gameChar.getDamage()   +
                    " \t\t sağlık; " + gameChar.getHealth() +
                    " \t\t  para; " + gameChar.getMoney());

        }




        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("Lütfen bir karakter seçiniz");




        int selectChar = input.nextInt();
        // int neden olmuyo
        // System.out.println(selectChar); //log test
        switch (selectChar){
            case 1:
                // GameChar testSamuraiChar = new Samurai();
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

     //   System.out.println( " Karakter : ," + this.getCharName()+ " hasar : ,"+ this.getDamage()+" sağlık ,"+this.getHealth()+" para ,"+this.getMoney());
    }
    //CHARNAMME NEDEN NULL DÖNÜYOR İD DOĞRU ÇALIŞIYOR


    public void initPlayer(GameChar gameChar){

        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setOrjHealth((gameChar.getHealth()));
        this.setCharName(gameChar.getName());

    }
    public void printInfo()
    {
        System.out.println(
                "Silahınız"+ this.getInventory().getWeopen().getName()+
                        "Zırh : " +this.getInventory().getArmor().getName()+
                        "Bloklama : " +this.getInventory().getArmor().getBlock()+
                        " hasarınız : ," + this.getTotalDemage()+
                        " sağlık ,"+this.getHealth() +
                        " para ,"+this.getMoney()
                      );

    }

public int getTotalDemage(){
        return damage + this.getInventory().getWeopen().getDamage();

}
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeopen(); //battle
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }
}
