package com.Tocks.Inheritance.Warrior;

import com.Tocks.Color.Color;
import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.Wizard.Wizard;

public class Warrior extends Character
{
  public Weapon weapon;
  public String shield;

    public Warrior(String name, int healthPoints, int agility, int strength, int countOfHealthPacks, Weapon weapon, String shield)
    {
        super(name, healthPoints, agility, strength, countOfHealthPacks);
        this.weapon = weapon;
        this.shield = shield;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }

    public String getShield()
    {
        return shield;
    }

    public void setShield(String shield)
    {
        this.shield = shield;
    }
    @Override
    public void attack(Character character)
    {
        double random = Math.random() * (6 - (int)(character.getAgility() / 100) );
        int damage = (int)(15 + this.getStrength() * 0.3);

        System.out.println("Индекс атаки: " + random);
        if(random > (6 - (int)(character.getAgility() / 100)) - 1)
        {
            System.out.println(this.getName() + " промахнулся!");
        }
        else
        {
            if(random < 1)
            {
                damage += (int)(damage * 0.5);
                System.out.println("OMG, Мощная атака!!!");
            }
            character.setHealthPoints(character.getHealthPoints() - (damage + Weapons.weaponDamage(this)));
            System.out.println(this.getName() + " наносит персонажу " + character.getName() + " урон в размере: "+ damage + "+" + Weapons.weaponDamage(this) + " дополнительного физического урона !!!");
            System.out.println("Теперь здоровье " + character.getName() + " равно: "+ Color.ANSI_GREEN + character.getHealthPoints() + Color.ANSI_RESET);
        }

        System.out.println();
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

    }
    public Warrior clone() throws CloneNotSupportedException
    {
        return (Warrior) super.clone();
    }
}
