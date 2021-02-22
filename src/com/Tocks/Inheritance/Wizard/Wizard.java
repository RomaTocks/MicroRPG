package com.Tocks.Inheritance.Wizard;

import com.Tocks.Color.Color;
import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.ICharacter;
import com.Tocks.Inheritance.Warrior.Weapon;

public class Wizard extends Character
{

    private Magic typeOfMagic;

    public Wizard(String name, int healthPoints, int agility, int strength, int countOfHealthPacks, Magic typeOfMagic)
    {
        super(name, healthPoints, agility, strength, countOfHealthPacks);
        this.typeOfMagic = typeOfMagic;
    }

    public Magic getTypeOfMagic()
    {
        return typeOfMagic;
    }

    public void setTypeOfMagic(Magic typeOfMagic)
    {
        this.typeOfMagic = typeOfMagic;
    }

    private int magicDamage()
    {
        int magicDamage = 0;
        if(this.typeOfMagic == Magic.FIRE)
        {
            magicDamage = 50;
        }
        if(this.typeOfMagic == Magic.CRYO)
        {
            magicDamage = 35;
        }
        if(this.typeOfMagic == Magic.TERRA)
        {
            magicDamage = 30;
        }
        if(this.typeOfMagic == Magic.WATER)
        {
            magicDamage = 5;
        }
        return magicDamage;
    }

    @Override
    public void attack(Character character)
    {
        //super.attack(character);
        double random = Math.random() * (6 - (int) (character.getAgility() / 100));
        int damage = (int) (15 + this.getStrength() * 0.3);

        System.out.println("Индекс атаки: " + random);
        if (random > (6 - (int) (character.getAgility() / 100)) - 1)
        {
            System.out.println( this.getName() + " промахнулся!");
        } else
        {
            if (random < 1)
            {
                damage += (int) (damage * 0.5);
                System.out.println("OMG, Мощная атака!!!");
            }
            character.setHealthPoints(character.getHealthPoints() - (damage + magicDamage()));
            System.out.println(this.getName() + " наносит персонажу " + character.getName() + " урон в размере: " + damage + "+" + magicDamage() + " дополнительного магического урона !!!");
            System.out.println("Теперь здоровье " + character.getName() + " равно: "+ Color.ANSI_GREEN + character.getHealthPoints() + Color.ANSI_RESET);
        }
    }

    @Override
    public void fight(Character firstCharacter)
    {
        super.fight(firstCharacter);
    }

    @Override
    public void useHealthPack()
    {
        super.useHealthPack();
    }

    @Override
    public void print()
    {
        System.out.println("Персонаж: " + this.getName());
        System.out.println("Здоровье: " + this.getHealthPoints());
        System.out.println("Ловкость: " + this.getAgility());
        System.out.println("Сила: " + this.getStrength());
        System.out.println("Тип магии: " + this.getTypeOfMagic());
    }
    public Wizard clone() throws CloneNotSupportedException
    {
        return (Wizard)super.clone();
    }
}
