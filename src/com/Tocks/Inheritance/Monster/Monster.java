package com.Tocks.Inheritance.Monster;

import com.Tocks.Inheritance.Character;
import com.Tocks.Inheritance.ICharacter;
import com.Tocks.Inheritance.IObject;

public abstract class Monster extends Character implements ICharacter, IObject
{
    private int lengthOfTeeth;
    private int numberOfTeeth;
    private int numberOfPaws;

    public Monster(String name, int healthPoints, int agility, int strength, int countOfHealthPacks, int lengthOfTeeth, int numberOfTeeth, int numberOfPaws)
    {
        super(name, healthPoints, agility, strength, countOfHealthPacks);
        this.lengthOfTeeth = lengthOfTeeth;
        this.numberOfTeeth = numberOfTeeth;
        this.numberOfPaws = numberOfPaws;
    }

    public int getLengthOfTeeth()
    {
        return lengthOfTeeth;
    }

    public void setLengthOfTeeth(int lengthOfTeeth)
    {
        this.lengthOfTeeth = lengthOfTeeth;
    }

    public int getNumberOfTeeth()
    {
        return numberOfTeeth;
    }

    public void setNumberOfTeeth(int numberOfTeeth)
    {
        this.numberOfTeeth = numberOfTeeth;
    }

    public int getNumberOfPaws()
    {
        return numberOfPaws;
    }

    public void setNumberOfPaws(int numberOfPaws)
    {
        this.numberOfPaws = numberOfPaws;
    }

    @Override
    public void fight(Character firstCharacter)
    {
        super.fight(firstCharacter);
    }
}
