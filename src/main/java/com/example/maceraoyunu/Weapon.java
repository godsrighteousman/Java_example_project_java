package com.example.maceraoyunu;

public class Weapon {
    private String name;
    private int id;
    private int damage;

    private int price;

    public Weapon(String name,int id, int damage, int price) {
        this.name=name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] wepeons() {
      //  return new Weapon[];
        Weapon[] weaponList = new Weapon[3];


        weaponList[0]=new Weapon("Tabanca",1,12,5);
        weaponList[1]=new Weapon("bomba",2,10,16);
        weaponList[2]=new Weapon("lazar silahı",3,14,10);

        return  weaponList;

          //      {new Weapon((1, 2, 123))};

      //  return weapons;

    }

    public  static Weapon getWeopenObjById(int id){
        for (Weapon w:Weapon.wepeons()){
            if (w.getId()==id){
                return  w;
            }
        }return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
