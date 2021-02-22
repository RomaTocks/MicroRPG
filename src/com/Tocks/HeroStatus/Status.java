package com.Tocks.HeroStatus;

import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.Warrior.Warrior;
import com.Tocks.Inheritance.Wizard.Wizard;

public class Status
{
    private Wizard wizard;
    private Warrior warrior;

    public Wizard getWizard()
    {
        return wizard;
    }

    public void setWizard(Wizard wizard)
    {
        this.wizard = wizard;
    }

    public Warrior getWarrior()
    {
        return warrior;
    }

    public void setWarrior(Warrior warrior)
    {
        this.warrior = warrior;
    }
    public void save(Character character) throws CloneNotSupportedException
    {
        if(character instanceof Warrior)
        {
            setWarrior(((Warrior) character).clone());
        }
        if(character instanceof Wizard)
        {
            setWizard(((Wizard) character).clone());
        }
    }
    public void load(Character character)
    {
        if(character instanceof Warrior)
        {
            character.setHealthPoints(getWarrior().getHealthPoints());
        }
        if(character instanceof Wizard)
        {
            character.setHealthPoints(getWizard().getHealthPoints());
        }
    }
    public void printStatus()
    {
        if(warrior != null)
        {
            System.out.println("Warrior: " + warrior.getName() + " " + warrior.getHealthPoints());
        }
        if(wizard != null)
        {
            System.out.println("Wizard: " + wizard.getName() + " " + wizard.getHealthPoints());
        }
    }
}
