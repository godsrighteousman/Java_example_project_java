package com.example.maceraoyunu;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Magaza ");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz !");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- silahlar ");
            System.out.println("-------------------------");
            System.out.println("2- zırhlar ");
            System.out.println("-------------------------");
            System.out.println("0- Çıkış yap ");
            System.out.println("-------------------------");
            System.out.println("Seçiminiz: ");
            int selectCase = input.nextInt();

            while (selectCase < 0 || selectCase > 3) {
                System.out.println("Geçersiz değer tekrar giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {

                case 1:
                    printWeapon();
                    buyWeapon();
                    break;

                case 2:
                    printArmor();
                    buyArmor();
                    break;

                case 0:
                    System.out.println("bir daha bekleriz");
                    showMenu = false;

                    break;

            }
        }

        return true;
    }

    public void printWeapon() {
        System.out.println("----------Silahlar----------");
        for (Weapon w : Weapon.wepeons()) {
            //   System.out.println(w.getId()+" - "+w.getName());
            System.out.println("id; " + w.getId() + w.getName() + " hasar: " + w.getDamage() + " Para: " + w.getPrice());


        }
        System.out.println("0 - çıkış yap ");
    }

    public void buyWeapon() {
        System.out.println("Bir silah seçin: ");

        int selectWeaponID = input.nextInt();

        while (selectWeaponID < 0 || selectWeaponID > Weapon.wepeons().length) {
            System.out.println("Geçersiz değer, Lütfen tekrar giriniz: ");
            selectWeaponID = input.nextInt();
        }


        if (selectWeaponID != 0) {
            Weapon selectedWeopen = Weapon.getWeopenObjById(selectWeaponID);


            if (selectedWeopen != null) {
                if (selectedWeopen.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("yeterli paranız bulunmuyor");
                } else {
                    System.out.println(selectedWeopen.getName() + "silahı satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedWeopen.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("-------------------------");
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeopen().getName());
                    System.out.println("-------------------------");
                    this.getPlayer().getInventory().setWeopen(selectedWeopen);
                    System.out.println("şimdiki silahınız: " + this.getPlayer().getInventory().getWeopen().getName());

                }
            }
        } else if (selectWeaponID == 0) {
            onLocation();
        }
    }
    public void printArmor() {
        System.out.println("----------Zırhlar----------");
        for (Armor a : Armor.armors()) {
            System.out.println("iD: "+ a.getId() + " - " + a.getName() + " para : " + a.getPrice() + " Fiyat : , ZIRH : " + a.getBlock() + " + " + " >");

        }
        System.out.println("0 - çıkış yap");


    }

    public void buyArmor() {
        System.out.println("Bir zırh seçin: ");

        int selectArmorID = input.nextInt();


        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Geçersiz değer, Lütfen tekrar giriniz: ");
            selectArmorID = input.nextInt();
        }


        if (selectArmorID != 0) {

            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır: ");


                }


                else {
                    System.out.println(selectedArmor.getName() + "Zırhı satın aldınız: ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(getPlayer().getMoney() + "Kadar paranız kaldı. : ");
                }

            }


        }




    }


}


