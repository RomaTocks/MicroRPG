package com.Tocks.Inheritance.Warrior;

public enum Weapon
{
    AXE_OF_OMNIPOTENCE,
    SWORD_OF_GRAND_WARRIOR,
    STEEL_SWORD,
    BOW,
    SWORD,
    HATCHET
}
class Weapons
{
    public static int weaponDamage(Warrior warrior)
    {
        int weaponDamage = 0;
        if(warrior.weapon == Weapon.BOW)
        {
            weaponDamage = 15;
        }
        if(warrior.weapon == Weapon.HATCHET)
        {
            weaponDamage = 35;
        }
        if(warrior.weapon == Weapon.SWORD)
        {
            weaponDamage = 30;
        }
        if(warrior.weapon == Weapon.SWORD_OF_GRAND_WARRIOR)
        {
            weaponDamage = 70;
        }
        if(warrior.weapon == Weapon.AXE_OF_OMNIPOTENCE)
        {
            weaponDamage = 90;
        }
        if(warrior.weapon == Weapon.STEEL_SWORD)
        {
            weaponDamage = 50;
        }
        return weaponDamage;
    }
}

