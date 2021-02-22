package com.Tocks.Menu;

import com.Tocks.Color.Color;
import com.Tocks.HeroStatus.Status;
import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.Monster.Size;
import com.Tocks.Inheritance.Monster.SlowMonster;
import com.Tocks.Inheritance.Warrior.Warrior;
import com.Tocks.Inheritance.Warrior.Weapon;
import com.Tocks.Inheritance.Wizard.Magic;
import com.Tocks.Inheritance.Wizard.Wizard;
import com.Tocks.Shop.Shop;

import java.util.Scanner;

public class Menu
{
    public static void Menu(Character character, Status status)
    {
        int choice = 0;
        System.out.println("Выберите пункт:\n1. Магазин\n2. Путь война - Сразитесь с Великим мастером меча!\n3. Путь мага - Сразитесь с Великим магистром огня!\n4. Путь монстра - Победите жуткого монстра!\n");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt())
        {
            choice = scanner.nextInt();
        }
        else
        {
            System.out.println("Попробуйте ещё раз!");
            System.out.flush();
            Menu(character, status);
        }
        switch (choice)
        {
            case 1:
            {
                System.out.println("Открыт магазин.");
                Shop.Menu(character);
                Menu(character,status);
                break;
            }
            case 2:
            {
                System.out.println(Color.ANSI_BLUE + "Вы бросили вызов великому войну, который пережил множество битв, сможете ли вы противостоять ему?..." + Color.ANSI_RESET);
                Warrior warrior = new Warrior(Color.ANSI_RED + "Великий мастер меча" + Color.ANSI_RESET, 1000,15,100,0, Weapon.SWORD,"None");
                System.out.println("Великий мастер меча говорит: " + Color.ANSI_YELLOW + "\"Ты, челядь поганная, посмел бросить мне вызов?! \nБеги к мамке пока зубы на месте!\"" + Color.ANSI_RESET);
                character.fight(warrior);
                status.load(character);
                Menu(character, status);
                break;
            }
            case 3:
            {
                System.out.println(Color.ANSI_BLUE + "Вы открываете двери разрушенной, некогда великой библиотеки, во время наступления магов, внутри вы встречаете магистра ордена..." + Color.ANSI_RESET);
                Wizard wizard = new Wizard(Color.ANSI_CYAN + "Великий магистр огня" + Color.ANSI_RESET,500,70,30,0, Magic.FIRE);
                System.out.println("Великий магистр огня говорит: " + Color.ANSI_YELLOW + "\"Недоумок, опусти оружие или я сплавлю тебя вместе с ним!\"" + Color.ANSI_RESET);
                character.fight(wizard);
                status.load(character);
                Menu(character, status);
                break;
            }
            case 4:
            {
                System.out.println(Color.ANSI_BLUE + "На окраине деревни вы встречаете жуткого монстра, который мучает жителей окрестных земель, хватит ли у вас сил чтобы убить его?" + Color.ANSI_RESET);
                SlowMonster monster = new SlowMonster(Color.ANSI_PURPLE + "Монструозный кракозябр" + Color.ANSI_RESET,1500,2,100,0,1,1,1, Size.STANDART);
                System.out.println("Монструозный кракозябр говорит: " + Color.ANSI_YELLOW + "\"*Нервно хлюпает и рычит*\"" + Color.ANSI_RESET);
                character.fight(monster);
                status.load(character);
                Menu(character, status);
                break;
            }
            default:
            {
                Menu(character, status);
            }
        }
    }
}
