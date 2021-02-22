package com.Tocks;

import com.Tocks.Color.Color;
import com.Tocks.HeroStatus.Status;
import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.Monster.Size;
import com.Tocks.Inheritance.Monster.SlowMonster;
import com.Tocks.Inheritance.Warrior.Warrior;
import com.Tocks.Inheritance.Warrior.Weapon;
import com.Tocks.Inheritance.Wizard.Magic;
import com.Tocks.Inheritance.Wizard.Wizard;
import com.Tocks.Menu.Menu;

import java.awt.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Status status = new Status();
        Character hero = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбери класс:\n1. " + Color.ANSI_RED + "Воин\n" + Color.ANSI_RESET + "2." + Color.ANSI_BLUE + " Маг" + Color.ANSI_RESET);
        int choice = 0;
        if(scanner.hasNextInt())
        {
            choice = scanner.nextInt();
        }
        else
        {
            System.out.println("Попробуйте ещё раз!");
            System.out.flush();
        }
        try
        {
            switch (choice)
            {
                case 1:
                {
                    hero = new Warrior(Color.ANSI_YELLOW + "Герой" + Color.ANSI_RESET,700,40,100,3,Weapon.HATCHET,"Shield");
                    status.save(hero);
                    break;
                }
                case 2:
                {
                    hero = new Wizard(Color.ANSI_YELLOW + "Герой" + Color.ANSI_RESET,500,99,50,3,Magic.FIRE);
                    status.save(hero);
                    break;
                }
            }
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        Menu.Menu(hero, status);
        // write your code here
        //Character character = new Character("Рома",100,10, 30);
        //Character bird = new Character("Индюк",100, 10, 20);
        /*Wizard wizard = new Wizard("Инокентий", 150,150,15, Magic.FIRE);
        Warrior warrior = new Warrior("Виталя", 200, 15, 55, Weapon.SWORD, "Обычный");

        while (warrior.getHealthPoints() > 0 || wizard.getHealthPoints() > 0)
        {
            warrior.attack(wizard);
            wizard.attack(warrior);
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            if(warrior.getHealthPoints() <= 0)
            {
                System.out.println("Победил " + wizard.getName() + " !");

                break;
            }
            else
            {
               if(wizard.getHealthPoints() <= 0)
               {
                   System.out.println("Победил " + warrior.getName() + " !");

                   break;
               }
            }

        }
        SlowMonster slowMonster = new SlowMonster("Кракозябр",400,15,40,5,33,5, Size.BIGGEST);
        Warrior newWarrior = new Warrior("Максим",250,30,75,Weapon.HATCHET,"None");
        while (newWarrior.getHealthPoints() > 0 || slowMonster.getHealthPoints() > 0)
        {
            newWarrior.attack(slowMonster);
            slowMonster.attack(newWarrior);
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            if (newWarrior.getHealthPoints() <= 0)
            {
                System.out.println("Победил " + slowMonster.getName() + " !");

                break;
            } else
            {
                if (slowMonster.getHealthPoints() <= 0)
                {
                    System.out.println("Победил " + newWarrior.getName() + " !");

                    break;
                }
            }
        }*/
    }
}
