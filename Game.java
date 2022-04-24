/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author C
 */
public class Game {
    
    int sticks;
    
    public Game()
    {
        System.out.println("Welcome to the game of Pickup Sticks!");
        System.out.println("You may only pick up between 1 and 3 sticks per turn");
        System.out.println("The objective is make your opponent pick up the last stick");
    }
    
    public int getSticks()
    {
        return sticks;
    }
    
    public void setNumberOfSticks(int sticks)
    {
        this.sticks = sticks;
    }
    
    public int getSticksInput()
    {
        System.out.println("Enter the number of sticks (10-100):");
        Scanner in = new Scanner(System.in);
        int input; 
        try
        {
            input = in.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Your entry is not valid!");
            return getSticksInput();
        }
        if(input >= 10 && input <= 100)
        {
            setNumberOfSticks(input);
            return input;
        }
        else
        {
            System.out.println("Please enter a number in the correct range!");
            return getSticksInput();
        }
    }
    
    
}