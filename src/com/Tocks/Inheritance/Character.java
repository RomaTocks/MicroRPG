package com.Tocks.Inheritance;

import java.util.Scanner;

public abstract class Character implements ICharacter, IObject, Cloneable
{
    private String name;
    private int healthPoints;
    private int agility;
    private int strength;
    private int countOfHealthPacks;
    private int coins = 10000;

    public Character(String name, int healthPoints, int agility, int strength, int countOfHealthPacks)
    {
        this.name = name;
        this.healthPoints = healthPoints;
        this.agility = agility;
        this.strength = strength;
        this.countOfHealthPacks = countOfHealthPacks;
    }

    public String getName()
    {
        return name;
    }

    public int getHealthPoints()
    {
        return healthPoints;
    }

    public int getAgility()
    {
        return agility;
    }

    public int getStrength()
    {
        return strength;
    }

    public int getCountOfHealthPacks()
    {
        return countOfHealthPacks;
    }

    public int getCoins()
    {
        return coins;
    }

    public void setCoins(int coins)
    {
        this.coins = coins;
    }

    public void setCountOfHealthPacks(int countOfHealthPacks)
    {
        this.countOfHealthPacks = countOfHealthPacks;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setHealthPoints(int healthPoints)
    {
        this.healthPoints = healthPoints;
    }

    public void setAgility(int agility)
    {
        this.agility = agility;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    @Override
    public void attack(Character character)
    {
  /*      double random = Math.random() * (6 - (int)(character.getAgility() / 10) );
        int damage = (int)(15 + this.getStrength() * 0.3);

        System.out.println("Индекс урона: " + random);
        if(random > (6 - (int)(character.getAgility() / 10)) - 1)
        {
            System.out.println("Вы промахнулись!");
        }
        else
        {
            if(random < 2)
            {
                damage += (int)(damage * 0.5);
                System.out.println("OMG, Мощная атака!!!");
            }
            character.setHealthPoints(character.getHealthPoints() - damage);
            System.out.println("Персонажу " + character.getName() + " Нанесён базовый урон в размере "+ damage + " !!!");
            System.out.println("Теперь здоровье равно " + character.getHealthPoints());
        }*/

        System.out.println();
    }

    @Override
    public void useHealthPack()
    {
        if(this.getCountOfHealthPacks() > 0)
        {
            System.out.println("[ Ваше здоровье увеличено на 150!!! ]");
            this.setHealthPoints(this.getHealthPoints()+150);
            this.setCountOfHealthPacks(this.getCountOfHealthPacks()-1);
        }
        else
        {
            System.out.println("А хилочки то кончились, а всё, всё уже...");
        }
    }

    @Override
    public void fight(Character character)
    {
        while (true)
        {
            this.attack(character);
            character.attack(this);
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if(choice.equals("1"))
            {
                this.useHealthPack();
            }
            if(character.getHealthPoints() < 0)
            {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("Победил: " + this.getName() + ", теперь кол-во монет: " + this.getCoins());
                System.out.println("-------------------------------------------------------------------------");
                this.setCoins(this.getCoins()+250);
                break;
            }
            else
            {
                if(this.getHealthPoints() < 0)
                {
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Победил: " + character.getName());
                    System.out.println("-------------------------------------------------------------------------");
                    break;
                }
            }
        }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
