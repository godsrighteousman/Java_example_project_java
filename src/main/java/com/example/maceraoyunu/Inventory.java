package com.example.maceraoyunu;

public class Inventory {

    private Weapon weopen;
//    private int weopenDemage;
 //   private String weopenName;
    private Armor armor;
public Inventory() {
    this.weopen=new Weapon("yumruk",-1,0,0);
    this.armor=new Armor(-1,"pacavra",0,0);

}

    public Weapon getWeopen() {
        return weopen;
    }

    public void setWeopen(Weapon weopen) {
        this.weopen = weopen;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}



    //  public Inventory(int weopenDemage, String weopenName) {

   /*     this.weopenDemage = 0;
        this.weopenName = "Yumruk";
    }
}
*/
