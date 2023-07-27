package com.example.maceraoyunu;

import java.util.Random;

public abstract class BattleLoc extends Location{

private Obstacle obstacle;
private String award;
private  int maxObstacle;



    public BattleLoc(Player player, String name, Obstacle obstacle, String award,int maxObstacle){


        super(player,name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle = maxObstacle;
    }
    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol Burada  : " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor! ");

        System.out.println("<S>avaş veya <K>aç");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")&& combat(obsNumber)) {
            System.out.println("Savaş işlemleri olacak");
            if (combat((obsNumber))) {
                System.out.println(this.getName() + "tüm düşmanları yendiniz.");
                return true;
            }}
            //savas işilemleri
            if (this.getPlayer().getHealth() < 0) {
                System.out.println("Öldünüz");
                return false;

            }
            return true;

    }




    public boolean combat(int obsNumber){

        for (int i=1; i<=obsNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStates(i);
            while (this.getPlayer().getHealth()>0 && getObstacle().getHealth()>0){
                System.out.println("<V>ur veya <K>aç");
                String selectCombat=input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz");

                  this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDemage());
                  afterHit();
                  if (this.getObstacle().getHealth()>0){
                      System.out.println();
                      System.out.println("Canavar size vurdu");
                      int obstacleDemage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();

                      if (obstacleDemage<0){
                          obstacleDemage=0;
                      }
                      this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDemage);
                      afterHit();

                  }
                }
                else{
                    return false;
                }

            }
            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz. ");
                System.out.println( this.getObstacle().getAward()+" ödülünü kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel paranız "+ this.getPlayer().getMoney());


            }
            else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız :"+ getPlayer().getHealth());
        System.out.println(getObstacle().getName()+" Canı: "+ getObstacle().getHealth());
        System.out.println("-------------------------");
    }




    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("-------------------");
        System.out.println("Sağlık "+this.getPlayer().getHealth());
        System.out.println("Silah: "+ this.getPlayer().getWeapon().getName());// getWeapon ile getInventory().getWeopen() kısalttık plaeer içinde
        System.out.println("Zırh: "+ this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blok: "+ this.getPlayer().getInventory().getArmor().getBlock());

        System.out.println("Hasar"+this.getPlayer().getTotalDemage());
        System.out.println("Para "+this.getPlayer().getMoney());
    }
    public void obstacleStates(int i){
        System.out.println(i+ ". "+ this.getObstacle().getName()+" Değerleri");
        System.out.println("-------------------");
        System.out.println("-------------------");
        System.out.println("Sağlık "+ this.getObstacle().getHealth());
        System.out.println("Hasar "+ this.getObstacle().getDamage());
       // System.out.println("Sağlık "+ this.getObstacle().getHealth());
        System.out.println("Ödül"+ this.getObstacle().getAward());
    }
    public int randomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}

