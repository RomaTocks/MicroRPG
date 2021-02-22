package com.Tocks.Shop;

import com.Tocks.Color.Color;
import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.Warrior.Warrior;
import com.Tocks.Inheritance.Warrior.Weapon;
import com.Tocks.Menu.Menu;

import java.util.Scanner;

public class Shop
{
    public static void Menu(Character character)
    {
        System.out.println(Color.ANSI_BLUE + "\"О, поглядите-ка кто к нам заглянул, очередной \"ГЕРОЙ\",\n ну давай, купи уже что-нибудь, если денег хватит." + Color.ANSI_RESET);
        System.out.println("Выберите магазин:\n");
        System.out.println("1. Аптека\n");
        if(character instanceof Warrior)
        {
            System.out.println("2. Оружейная");
        }
        System.out.println("3. Покинуть\n");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        if(scanner.hasNextInt())
        {
            choice = scanner.nextInt();
        }
        switch (choice)
        {
            case 1:
            {
                pharmacyBuy(character);
                break;
            }
            case 2:
            {
                if(character instanceof Warrior)
                {
                    warriorBuy((Warrior)character);
                }
            }
            case 3:
            {
                break;
            }
            default:
            {
                Menu(character);
            }
        }
    }
    public static void pharmacyBuy(Character character)
    {
        pharmacyList();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        if(scanner.hasNextInt())
        {
            choice = scanner.nextInt();
        }
       switch (choice)
       {
           case 1:
           {
               if (character.getCoins() >= 25)
               {

                   character.setCountOfHealthPacks(character.getCountOfHealthPacks() + 1);
                   character.setCoins(character.getCoins()-25);
                   System.out.println("Куплено!");
                   System.out.println("Теперь вы имеете хилочек: " + character.getCountOfHealthPacks());
                   System.out.println("Теперь денег: " + character.getCoins());
                   pharmacyBuy(character);
               } else
               {
                   System.out.println("Вам не хватает монет!");
                   Menu(character);
               }
           }
           case 2:
           {
               break;
           }
       }

    }
    public static void warriorBuy(Warrior warrior)
    {
        warriorList();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        if(scanner.hasNextInt())
        {
            choice = scanner.nextInt();
        }
        switch (choice)
        {
            case 1:
            {
                if(warrior.getCoins() >= 5000)
                {
                    warrior.setCoins(warrior.getCoins()-5000);
                    System.out.println("Куплено!");
                    System.out.println("Теперь денег: " + warrior.getCoins());
                    warrior.setWeapon(Weapon.AXE_OF_OMNIPOTENCE);
                    break;
                }
            }
            case 2:
            {
                if(warrior.getCoins() >= 4000)
                {
                    warrior.setCoins(warrior.getCoins()-4000);
                    System.out.println("Куплено!");
                    System.out.println("Теперь денег: " + warrior.getCoins());
                    warrior.setWeapon(Weapon.SWORD_OF_GRAND_WARRIOR);
                    break;
                }
            }
            case 3:
            {
                if(warrior.getCoins() >= 1000)
                {
                    warrior.setCoins(warrior.getCoins()-1000);
                    System.out.println("Куплено!");
                    System.out.println("Теперь денег: " + warrior.getCoins());
                    warrior.setWeapon(Weapon.STEEL_SWORD);
                    break;
                }
            }
            case 4:
            {
                break;
            }
            default:
            {
                warriorBuy(warrior);
            }
        }

    }
    public static void pharmacyList()
    {
        System.out.println("Можно приобрести следующие предметы: \n");
        System.out.println("1. " + Color.ANSI_GREEN + "Хилочка" + Color.ANSI_RESET + "\n");
        System.out.println("2. Выход");
    }
    public static void warriorList()
    {
        System.out.println("Можно приобрести следующие предметы: \n");
        System.out.println("1. " + Color.ANSI_RED + "Cекира всевластия" + Color.ANSI_RESET + "\n");
        System.out.println("2. " + Color.ANSI_PURPLE + "Меч грандмастера" + Color.ANSI_RESET + "\n");
        System.out.println("3. " + Color.ANSI_BLUE + "Стальной меч" + Color.ANSI_RESET + "\n");
        System.out.println("4. Выход");
    }
}
