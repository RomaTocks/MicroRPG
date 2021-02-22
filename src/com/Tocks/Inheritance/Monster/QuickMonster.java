package com.Tocks.Inheritance.Monster;

import com.Tocks.Color.Color;
import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.Wizard.Wizard;

public class QuickMonster extends Monster
{
    private int speed;

    public QuickMonster(String name, int healthPoints, int agility, int strength, int countOfHealthPacks, int lengthOfTeeth, int numberOfTeeth, int numberOfPaws, int speed)
    {
        super(name, healthPoints, agility, strength, countOfHealthPacks, lengthOfTeeth, numberOfTeeth, numberOfPaws);
        this.speed = speed;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    @Override
    public void attack(Character character)
    {
        double random = Math.random() * (6 - (int)(character.getAgility() / 10));
        int damage = (int)(15 + this.getStrength() * 0.3);

        System.out.println("Индекс урона: " + random);
        if(random > (6 - (int)(character.getAgility() / 10)) - 1)
        {
            System.out.println("Вы промахнулись!");
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
            this.setHealthPoints(this.getHealthPoints() + (int)currentLifeSteal);
            System.out.println("Кража жизни 5%!!! Теперь здоровье" + this.getName() + "равно: " + this.getHealthPoints());
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
    public QuickMonster clone() throws CloneNotSupportedException
    {
        return (QuickMonster) super.clone();
    }
}
