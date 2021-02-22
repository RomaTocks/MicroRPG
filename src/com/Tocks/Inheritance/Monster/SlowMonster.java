package com.Tocks.Inheritance.Monster;

import com.Tocks.Color.Color;
import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.Warrior.Weapon;
import com.Tocks.Inheritance.Wizard.Wizard;

public class SlowMonster extends Monster
{
    private Size size;

    public SlowMonster(String name, int healthPoints, int agility, int strength,int countOfHealthPacks, int lengthOfTeeth, int numberOfTeeth, int numberOfPaws, Size size)
    {
        super(name, healthPoints, agility, strength, countOfHealthPacks, lengthOfTeeth, numberOfTeeth, numberOfPaws);
        this.size = size;
    }

    public Size getSize()
    {
        return size;
    }

    public void setSize(Size size)
    {
        this.size = size;
    }

    public int SizeCheck()
    {
        int sizeDebuff = 0;
        if(this.size == Size.SMALL)
        {
            sizeDebuff = 1;
        }
        if(this.size == Size.STANDART)
        {
            sizeDebuff = 2;
        }
        if(this.size == Size.BIG)
        {
            sizeDebuff = 3;
        }
        if(this.size == Size.BIGGEST)
        {
            sizeDebuff = 4;
        }
        return sizeDebuff;
    }
    @Override
    public void attack(Character character)
    {
        double random = Math.random() * (8 - (int)(character.getAgility() / 100));
        int damage = (int)(10 + (this.getNumberOfPaws() * 1) + (this.getNumberOfTeeth() * 1) + (this.getStrength() * 0.3));

        System.out.println("Индекс урона: " + random);
        if(random > (8 - (int)(character.getAgility() / 100) - SizeCheck()) - 1)
        {
            System.out.println(this.getName() + " промахнулcя!");
        }
        else
        {
            if (random < 2)
            {
                damage += (int) (damage * 0.5);
                System.out.println("OMG, Мощная атака!!!");
            }
            character.setHealthPoints(character.getHealthPoints() - damage);
            System.out.println("Персонажу " + character.getName() + " Нанесён базовый урон в размере " + damage + " !!!");
            System.out.println("Теперь здоровье " + character.getName() + " равно: "+ Color.ANSI_GREEN + character.getHealthPoints() + Color.ANSI_RESET);
            double currentLifeSteal = character.getHealthPoints() * 0.05;
            this.setHealthPoints(this.getHealthPoints() + (int) currentLifeSteal);
            System.out.println("Кража жизни 5%!!! Теперь здоровье " + this.getName() + " равно: " + Color.ANSI_RED + this.getHealthPoints() + Color.ANSI_RESET);
        }
    }

    @Override
    public void fight(Character firstCharacter)
    {
        super.fight(firstCharacter);
    }

    @Override
    public void print()
    {

    }
    public SlowMonster clone() throws CloneNotSupportedException
    {
        return (SlowMonster) super.clone();
    }
}
